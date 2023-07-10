package com.zippy.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

@Getter
@Setter
@AllArgsConstructor
public class TokenDTO {
    private ObjectId userId;
    private String accessToken;
    private String refreshToken;
}