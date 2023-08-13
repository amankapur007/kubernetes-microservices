package com.kubernetesmicroservices.employee;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SpringBootApplication
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

}

@RestController
class EmployeeController{

	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		List<Employee> employees = List.of(new Employee(1, "Employee A"));
		return employees;
	}
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Employee{
	private Integer id;
	private String name; 
}