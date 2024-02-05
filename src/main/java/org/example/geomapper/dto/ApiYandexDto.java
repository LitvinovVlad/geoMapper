package org.example.geomapper.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONException;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiYandexDto {
    private Response response;
    public HashMap<String, Object> test() throws JSONException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String, Object> map = new HashMap<>();
        String key0 = "getCountryName()";
        map.put(key0, objectMapper.readValue(response.getGeoObjectCollection().getFeatureMember().get(0).toString(), GeoObject.class));
        return map;
    }
}
