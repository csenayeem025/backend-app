package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Global configuration for Cross-Origin Resource Sharing (CORS).
 * * This configuration allows requests from a specific frontend domain 
 * to access the REST endpoints of this Spring Boot application.
 * * NOTE: For production, replace "http://localhost:3000" with your actual 
 * frontend domain (e.g., "https://my-frontend-app.com").
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Apply this CORS configuration to all paths ("/**")
                .allowedOrigins("http://localhost:3000", 
                                "http://127.0.0.1:3000") // Replace with your frontend domains
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow standard HTTP methods
                .allowedHeaders("*") // Allow all headers in the request
                .allowCredentials(true) // Allow cookies, authorization headers, and client certificates
                .maxAge(3600); // How long the pre-flight response can be cached (in seconds)
    }
}
