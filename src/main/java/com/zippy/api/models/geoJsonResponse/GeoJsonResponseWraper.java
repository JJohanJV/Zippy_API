package com.zippy.api.models.geoJsonResponse;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Optional;

@RequiredArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true, fluent = true)
public class GeoJsonResponseWraper {
    private Optional<FeatureCollection> featureCollection;
    private int statusCode;
    private String statusMessage;
}
