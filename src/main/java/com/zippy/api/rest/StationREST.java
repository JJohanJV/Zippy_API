package com.zippy.api.rest;

import com.zippy.api.service.StationService;
import com.zippy.api.service.VehicleService;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stations")
public class StationREST {
    private final StationService stationService;
    private final VehicleService vehicleService;

    public StationREST(StationService stationService, VehicleService vehicleService) {
        this.stationService = stationService;
        this.vehicleService = vehicleService;
    }

//    @PostMapping("/{id}/add-vehicle/{vehicleId}")
//    public ResponseEntity<?> addVehicleToStationById(@PathVariable ObjectId id, @PathVariable ObjectId vehicleId) {
//        return ResponseEntity.ok(stationService.addVehicleToStation(id, vehicleId));
//    }

    @PostMapping("/{id}/add-vehicle/{VehicleSerial}")
    public ResponseEntity<?> addVehicleToStationBySerial(@PathVariable ObjectId id, @PathVariable String VehicleSerial) {
        return ResponseEntity.ok(stationService.addVehicleToStation(id, vehicleService.getVehicleBySerial(VehicleSerial).getId()));
    }

    @DeleteMapping("/{id}/remove-vehicle/{vehicleId}")
    public ResponseEntity<?> removeVehicleFromStation(@PathVariable ObjectId id, @PathVariable ObjectId vehicleId) {
        return ResponseEntity.ok(stationService.removeVehicleFromStation(id, vehicleId));
    }

//    @PostMapping("/add")
//    public ResponseEntity<?> addStation(@RequestBody StationDTO dto) {
//        return ResponseEntity.ok(stationService.addStation(name));
//    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<?> allStations() {
        return ResponseEntity.ok(stationService.allStations());
    }

    @GetMapping("/{id}/vehicles")
    public ResponseEntity<?> getVehiclesByStationId(@PathVariable ObjectId id) {
        return ResponseEntity.ok(stationService.getVehiclesByStationId(id));
    }

    @GetMapping("/{id}/available-vehicles")
    public ResponseEntity<?> getAvailableVehiclesByStationId(@PathVariable ObjectId id) {
        return ResponseEntity.ok(stationService.getAvailableVehiclesByStationId(id));
    }

}
