package com.example.demo;

import com.example.demo.entity.Court;
import com.example.demo.repository.CourtRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(CourtRepository courtRepository) {
		return args -> {
			courtRepository.save(new Court("court 1", 4));
			courtRepository.save(new Court("court 2", 4));
			courtRepository.save(new Court("court 3", 4));
		};
	}
}
