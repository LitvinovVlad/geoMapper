package org.example.geomapper.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONObject;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeoObject extends JSONObject {
    @JsonProperty("metaDataProperty")
    private MetaDataProperty metaDataProperty;
    @JsonProperty("Point")
    private Point point;
}
