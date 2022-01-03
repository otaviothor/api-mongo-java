package com.otavio.restapimongodb;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestapimongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestapimongodbApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepository repository) {
		return args -> {
			Address address = new Address(
					"Brazil",
					"São Paulo",
					"08575580");

			Student student = new Student(
					"Otávio",
					"Silva",
					"otavio@gmail.com",
					Gender.MALE,
					address,
					List.of("Computer Science", "Maths", "Computer Engineering"),
					BigDecimal.TEN,
					LocalDateTime.now());

			repository.insert(student);
		};
	}
}
