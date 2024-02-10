package org.example.geomapper.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.geomapper.configurations.ApiConfig;
import org.example.geomapper.dto.AddressDto;
import org.example.geomapper.dto.ApiYandexDto;
import org.example.geomapper.model.Address;
import org.example.geomapper.dao.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.io.IOException;
import java.net.*;

@Service
public class ApiService {
    private final RestClient restClient = RestClient.create();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final ApiConfig apiConfig;
    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ApiService(ApiConfig apiConfig, AddressRepository addressRepository, ModelMapper modelMapper) {
        this.apiConfig = apiConfig;
        this.addressRepository = addressRepository;
        this.modelMapper = modelMapper;
    }


    public AddressDto callApi(String request) throws URISyntaxException, IOException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String apiKey = apiConfig.getApiKey();
        String requestForUri = request.replaceAll(" ", "+");
        URI uri = new URI("https://geocode-maps.yandex.ru/1.x/?apikey=" + apiKey + "&geocode=" + requestForUri + "&format=json&lang=ru_RU");
        String response = restClient.get().uri(uri).retrieve().body(String.class);
        ApiYandexDto apiYandexDto = objectMapper.readValue(response, ApiYandexDto.class);
        apiYandexDto.fillingRequest(request);
        if (addressRepository.existsByRequest(request)) {
            Address address = apiYandexDto.toEntity();
            return createAddress(address);
        }
        else {
            Address address = addressRepository.save(apiYandexDto.toEntity());
            return createAddress(address);
        }
    }

    public AddressDto createAddress(Address address) {
        return modelMapper.map(address, AddressDto.class);
    }
}