package org.example.geomapper.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONArray;

import javax.json.JsonArray;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeoObjectCollection implements Serializable {
    //    @JsonProperty("featureMember")
//    private List<FeatureMember> featureMember;
    @JsonProperty("featureMember")
    private JSONArray featureMember;
}
