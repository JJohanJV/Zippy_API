package com.zippy.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import com.zippy.api.constants.VehicleType;
import com.zippy.api.constants.VehicleStatus;
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
