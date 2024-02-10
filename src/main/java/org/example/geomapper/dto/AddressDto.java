package org.example.geomapper.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDto {
    private String addressLine;
    private String coordinates;
}
