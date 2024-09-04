package com.manoj.USTStudentCollege.controller;

import com.manoj.USTStudentCollege.model.College;
import com.manoj.USTStudentCollege.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.manoj.USTStudentCollege.service.CollegeService;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private CollegeService collegeService;

//    @GetMapping("/colleges")
//    public String hi()
//    {
//        return "manoj";
//    }

    @PostMapping("/colleges")
    public ResponseEntity<College> CreateCollege(@RequestBody College college)
    {
        System.out.println("inside college controller");
            College returnedCollege  = collegeService.createCollege(college);

             System.out.println(returnedCollege);
            return new ResponseEntity<>(returnedCollege, HttpStatus.CREATED);
    }

    @PostMapping("/colleges/{collegeId}/students")
    public ResponseEntity<Student> createStudent(@PathVariable Long collegeId,@RequestBody Student student)
    {
        try {
            Student returnStudent = collegeService.createStudent(collegeId, student);
            System.out.println(returnStudent);
            return new ResponseEntity<>(returnStudent, HttpStatus.CREATED);
        }
        catch(RuntimeException e)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/colleges")
    public ResponseEntity<List<College>> getAllColleges()
    {
        List<College> returnAllColleges=  collegeService.getAllColleges();
        return new ResponseEntity<>(returnAllColleges,HttpStatus.OK);
    }

    @GetMapping("/students/{collegeName}")
    public ResponseEntity<List<Student>> getALLStudent(@PathVariable String collegeName)
    {
        return new ResponseEntity<>(collegeService.getALLStudentBasedOnCollegeName(collegeName),HttpStatus.OK);
    }
}
