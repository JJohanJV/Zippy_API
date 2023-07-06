package com.zippy.api.service;

import com.zippy.api.document.Station;
import com.zippy.api.document.Vehicle;
import com.zippy.api.repository.StationRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StationService {
    private final StationRepository stationRepository;

    @Autowired
    public StationService(StationRepository stationRepository){
        this.stationRepository = stationRepository;
    }

    public Station addStation(Station station) {
        return stationRepository.save(station);
    }

    public void deleteStationById(String id) {
        stationRepository.deleteById(new ObjectId(id));
    }

    public Station getStationById(String id) {
        return stationRepository.findById(new ObjectId(id)).orElse(null);
    }

    public Station getStationByName(String name) {
        return stationRepository.findByName(name);
    }

    public Station addVehicleToStation(String stationId, Vehicle vehicle) {
        Station station = stationRepository.findById(new ObjectId(stationId)).orElse(null);
        if (station == null) {
            return null;
        }
        station.getVehicles().add(vehicle);
        return stationRepository.save(station);
    }
}
