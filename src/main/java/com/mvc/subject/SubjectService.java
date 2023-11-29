package com.mvc.subject;

import java.util.List;

public interface SubjectService {

	void save(SubjectRequest subj);
	SubjectResponse findById( Integer id);
	List<SubjectResponse>findAll();

	void deleteById(Integer id);

	
}
