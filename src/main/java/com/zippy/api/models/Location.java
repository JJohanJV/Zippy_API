package com.zippy.api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Getter
@Accessors(fluent = false, chain = true)
public class Location {
    private double latitude;
    private double longitude;
}
