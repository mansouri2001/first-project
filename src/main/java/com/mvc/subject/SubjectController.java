package com.mvc.subject;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
	private final SubjectService subjectServices;
	public SubjectController(SubjectService subjectServices) {
		this.subjectServices=subjectServices;
		}
	@PostMapping
	public ResponseEntity<Void>save(
			@RequestBody @Valid SubjectRequest subj){
		subjectServices.save(subj);
		return ResponseEntity.accepted().build();
		
	}
	@GetMapping("/{subject-id}")
	public ResponseEntity <SubjectResponse> findById(
	@PathVariable("subject-id") Integer subjectId
	){
		return ResponseEntity.ok(subjectServices.findById(subjectId));
	}
	@GetMapping
	public ResponseEntity<List<SubjectResponse>>findAll(){
		return ResponseEntity.ok(subjectServices.findAll());
	}

	
	

}
