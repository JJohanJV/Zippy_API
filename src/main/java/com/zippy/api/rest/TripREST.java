package com.zippy.api.rest;

import com.zippy.api.document.Credential;
import com.zippy.api.document.RefreshToken;
import com.zippy.api.document.Trip;
import com.zippy.api.document.Vehicle;
import com.zippy.api.dto.TripDTO;
import com.zippy.api.dto.UpdateDTO;
import com.zippy.api.service.TripService;
import com.zippy.api.service.VehicleService;
import org.bson.types.ObjectId;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/trip")
public class TripREST {

    private final TripService tripService;

    public TripREST(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping("/pruebaRapida")
    public ResponseEntity<BigDecimal> calculateCost() {
        return ResponseEntity.ok(tripService.calculateFinalCost(LocalDateTime.now().minusMinutes(30), BigDecimal.valueOf(1340)));
    };

    @PostMapping("/startNewTrip")
    public ResponseEntity<?> startNewTrip (@AuthenticationPrincipal Credential credential , @NotNull @Valid @RequestBody TripDTO dto){
        return ResponseEntity.ok(tripService.createTrip(credential.getUserId(), dto.getVehicleId(), dto.getStartStationId(), dto.getEndStationId(), dto.getDistance(), dto.getDuration()));
    };

}
