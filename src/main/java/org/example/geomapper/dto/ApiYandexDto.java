package org.example.geomapper.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.geomapper.model.Address;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiYandexDto {
    private Response response;
    private String request;
    private Address address = new Address();

    public void fillingRequest(String request){
        address.setRequest(request);
    }

    public Address toEntity() {
        String coordinates=
                response
                        .getGeoObjectCollection()
                        .getFeatureMember().get(0)
                        .getGeoObject()
                        .getPoint()
                        .getGeoCoordinates();

        String addressLine =
                response
                        .getGeoObjectCollection()
                        .getFeatureMember().get(0)
                        .getGeoObject().getMetaDataProperty()
                        .getGeocoderMetaData().getAddressDetails()
                        .getAddressLine()
                        .getAddressLine();

        address.setAddressLine(addressLine);
        address.setCoordinates(coordinates);
        return address;
    }

}