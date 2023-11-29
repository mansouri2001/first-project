package com.mvc.subject;

import com.mvc.chapter.Chapter;
import com.mvc.student.Student;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Subject {

    @Id
    @GeneratedValue
    private Integer id;

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String name;

    @ManyToMany(mappedBy = "subjects")
    @JsonBackReference 
    //qu'on ne veut pas le charger
    private List<Student> students;

    @OneToMany(mappedBy = "subject")
    private List<Chapter> chapters;
}
