package com.bankingsystem;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MappingProject {

	public static void main(String[] args) {
		SpringApplication.run(MappingProject.class, args);
		System.out.println("MappingProject is Running....");
		System.out.println("jayesh branch Running....");

	}
	@Bean
	public ModelMapper myModelMapper() {
		ModelMapper map=new ModelMapper();
		map.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return map;
	}

}

