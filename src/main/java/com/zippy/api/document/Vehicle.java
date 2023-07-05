package com.zippy.api.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;


import java.util.Date;
import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    @Id
    private ObjectId id;
    @Indexed(unique = true)
    private String serial;
    @Indexed(unique = true)
    private String gps_serial;
    private String model;
    private String type;
    private String status;
    private int Kilometers;
    private LocalDateTime start_up_date;
    private boolean is_electric;
    private int battery;
    private List<Maintenance> maintenances;

}

