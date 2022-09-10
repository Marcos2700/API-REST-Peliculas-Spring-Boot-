/*package com.example.apiMovies.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * Configuracion Swagger para la documentacion de la API REST
 *
 * URL: http://localhost:8080/swagger-ui
 */
/*
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiDetails(){
        return new ApiInfo("Spring Boot Movie API REST",
                "Library api rest for movies",
                "1.0",
                "https://google.com",
                new Contact("Marcos", "https://google.com", "MarcosAaa@gmail.com"),
                "mitsa",
                "asdasd.com",
                Collections.emptyList());
    }
}*/