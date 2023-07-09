package com.zippy.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class Country {
    @NotNull
    private int id;
    @NotNull
    private String name;
}
