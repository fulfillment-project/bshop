package com.bshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(BshopApplication.class, args);

	}

}
