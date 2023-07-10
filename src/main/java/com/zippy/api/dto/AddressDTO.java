package com.zippy.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {
    private String detail;
    private CityDTO city;
    private StateDTO state;
    private CountryDTO country;
}
