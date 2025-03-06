package com.example.chatbot.api;

import feign.RequestInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@RequiredArgsConstructor
public class ApiConfig {

    @Value("${api-key}")
    private String apiKey;

    @Bean
    public RequestInterceptor headerSetter() {
        return requestTemplate -> {
            requestTemplate.header("Content-Type", "application/json");
            requestTemplate.header("Authorization", "Bearer " + apiKey);
        };
    }
}
