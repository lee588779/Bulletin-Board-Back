package com.iteyes10.taskProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "http://localhost:5500")
@SpringBootApplication
public class TackProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TackProjectApplication.class, args);
	}
}
