package com.test.spring.jpa.restservices;

import com.test.spring.jpa.restservices.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RestServicesApplication {

	@Autowired
	private UserServices userServices;

	public static void main(String[] args) {
		SpringApplication.run(RestServicesApplication.class, args);
	}


	@Bean
	CommandLineRunner runner() {
		return args -> {
		//Save demo data after start

		};
	}
}


}
