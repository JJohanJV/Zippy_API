package com.zippy.api.dto;

import com.zippy.api.constants.DocumentType;
import com.zippy.api.models.*;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
public class UserDTO {
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String name;
    @NotBlank
    private String lastname;
    @NotBlank
    private LocalDateTime birthday;
    @NotBlank
    private String occupation;
    @NotBlank
    private String document;
    @NotBlank
    private DocumentType documentType;
    @NotBlank
    private Address address;
    @NotBlank
    private String phone;
    @NotBlank
    private BackupPerson backupPerson;

    public UserDTO (String email, String name, String lastname, LocalDateTime birthday, String occupation,
                    String document, DocumentType documentType, String phone, String cityName, int cityId,
                    String addressDetail, String backUpPersonName, String backUpPersonLastName, String backUpPersonPhone,
                    String backUpPersonEmail, String backUpPersonDocument, DocumentType backUpPersonDocumentType ){
        this.backupPerson = new BackupPerson(backUpPersonName, backUpPersonLastName, backUpPersonPhone, backUpPersonEmail,
                backUpPersonDocument, backUpPersonDocumentType);
        this.address = new Address(addressDetail, new City(cityId,cityName), new Country(57,"Colombia"),
                new State(39, "Santander"));
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.birthday = birthday;
        this.occupation = occupation;
        this.document = document;
        this.documentType = documentType;
        this.phone = phone;
    }

}
