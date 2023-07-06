package com.zippy.api.service;

import com.zippy.api.document.Vehicle;
import com.zippy.api.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.bson.types.ObjectId;

import java.util.List;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> allVehicles(){
        return vehicleRepository.findAll();
    }

    public Object addVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public void deleteVehicleById(String id) {
        vehicleRepository.deleteById(new ObjectId(id));
    }

    public Vehicle getVehicleById(String id) {
        return vehicleRepository.findById(new ObjectId(id)).orElse(null);
    }
}