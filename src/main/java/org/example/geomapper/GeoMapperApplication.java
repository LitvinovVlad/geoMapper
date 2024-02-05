package org.example.geomapper;

import org.example.geomapper.services.ApiService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.example.geomapper.repository")
@ComponentScan(basePackages = { "org.example.geomapper.*" })
@EntityScan("org.example.geomapper.*")
public class GeoMapperApplication {
    public static void main(String[] args) {
        SpringApplication.run(GeoMapperApplication.class, args);
    }
}
