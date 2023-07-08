package com.zippy.api.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document
@NoArgsConstructor
public class BillingInformation {
    @Id
    private ObjectId id;
}
