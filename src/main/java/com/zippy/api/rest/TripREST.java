package com.zippy.api.rest;

import com.zippy.api.constants.VehicleStatus;
import com.zippy.api.document.Credential;
import com.zippy.api.dto.TripDTO;
import com.zippy.api.service.TripService;
import com.zippy.api.service.VehicleService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/trip")
public class TripREST {

    private final TripService tripService;
    private final VehicleService vehicleService;

    public TripREST(TripService tripService, VehicleService vehicleService) {
        this.tripService = tripService;
        this.vehicleService = vehicleService;
    }

    @GetMapping("/pruebaRapida")
    public ResponseEntity<BigDecimal> calculateCost() {
        return ResponseEntity.ok(tripService.calculateFinalCost(LocalDateTime.now().minusMinutes(30), BigDecimal.valueOf(1340)));
    };

    @PostMapping("/startNewTrip")
    public ResponseEntity<?> startNewTrip (@AuthenticationPrincipal Credential credential , @NotNull @Valid @RequestBody TripDTO dto) {
        if (vehicleService.getVehicleById(dto.getVehicleId()).getStatus() != VehicleStatus.AVAILABLE) {
            return ResponseEntity.badRequest().body("The status of the vehicle is not longer available");
        } else
            return ResponseEntity.ok(tripService.startTrip(credential.getUserId(), dto.getVehicleId(), dto.getStartStationId(), dto.getEndStationId(), dto.getDistance(), dto.getDuration()));
        }
    };
