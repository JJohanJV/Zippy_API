package com.zippy.api.rest;

import com.zippy.api.document.Vehicle;
import com.zippy.api.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.zippy.api.dto.VehicleDTO;
@RestController
@RequestMapping("/api/vehicle")
public class VehicleREST {
    private final VehicleService vehicleService;

    @Autowired
    public VehicleREST(VehicleService vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Vehicle>> allVehicles() {
        return ResponseEntity.ok(vehicleService.allVehicles());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addVehicle(VehicleDTO dto){
        Vehicle vehicle = new Vehicle(dto.getType(), dto.getModel(),  dto.getGpsSerial(), dto.getSerial(),  dto.isElectric());
        vehicle.setBattery(
                dto.isElectric()
                        ? dto.getBattery()
                        : 0
        );
        return ResponseEntity.ok(vehicleService.addVehicle(vehicle));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable String id){
        vehicleService.deleteVehicleById(id);
        return ResponseEntity.ok().build();
    }
}
