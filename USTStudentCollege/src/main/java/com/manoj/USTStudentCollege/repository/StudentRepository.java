package com.manoj.USTStudentCollege.repository;

import com.manoj.USTStudentCollege.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    @Query(value = "SELECT s.* FROM Student s JOIN College c ON s.college_id = c.Id WHERE c.name = :collegeName ORDER BY s.name DESC", nativeQuery = true)
    List<Student> findStudentsByCollegeNameOrderByNameDesc(@Param("collegeName") String collegeName);
}
