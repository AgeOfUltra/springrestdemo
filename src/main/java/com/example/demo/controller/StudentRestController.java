package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentUtil;

@RestController
public class StudentRestController {
	@Autowired
	StudentUtil data;
	@GetMapping(path="/getStudents",produces = {"application/xml"})
	public List<Student> getAllStudents() {
		return data.findAll();
	}
	
	@GetMapping("/student/{id}")
	public Optional<Student> getStudent(@PathVariable("id") int id) {
		return data.findById(id);
	}
	@PostMapping(path="/saveStudent",consumes = {"application/json"})
	public Student saveStudent(@RequestBody Student student) {
		data.save(student);
		System.out.println("Successfull");
		return student;
	}
	@DeleteMapping("/deleteStudent/{id}")
	public Optional<Student> deleStudent(@PathVariable("id") int id) {
		@SuppressWarnings("deprecation")
		Optional<Student> s1  = Optional.of(data.getOne(id));
		data.deleteById(id);
		System.out.println("Deleted");
		return s1;
		
	}
	@PutMapping("/updateStudent")
	public Optional<Student> updateStudent(@RequestBody Student student){
		data.save(student);
		
		return Optional.of(student);
	}

}
