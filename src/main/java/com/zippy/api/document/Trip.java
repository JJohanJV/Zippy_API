package com.zippy.api.document;

import com.zippy.api.constants.TripStatus;
import com.zippy.api.models.Report;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.DecimalFormat;
import java.time.LocalDateTime;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trip {

    @Id
    private  ObjectId id;
    private ObjectId userId;
    private ObjectId vehicleId;
    private ObjectId startStationId;
    private ObjectId finishStationId;
    private DecimalFormat cost;
    private TripStatus status;
    private LocalDateTime reservedDate;
    private LocalDateTime deadLine;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Report report;
    private int userRating;
    private String userComment;


    public Trip(ObjectId userid, ObjectId vehicleId, ObjectId startStationId, ObjectId finishStationId, DecimalFormat cost, TripStatus status, LocalDateTime deadLine) {
        this.userId = userid;

    }
}
