package com.zippy.api.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.zippy.api.document.Role;

@Getter
@Setter
public class SignupDTO {
    @NotBlank
    @Size(min = 3, max = 30)
    private String username;
    @NotBlank
    @Size(max = 60)
    @Email
    private String email;
    @NotBlank
    @Size(min = 6, max = 60)
    private String password;
    private Role role;
}