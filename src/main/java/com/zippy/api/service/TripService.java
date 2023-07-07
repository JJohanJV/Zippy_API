package com.zippy.api.service;

import com.zippy.api.document.Station;
import com.zippy.api.document.Trip;
import com.zippy.api.repository.StationRepository;
import com.zippy.api.repository.TripRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Optional;


@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private StationRepository stationRepository;

    //Creación inicial del viaje
    public Trip createTrip (ObjectId userid, ObjectId vehicleId, ObjectId startStationId, ObjectId endStationId){

        DecimalFormat cost = cost(startStationId, endStationId);
        Trip trip = tripRepository.insert(new Trip(userid, vehicleId, startStationId,endStationId, cost));

        return(trip);
    }

    private DecimalFormat cost(ObjectId startStationId, ObjectId endStationId) {
        Optional<Station> startStation = stationRepository.findById(startStationId);
        Optional<Station> endStation = stationRepository.findById(endStationId);
        DecimalFormat cost = new DecimalFormat("0");
        if (startStation.isPresent() && endStation.isPresent()) {
            String startLocation = startStation.get().getLocation();
            String endLocation = endStation.get().getLocation();
            cost = cost.format(startLocation.distance(endLocation));
        }
        return cost;
    }
}
