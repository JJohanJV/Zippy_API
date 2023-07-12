package com.zippy.api.rest;

import com.zippy.api.document.Trip;
import com.zippy.api.document.Vehicle;
import com.zippy.api.service.TripService;
import com.zippy.api.service.VehicleService;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;
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
        return ResponseEntity.ok(tripService.calculateCost(BigDecimal.valueOf(2)));
    };
}
