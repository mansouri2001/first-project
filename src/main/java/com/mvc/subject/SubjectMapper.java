package com.mvc.subject;

import org.springframework.stereotype.Service;

import com.mvc.student.StudentResponse;

@Service
public class SubjectMapper {
	public SubjectResponse toSubjectDto(Subject sub) {
		var  subjectResponse =new SubjectResponse();
		subjectResponse.setName(sub.getName());
		return subjectResponse;
	}

	public Subject toSubject(SubjectRequest sub) {
		Subject subject =new Subject();
		subject.setId(sub.getId());
		subject.setName(sub.getName());
		return subject;
	}
}

