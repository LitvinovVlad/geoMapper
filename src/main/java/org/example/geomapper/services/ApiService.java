package org.example.geomapper.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.RequestLine;
import org.example.geomapper.configurations.ApiConfig;
import org.example.geomapper.dto.ApiYandexDto;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.HashMap;

@Service
public class ApiService {
    ObjectMapper objectMapper = new ObjectMapper();
    private final RestTemplate restTemplate = new RestTemplate();
    private final ApiConfig apiConfig;

    @Autowired
    public ApiService(ApiConfig apiConfig) {
        this.apiConfig = apiConfig;
    }

    //    public HashMap<String, Object> callApi(/*параметры для поиска*/) throws URISyntaxException, IOException, JSONException {
//        String apiKey = apiConfig.getApiKey();
//       URI uri = new URI("https://geocode-maps.yandex.ru/1.x/?apikey=" + apiKey + "&geocode=бульвар+Мухаммед+Бин+Рашид+1&format=json&lang=ru_RU");
// //       String response = restTemplate.getForEntity(uri, String.class).getBody();
//
//        JSONObject jsonObject = new JSONObject(response);
//        System.out.println(jsonObject
//                .getJSONObject("response")
//                .getJSONObject("GeoObjectCollection")
//                .getJSONArray("featureMember")
//                .getJSONObject(0)
//                .getJSONObject("GeoObject")
//                .getJSONObject("Point")
//                .getString("pos"));
//        ApiYandexDto apiYandexDto = objectMapper.readValue(response, ApiYandexDto.class);
//       //  ApiYandexDto response = restTemplate.getForObject(uri, ApiYandexDto.class);
//        assert response != null;
//        return apiYandexDto.test();
//    }
    public void createOn() {
        // Формирование URL-адреса запроса к API Геокодирования
        String apiKey = apiConfig.getApiKey();
        String apiUrl = "https://geocode-maps.yandex.ru/1.x/?apikey=" + apiKey + "&geocode=бульвар+Мухаммед+Бин+Рашид+1&format=json&lang=ru_RU";

        try {
            // Отправка GET-запроса и получение ответа
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            connection.disconnect();

            // Обработка полученного ответа в формате JSON
            // Здесь можно использовать JSON-библиотеки, например, Gson или Jackson, для удобной работы с JSON

            String jsonResponse = response.toString();
            // Обработка полученных координат из JSON-ответа
            double latitude = extractLatitudeFromJson(jsonResponse);
            double longitude = extractLongitudeFromJson(jsonResponse);

            System.out.printf("Широта: %f, Долгота: %f\n", latitude, longitude);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для извлечения широты из JSON-ответа
    private static double extractLatitudeFromJson(String jsonResponse) {
        // Здесь необходимо реализовать обработку JSON-ответа и извлечение широты
        // в соответствии с структурой ответа от Yandex Maps API
        // В примере я просто возвращаю 55.753960, чтобы продемонстрировать формат
        return 55.753960;
    }

    // Метод для извлечения долготы из JSON-ответа
    private static double extractLongitudeFromJson(String jsonResponse) {
        // Здесь необходимо реализовать обработку JSON-ответа и извлечение долготы
        // в соответствии с структурой ответа от Yandex Maps API
        // В примере я просто возвращаю 37.620393, чтобы продемонстрировать формат
        return 37.620393;
    }


    public HashMap<String, Object> callApi(/*параметры для поиска*/) throws URISyntaxException, IOException, JSONException {
        String apiKey = apiConfig.getApiKey();
        URI uri = new URI("https://geocode-maps.yandex.ru/1.x/?apikey=" + apiKey + "&geocode=бульвар+Мухаммед+Бин+Рашид+1&format=json&lang=ru_RU");
//               String response = restTemplate.getForEntity(uri, String.class).getBody();
        RestClient restClient = RestClient.create();
        String response =  restClient.get().uri(uri).retrieve().body(String.class);
        JSONObject jsonObject = new JSONObject(response);
        System.out.println(jsonObject
                .getJSONObject("response")
                .getJSONObject("GeoObjectCollection")
                .getJSONArray("featureMember")
                .getJSONObject(0)
                .getJSONObject("GeoObject")
                .getJSONObject("Point")
                .getString("pos"));
        ApiYandexDto apiYandexDto = objectMapper.readValue(response, ApiYandexDto.class);
        //  ApiYandexDto response = restTemplate.getForObject(uri, ApiYandexDto.class);
        return apiYandexDto.test();
    }


}