package com.rohan.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StuController {
	
	@Autowired
	private StudentRepository repository;
	
	@PostMapping("/addStudent")
	public ResponseEntity<?> addStudent(@RequestBody Student student) {
		Student stu = repository.insert(student);
		return ResponseEntity.ok(stu);
	}
}
