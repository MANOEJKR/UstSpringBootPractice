package com.manoj.UstCourseStudent.controller;

import com.manoj.UstCourseStudent.model.Course;
import com.manoj.UstCourseStudent.model.Student;
import com.manoj.UstCourseStudent.repository.CourseRepository;
import com.manoj.UstCourseStudent.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MainController {


        @Autowired
        private StudentRepository studentRepository;


        @Autowired
        private CourseRepository courseRepository;

        @PostMapping("/student")
    public ResponseEntity<Student>createStudent(@RequestBody  Student student)
    {
        return new ResponseEntity<>(studentRepository.save(student), HttpStatus.CREATED);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id)
    {
        System.out.println("inside getstudnet");

        Student ss= studentRepository.getStudentCustomerById(id);
        if(ss!=null) {
            System.out.println(" not null ");
           return new ResponseEntity<>(ss, HttpStatus.FOUND);
        }
        else {
            System.out.println("null value");
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/course")
    public ResponseEntity<Course> createCourse(@RequestBody Course course)
    {
        return new ResponseEntity<>(courseRepository.save(course),HttpStatus.CREATED);
    }
    @GetMapping("/course/{id}")
    public ResponseEntity<Course> getCourses(@PathVariable Long id)
    {
        return new ResponseEntity<>(courseRepository.findById(id).get(),HttpStatus.FOUND);
    }

    @GetMapping("/student/{sid}/course/{cid}")
    public ResponseEntity<Student> assignCourseToStudent(@PathVariable Long sid,@PathVariable Long cid)
    {
            Course returnCourse = courseRepository.findById(cid).get();
            Student returnStudent = studentRepository.findById(sid).get();

            returnStudent.setCourseByOne(returnCourse);
            return new ResponseEntity<>(studentRepository.save(returnStudent),HttpStatus.OK);

    }
}
