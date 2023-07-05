package com.zippy.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import com.zippy.api.constants.VehicleType;
import com.zippy.api.constants.VehicleStatus;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VehicleDTO {
    private VehicleType type;
    private String model;
    private String serial;
    private String gps_serial;
    private VehicleStatus status;
    private LocalDateTime start_up_date;
    private boolean is_electric;
    private int battery;
    private List<Maintenance> maintenances;

}
