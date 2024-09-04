package com.manoj.USTStudentCollege.repository;

import com.manoj.USTStudentCollege.model.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeRepository  extends JpaRepository<College,Long> {

    // need to do feth by collegeName
}
