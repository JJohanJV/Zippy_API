package com.zippy.api.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.bson.types.ObjectId;

@Document
@Data
public class RefreshToken {
    @Id
    private ObjectId id;
    @DocumentReference(lazy = true)
    private Credential owner;
}