package com.zippy.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class TripDTO {
    private ObjectId vehicleId;
    private ObjectId startStationId;
    private ObjectId endStationId;
    private BigDecimal distance;
    private int duration;
}
