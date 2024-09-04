package com.manoj.UstCourseStudent.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long stundentId;
    private String name;

    @ManyToMany
    @JoinTable(
            name="Student-Courses",
            joinColumns = @JoinColumn(name="stundet_id"),
            inverseJoinColumns = @JoinColumn(name="course_id")
    )
    @JsonBackReference
    private List<Course> purchaedCourse=new ArrayList<>();

    public Long getStundentId() {
        return stundentId;
    }

    public void setStundentId(Long stundentId) {
        this.stundentId = stundentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getPurchaedCourse() {
        return purchaedCourse;
    }

    public void setPurchaedCourse(List<Course> purchaedCourse) {
        this.purchaedCourse = purchaedCourse;
    }
    public void setCourseByOne(Course course)
    {
        this.purchaedCourse.add(course);
    }

}
