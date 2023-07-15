package com.zippy.api.dto;

import com.zippy.api.constants.DocumentType;
import com.zippy.api.models.Address;
import com.zippy.api.models.BackupPerson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public class UserDTO {
    @NotBlank
    private String email;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime birthday;
    @NotBlank
    private String occupation;
    @NotBlank
    private String document;
    @NotBlank
    private DocumentType documentType;
    @NotNull
    private Address address;
    @NotBlank
    private String phone;
    @NotNull
    private BackupPerson backupPerson;
}
