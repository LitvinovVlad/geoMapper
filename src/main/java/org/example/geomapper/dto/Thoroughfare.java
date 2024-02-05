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
public class Thoroughfare {
    @JsonProperty("ThoroughfareName")
    private String thoroughfareName;
    @JsonProperty("Premise")
    private Premise premise;
}
