package com.zippy.api.service;

import com.zippy.api.document.Vehicle;
import com.zippy.api.repository.VehicleRepository;
import org.springframework.stereotype.Service;
import org.bson.types.ObjectId;

import java.util.List;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> allVehicles(){
        return vehicleRepository.findAll();
    }

    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public void deleteVehicleById(ObjectId id) {
        vehicleRepository.deleteById(id);
    }

    public Vehicle getVehicleById(ObjectId id) {
        return vehicleRepository.findById(id).orElse(null);
    }


}