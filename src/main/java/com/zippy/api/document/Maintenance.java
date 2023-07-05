package com.zippy.api.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@AllArgsConstructor
public class Maintenance {

    @Id
    private ObjectId id;
    @NotNull
    private Date date;
    @NotNull
    private String report;
    @NotNull
    private String reason;
    private int kilometers;
    @NotNull
    private ObjectId employee_id;
    private double cost;

}