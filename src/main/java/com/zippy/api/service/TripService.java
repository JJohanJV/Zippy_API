package com.zippy.api.service;

import com.zippy.api.constants.TripStatus;
import com.zippy.api.document.Trip;
import com.zippy.api.repository.TripRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static java.lang.System.*;


@Service
public class TripService {

    private final TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    //Creación inicial del viaje
    public Trip createTrip (ObjectId userid, ObjectId vehicleId, ObjectId startStationId, ObjectId endStationId, BigDecimal distance, int duration){

        return(tripRepository.insert(new Trip(userid, vehicleId, startStationId, endStationId, calculateCost(distance), TripStatus.ACTIVE, calculateDeadline(duration))));
    }

    public BigDecimal calculateCost (BigDecimal distance) {

        BigDecimal cost = BigDecimal.valueOf(1000);
        int multiplyPriceFactor = 2;
        //Se calcula proporcional al precio base, tomando la distacia en kilometros dividida en 100 y multiplicada por un factor aumentador del precio
        cost = cost.add(cost.multiply(distance.divide(BigDecimal.valueOf(100/multiplyPriceFactor))));

        return cost;
    }


    private LocalDateTime calculateDeadline(int duration){

        int extraMinutes = 10;
        LocalDateTime deadline = LocalDateTime.now().plusMinutes(duration+extraMinutes);

        return deadline;

    }
}
