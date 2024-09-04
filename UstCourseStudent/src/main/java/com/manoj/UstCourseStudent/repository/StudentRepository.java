package com.manoj.UstCourseStudent.repository;

import com.manoj.UstCourseStudent.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    @Query(value = "select s.* from Student s where s.stundent_Id=:id",nativeQuery=true)
    Student getStudentCustomerById(@Param("id")Long id);
}
