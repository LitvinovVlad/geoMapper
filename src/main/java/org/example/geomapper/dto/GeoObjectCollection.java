package org.example.geomapper.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeoObjectCollection implements Serializable {
//    private String street;
//    private String city;
//    private String postalCode;
//    private String country;
//    private Double latitude;
//    private Double longitude;
    private MetaDataProperty metaDataProperty;

}
