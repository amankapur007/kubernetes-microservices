package com.kubernetesmicroservices.student;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SpringBootApplication
public class StudentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}

}

@RestController
class StudentController{

	@GetMapping("/students")
	public List<Student> getStudents(){
		List<Student> students = List.of(new Student(1, "A"));
		return students;
	}
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Student{
	private Integer id;
	private String name; 
}