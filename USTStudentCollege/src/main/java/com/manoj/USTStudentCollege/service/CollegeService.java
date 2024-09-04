package com.manoj.USTStudentCollege.service;

import com.manoj.USTStudentCollege.model.College;
import com.manoj.USTStudentCollege.model.Student;
import com.manoj.USTStudentCollege.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.manoj.USTStudentCollege.repository.CollegeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CollegeService {

    @Autowired
    private CollegeRepository collegeRepository;


    @Autowired
    private StudentRepository studentRepository;

    public College createCollege(College college) {
        College returnCollege = collegeRepository.save(college);

        return returnCollege;
    }

    public Student createStudent(Long collegeId, Student student) {

        Optional<College> returnCollege = collegeRepository.findById(collegeId);
        if(returnCollege.isPresent())
        {
            College requiredcollege = returnCollege.get(); // OPTIONAL TO NORMAL
            student.setCollege(requiredcollege);

            return studentRepository.save(student);
        }
        else
        {
             throw new RuntimeException("Not Found");
        }
    }

    public List<College> getAllColleges() {

        List<College> allCollege = collegeRepository.findAll();

        return allCollege;

    }

    public List<Student> getALLStudentBasedOnCollegeName(String collegename)
    {
        List<Student> returnStudent = studentRepository.findStudentsByCollegeNameOrderByNameDesc(collegename);
        return returnStudent;
    }
}
