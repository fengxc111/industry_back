package com.example.webserverv1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebserverV1Configurer implements WebMvcConfigurer {

    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
//                .allowedOrigins("*")
                .allowedOriginPatterns("*")
//                .allowedHeaders("*")
                .allowCredentials(true)
                .allowedMethods("GET", "HEAD", "POST", "DELETE", "OPTIONS")
                .maxAge(3600);
    }


}
