package com.zippy.api.rest;

import com.zippy.api.service.StationService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StationREST {
    private final StationService stationService;

    public StationREST(StationService stationService){
        this.stationService = stationService;
    }
}
