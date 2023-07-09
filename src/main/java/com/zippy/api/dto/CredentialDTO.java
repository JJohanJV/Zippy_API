package com.zippy.api.dto;

import com.zippy.api.constants.Role;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CredentialDTO {
    @NotBlank
    @Size(min = 3, max = 30)
    private String username;
    @NotBlank
    @Size(max = 60)
    @NotBlank
    @Size(min = 6, max = 60)
    private String password;
    private Role role;
}
