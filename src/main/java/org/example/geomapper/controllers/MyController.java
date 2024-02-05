package org.example.geomapper.controllers;

import org.example.geomapper.dto.GeoObjectCollection;
import org.example.geomapper.services.ApiService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.HashMap;

@RestController
@RequestMapping(path = "api/v1")
public class MyController {
    private final ApiService apiService;
    @Autowired
    public MyController(ApiService apiService) {
        this.apiService = apiService;
    }
    @GetMapping(path = "process")
    public ResponseEntity<?> getDataFromExternalAPI(/*параметры*/) throws URISyntaxException, IOException, JSONException {
        HashMap<String, Object> geoObjectCollection = apiService.callApi(/*те же параметры*/);
        return new ResponseEntity<>(geoObjectCollection, HttpStatus.OK);
    }
}
