package com.zippy.api.rest;

import com.zippy.api.document.Vehicle;
import com.zippy.api.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/zippy/vehicle")
public class VehicleREST {

    @Autowired
    private VehicleService vehicleService;
    @GetMapping
    public ResponseEntity<List<Vehicle>> allVehicles() {
        return new ResponseEntity<List<Vehicle>>(vehicleService.allVehicles(), HttpStatus.OK);
    }
}
