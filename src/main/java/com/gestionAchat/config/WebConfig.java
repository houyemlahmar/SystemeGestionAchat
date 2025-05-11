package com.gestionAchat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Adjust the path to match your API endpoints
                .allowedOrigins("http://localhost:4200") // Allow requests from Angular's dev server
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // HTTP methods to allow
                .allowedHeaders("*") // Allow all headers
                .allowCredentials(true); // Allow cookies or authentication headers
    }
}