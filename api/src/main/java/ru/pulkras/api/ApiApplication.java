package ru.pulkras.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@GetMapping(path = "students")
	public List<Student> getStudents() {
		return List.of(
				new Student("Alex", LocalDate.of(2004, Month.NOVEMBER, 1)),
				new Student("Misha", LocalDate.of(2000, Month.DECEMBER, 19))
		);
	}

}
