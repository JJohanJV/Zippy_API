package com.zippy.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class State {
    @NotNull
    private int id;
    @NotNull
    private String name;
}
