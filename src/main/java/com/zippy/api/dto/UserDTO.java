package com.zippy.api.dto;

import com.zippy.api.constants.DocumentType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
public class UserDTO {
    @NotBlank
    private String email;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private LocalDateTime birthday;
    @NotBlank
    private String occupation;
    @NotBlank
    private String document;
    @NotBlank
    private DocumentType documentType;
    @NotBlank
    private AddressDTO address;
    @NotBlank
    private String phone;
    @NotBlank
    private BackupPersonDTO backupPerson;
}
