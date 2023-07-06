package com.zippy.api.rest;

import com.zippy.api.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StationREST {
    private final StationService stationService;
    @Autowired
    public StationREST(StationService stationService){
        this.stationService = stationService;
    }
}
