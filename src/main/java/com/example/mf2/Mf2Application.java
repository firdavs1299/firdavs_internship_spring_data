package com.example.mf2;

import com.example.mf2.repositories.TaskRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = TaskRepository.class)

public class Mf2Application {

	public static void main(String[] args) {
		SpringApplication.run(Mf2Application.class, args);
	}

}
