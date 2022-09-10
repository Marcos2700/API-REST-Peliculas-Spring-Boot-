package com.example.apiMovies;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
@OpenAPIDefinition
public class ApiMoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiMoviesApplication.class, args);
	}

}
