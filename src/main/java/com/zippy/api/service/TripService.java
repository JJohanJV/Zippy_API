package com.zippy.api.service;

import com.zippy.api.constants.TripStatus;
import com.zippy.api.document.Trip;
import com.zippy.api.exception.StationNotFoundException;
import com.zippy.api.repository.TripRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDateTime;


@Service
public class TripService {

    private final TripRepository tripRepository;
    private final VehicleService vehicleService;

    public TripService(TripRepository tripRepository, VehicleService vehicleService) {
        this.tripRepository = tripRepository;
        this.vehicleService = vehicleService;
    }
    public Trip getTripById(ObjectId tripId) throws StationNotFoundException {
        return tripRepository.findById(tripId).orElseThrow(() -> new StationNotFoundException("El id de la estación no existe"));
    }
    //Instant creation of a travel
    public Trip createTrip (
            ObjectId userid, ObjectId vehicleId, ObjectId startStationId, ObjectId endStationId, BigDecimal distance, int duration) {

        return(
                tripRepository.insert(
                        new Trip(userid, vehicleId, startStationId, endStationId, LocalDateTime.now(), TripStatus.ACTIVE, calculateInitialCost(distance, vehicleId), calculateDeadline(duration))
                )
        );

    }

    public BigDecimal calculateInitialCost (BigDecimal distance, ObjectId vehicleId) {

        //Cheaper price for Not electric vehicles
        boolean isElectric = vehicleService.getVehicleById(vehicleId).isElectric();
        BigDecimal baseCost = isElectric ? BigDecimal.valueOf(1000) : BigDecimal.valueOf(500);

        //Se calcula proporcional al precio base, tomando la distacia en kilometros dividida en 100 y multiplicada por un factor aumentador del precio
        int multiplyCostFactor = 2;
        return baseCost.add(baseCost.multiply(distance.divide(BigDecimal.valueOf(100 / multiplyCostFactor), 2, RoundingMode.HALF_UP)));
    }

    public BigDecimal calculateFinalCost (LocalDateTime deadline, BigDecimal initialCost){

        BigDecimal priceExtraMinute =  BigDecimal.valueOf(50);

        if(deadline.isBefore(LocalDateTime.now())) {
            BigDecimal minutesDifference = BigDecimal.valueOf(Duration.between(deadline, LocalDateTime.now()).toMinutes());
            initialCost = initialCost.add(minutesDifference.multiply(priceExtraMinute));
        }
        return initialCost;
    }

    public BigDecimal calculateFinalCost (ObjectId tripId){

        BigDecimal initialCost = getTripById(tripId).getCost();
        LocalDateTime deadline = getTripById(tripId).getDeadLine();

        BigDecimal priceExtraMinute =  BigDecimal.valueOf(50);

        if(deadline.isBefore(LocalDateTime.now())) {
            BigDecimal minutesDifference = BigDecimal.valueOf(Duration.between(deadline, LocalDateTime.now()).toMinutes());
            initialCost = initialCost.add(minutesDifference.multiply(priceExtraMinute));
        }
        return initialCost;
    }


    public LocalDateTime calculateDeadline(int duration){

        //Extra minutes without an additional cost that user will have in case of traffic or personal circumstances
        int marginMinutes = 10;

        return LocalDateTime.now().plusMinutes(duration+marginMinutes);

    }
}
