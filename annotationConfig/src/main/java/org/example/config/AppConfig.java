package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class AppConfig {
    @Bean
    public Resource questionsResource() {
        return new ClassPathResource("questions.csv");
    }
}
