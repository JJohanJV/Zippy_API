package com.zippy.api.dto;

import com.zippy.api.constants.VehicleStatus;
import com.zippy.api.constants.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class VehicleDTO {
    private VehicleType type;
    private String model;
    private String serial;
    private String gpsSerial;
    private VehicleStatus status;
    private LocalDateTime startUpDate;
    private boolean isElectric;
    private int battery;
}
