package com.manoj.USTStudentCollege.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
public class College {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long collegeId; // try to change to collegeID after and see the result to understand flow
    private String name;

    @OneToMany(mappedBy="college",cascade= CascadeType.ALL,fetch=FetchType.EAGER,orphanRemoval = true)
   // @JsonBackReference
    List<Student> students;


    public Long getId() {
        return collegeId;
    }

    public void setCollegeId(Long id) {
        this.collegeId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
