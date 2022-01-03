package com.otavio.restapimongodb;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

@SpringBootApplication
public class RestapimongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestapimongodbApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(
			StudentRepository repository,
			MongoTemplate mongoTemplate) {
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

			Query query = new Query();
			query.addCriteria(Criteria.where("email").is(student.getEmail()));

			List<Student> students = mongoTemplate.find(query, Student.class);

			if (students.size() > 1)
				throw new IllegalStateException("found many students with email" + student.getEmail());

			if (students.isEmpty()) {
				System.out.println("Inserting student " + student);
				repository.insert(student);
			} else {
				System.out.println(student + " already exists");
			}
		};
	}
}
