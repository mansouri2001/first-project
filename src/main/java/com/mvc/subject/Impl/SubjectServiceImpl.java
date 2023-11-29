package com.mvc.subject.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.student.Student;
import com.mvc.student.StudentResponse;
import com.mvc.subject.Subject;
import com.mvc.subject.SubjectMapper;
import com.mvc.subject.SubjectRepository;
import com.mvc.subject.SubjectRequest;
import com.mvc.subject.SubjectResponse;
import com.mvc.subject.SubjectService;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Builder
public class SubjectServiceImpl implements SubjectService {

	private final SubjectRepository subjectRepository;
	private final SubjectMapper subjectMapper;
	
	public  SubjectServiceImpl (SubjectRepository subjectRepository,  SubjectMapper subjectMapper) {
			
		this.subjectMapper=subjectMapper;
		this.subjectRepository=subjectRepository;
		}
	
	
	@Override
	public void save(SubjectRequest subj) {
	   Subject subject = subjectMapper.toSubject(subj);
        this.subjectRepository.save(subj);
    }
		

	 @Override
	    public SubjectResponse findById(Integer id) {
	        return this.subjectRepository.findById(id)
	                .map(subjectMapper::toSubjectDto)
	                .orElse(new SubjectResponse());
	    }

	 @Override
	    public List<SubjectResponse> findAll() {
	        return this.subjectRepository.findAll()
	                .stream()
	                .map(subjectMapper::toSubjectDto)
	                .collect(Collectors.toList());
	    }

	@Override
	    public void deleteById(Integer id) {
	        this.subjectRepository.deleteById(id);
	    }

}
