package org.example.geomapper.api;

import org.example.geomapper.dto.ApiYandexDto;
import org.example.geomapper.model.Address;
import org.example.geomapper.services.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping(path = "api/v1")
public class AddressController {
    private final ApiService apiService;

    @Autowired
    public AddressController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping(path = "process")

    public ResponseEntity<?> getDataFromExternalAPI(@RequestParam String request) throws URISyntaxException, IOException {
        return new ResponseEntity<>(apiService.callApi(request), HttpStatus.OK);
    }
}
