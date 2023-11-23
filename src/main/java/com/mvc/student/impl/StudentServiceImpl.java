package com.mvc.student.impl;

import com.mvc.student.StudentRequest;
import com.mvc.student.StudentResponse;
import com.mvc.student.Student;
import com.mvc.student.StudentMapper;
import com.mvc.student.StudentRepository;

import com.mvc.student.StudentService;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Builder


public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository = null;
    private final StudentMapper studentmapper = new StudentMapper();

    @Override
    public void save(StudentRequest s) {
        Student student = studentmapper.toStudent(s);
        this.studentRepository.save(student);
    }

    @Override
    public StudentResponse findById(Integer id) {
        return this.studentRepository.findById(id)
                .map(studentmapper::toStudentDto)
                .orElse(new StudentResponse());
    }

    @Override
    public List<StudentResponse> findAll() {
        return this.studentRepository.findAll()
                .stream()
                .map(studentmapper::toStudentDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        this.studentRepository.deleteById(id);
    }
}
