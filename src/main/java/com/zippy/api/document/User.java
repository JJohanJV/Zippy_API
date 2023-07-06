package com.zippy.api.document;

import com.zippy.api.constants.DocumentType;
import com.zippy.api.models.Address;
import com.zippy.api.models.BackupPerson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private ObjectId credentialsId;
    private String name;
    private String lastname;
    private LocalDateTime birthdate;
    private String occupation;
    private String email;
    private String phone;
    private String document;
    private DocumentType documentType;
    @Id
    private ObjectId billingInformationId;
    private BackupPerson backupPerson;
    private Address address;

}
