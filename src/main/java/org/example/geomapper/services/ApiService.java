package org.example.geomapper.services;

import org.example.geomapper.configurations.ApiConfig;
import org.example.geomapper.dto.ApiYandexDto;
import org.example.geomapper.dto.GeoObjectCollection;
import org.example.geomapper.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class ApiService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final ApiConfig apiConfig;

    @Autowired
    public ApiService(ApiConfig apiConfig) {
        this.apiConfig = apiConfig;
    }

    public GeoObjectCollection callApi(/*параметры для поиска*/) throws URISyntaxException {
        String apiKey = apiConfig.getApiKey();
        URI uri = new URI("https://geocode-maps.yandex.ru/1.x/?apikey=" + apiKey + "&geocode=Дубай&format=json");
//        ResponseEntity<GeoObjectCollection> response = restTemplate.getForEntity(uri, GeoObjectCollection.class);
        Response response = restTemplate.getForObject(uri, Response.class);
        return response.getGeoObjectCollection();
    }
}
//логика приложения

