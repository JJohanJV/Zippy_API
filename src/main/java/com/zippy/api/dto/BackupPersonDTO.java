package com.zippy.api.dto;

import com.zippy.api.constants.DocumentType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BackupPersonDTO {
    private String name;
    private String lastname;
    private String phone;
    private String email;
    private String document;
    private DocumentType documentType;
}
