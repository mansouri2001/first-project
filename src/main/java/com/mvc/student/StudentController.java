package com.mvc.student;


import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;







@RestController
@RequestMapping("/students")
public class StudentController {



	    // POST https://some.url.com/students
	    // GET https://some.url.com/students
	    // Filter GET https://some.url.com/students/{id}
	    // Filter GET https://some.url.com/students?param1=val1&param2=val2 // query params
	    // PUT https://some.url.com/students
	    // DELETE https://some.url.com/students/{id}

	    // Embedded resources
	    // GET https://some.url.com/students/subject/{s-id}
	    // GET https://some.url.com/students/{s-id}/subject/{sb-id}
	    private final StudentService service;

	    public StudentController(StudentService service) {
	        this.service = service;
	    }

	    @PostMapping
	    public ResponseEntity<Void> save(
	            @RequestBody @Valid StudentRequest student
	    ) {
	        service.save(student);
	        return ResponseEntity
	                .accepted()
	                .build();
	    }

	    @GetMapping("/{student-id}")
	    public ResponseEntity<StudentResponse> findById(
	            @PathVariable("student-id") Integer studentId
	    ) {
	        return ResponseEntity.ok(service.findById(studentId));
	    }

	    @GetMapping
	    public ResponseEntity<List<StudentResponse>> findAll() {
	        return ResponseEntity.ok(service.findAll());
	    }

	}