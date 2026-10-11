package com.app;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class MappingProject {

    public static void main(String[] args) {
        SpringApplication.run(MappingProject.class, args);
        System.out.println("MappingProject is Running....");
        System.out.println("jayesh branch Running....");

        // Utility: print encoded password for reference (not a bean)
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "123456";
        System.out.println("Encoded password for " + rawPassword + " : " + encoder.encode(rawPassword));
    }

    @Bean
    public ModelMapper myModelMapper() {
        ModelMapper map = new ModelMapper();
        map.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return map;
    }
}
