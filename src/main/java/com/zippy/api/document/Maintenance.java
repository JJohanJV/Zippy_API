package com.zippy.api.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@AllArgsConstructor
public class Maintenance {

    @Id
    private ObjectId id;
    private Date date;
    private String report;
    private String reason;
    private int kilometers;
    private ObjectId employee_id;
    private double cost;

}