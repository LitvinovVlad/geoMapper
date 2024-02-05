package org.example.geomapper.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Country {
    @JsonProperty("CountryName")
    private String countryName;
    @JsonProperty("AdministrativeArea")
    private AdministrativeArea administrativeArea;
}
