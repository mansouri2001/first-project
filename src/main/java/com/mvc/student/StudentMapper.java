package com.mvc.student;

import org.springframework.stereotype.Service;



@Service
public class StudentMapper {

    public StudentResponse toStudentDto(Student s) {
    	var studentresponse = new StudentResponse();
		 studentresponse.setFirstname(s.getFirstname());
		 studentresponse.setLastname(s.getLastname()); 
		 studentresponse.setAge(s.getAge());
		 studentresponse.setNbrSubjects(0);
		 //std.getNbrSubjects().size()
		 return studentresponse;
    }

    public Student toStudent(StudentRequest s) {
        Student student = new Student();
        student.setId(s.getId());
        student.setFirstname(s.getFirstname());
        student.setLastname(s.getLastname());
        student.setAge(s.getAge());
        return student;
    }
}
