package com.zippy.api.service;

import com.zippy.api.document.Vehicle;
import com.zippy.api.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;
    public List<Vehicle> allVehicles(){
        return vehicleRepository.findAll();

    }

}