package com.zippy.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Email;

@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    @Email
    private String email;
}
