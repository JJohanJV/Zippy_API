package com.zippy.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class Address {
    @NotNull
    private String detail;
    @NotNull
    private City city;
    private Country country;
    private State state;

}
