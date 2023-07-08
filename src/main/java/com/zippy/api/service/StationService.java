package com.zippy.api.service;

import com.zippy.api.document.Station;
import com.zippy.api.exception.StationNotFoundException;
import com.zippy.api.repository.StationRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void deleteStationById(ObjectId id) {
        stationRepository.deleteById(id);
    }

    public Station getStationById(ObjectId id) {
        return stationRepository.findById(id).orElse(null);
    }

    public Station getStationByName(String name) {
        return stationRepository.findByName(name);
    }

    public Station addVehicleToStation(ObjectId stationId, ObjectId vehicle) throws StationNotFoundException {
        Station station = stationRepository.findById(stationId)
                .orElseThrow(() -> new StationNotFoundException("El id de la estación no existe"));
        station.getVehicles().add(vehicle);
        return stationRepository.save(station);
    }

    public Station removeVehicleFromStation(ObjectId stationId, ObjectId vehicle) throws StationNotFoundException {
        Station station = stationRepository.findById(stationId)
                .orElseThrow(() -> new StationNotFoundException("El id de la estación no existe"));
        station.getVehicles().remove(vehicle);
        return stationRepository.save(station);
    }

    public List<ObjectId> getAvaliblesVehiclesFromStation(ObjectId stationId) throws StationNotFoundException {
        Station station = stationRepository.findById(stationId)
                .orElseThrow(() -> new StationNotFoundException("El id de la estación no existe"));
        return station.getVehicles();
    }
}
