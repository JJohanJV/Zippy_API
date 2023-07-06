package com.zippy.api.document;

import com.zippy.api.constants.TripStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDateTime;
import java.util.Date;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trip {

    @Id
    private  ObjectId id;
    @DocumentReference
    private User userId;
    @DocumentReference
    private Vehicle vehicleId;
    @DocumentReference
    private Station startStationId;
    @DocumentReference
    private Station finishStationId;
    private double cost;
    private TripStatus status;
    private LocalDateTime reservedDate;
    private LocalDateTime deadLine;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Report report;
    private int userRating;
    private String userComment;


}
