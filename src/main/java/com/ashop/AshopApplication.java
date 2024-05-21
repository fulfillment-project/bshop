package com.ashop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AshopApplication.class, args);

	}

}
