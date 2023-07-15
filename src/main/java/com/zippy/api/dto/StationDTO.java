package com.zippy.api.dto;

import com.zippy.api.constants.StationStatus;
import com.zippy.api.models.Location;
import com.zippy.api.models.VehicleStatusId;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@AllArgsConstructor

public class StationDTO {
    @NotBlank
    private String name;
    @NotNull
    private Location location;
    @NotBlank
    private int capacity;
    @NotNull
    private StationStatus status;
    private List<VehicleStatusId> vehicleStatusIdList;
}
