package org.example.geomapper.controllers;

import org.example.geomapper.dto.GeoObjectCollection;
import org.example.geomapper.services.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
@RequestMapping(path = "api/v1")
public class MyController {
    private final ApiService apiService;
    @Autowired
    public MyController(ApiService apiService) {
        this.apiService = apiService;
    }


    @GetMapping(path = "process")
    public ResponseEntity<?>  getDataFromExternalAPI(/*параметры*/) throws URISyntaxException {
        GeoObjectCollection geoObjectCollection = apiService.callApi(/*те же параметры*/);
        return new ResponseEntity<>(geoObjectCollection, HttpStatus.OK);
    }
}
