package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.codec.ErrorDecoder;

@Configuration
public class FeignConfig {

    @Bean
    ErrorDecoder customErrorDecoder() {
        return (methodKey, response) -> {
            String message = "Feign call failed with status " + response.status();
            return new RuntimeException(message); // Serializable
        };
    }
}
