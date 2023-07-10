package com.zippy.api.models;

import com.zippy.api.constants.VehicleStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

@Getter
@Setter
@AllArgsConstructor
public class VehicleStatusId {
    private ObjectId vehicleId;
    private VehicleStatus status;
}
