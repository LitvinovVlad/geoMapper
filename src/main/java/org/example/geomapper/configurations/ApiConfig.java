package org.example.geomapper.configurations;

import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class ApiConfig {
    @Value("${api.key}")
    private String apiKey;
    @Bean
    public ModelMapper getMapper() {
        return new ModelMapper();
    }
}
