package com.kubernetesmicroservices.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
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
class StudentController {

	@Autowired
	private  StudentRepository studentRepository;

	@GetMapping("/students")
	public Iterable<Student> getStudents() {
		Iterable<Student> students = studentRepository.findAll();
		return students;
	}

	@PostMapping("/students")
	public Student createStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}
}

@Repository
interface StudentRepository extends CrudRepository<Student, Integer>{}

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
class Student {
	@SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "students_id_seq", name = "students_id_seq")
	@GeneratedValue(generator = "students_id_seq", strategy = GenerationType.SEQUENCE)
	@Id
	@Column(name = "id")
	private Integer id;
	private String name;
}