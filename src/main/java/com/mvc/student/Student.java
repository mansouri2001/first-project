package com.mvc.student;

import com.mvc.address.Address;
import com.mvc.subject.Subject;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
public class Student {

	@Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false)
    private int age;


    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@OneToOne(mappedBy = "student")
    private Address address;

    @ManyToMany
    @JoinTable(
            name = "std_sub",
            joinColumns = {@JoinColumn(name = "std_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "sub_id", referencedColumnName = "id")}
    )
    // @JsonManagedReference
    private List<Subject> subjects;
}
