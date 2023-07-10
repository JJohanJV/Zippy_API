package com.zippy.api.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class SignupDTO {
    @NotBlank
    private CredentialDTO credential;
    @NotBlank
    private UserDTO user;
}