package com.zippy.api.models.geoJsonResponse;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@RequiredArgsConstructor
@Data
@Accessors(chain = true, fluent = true)
public class GeoJsonResponseWraper {
    private FeatureCollection featureCollection;
    private int statusCode;
    private String statusMessage;
}
