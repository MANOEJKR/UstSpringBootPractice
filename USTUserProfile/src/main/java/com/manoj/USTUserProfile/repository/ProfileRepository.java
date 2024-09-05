package com.manoj.USTUserProfile.repository;


import com.manoj.USTUserProfile.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,Long> {

    @Query(value="select * from profile p where p.id=:id  ",nativeQuery = true)
    public Profile findByIdCustom(@Param("id")Long id);
}
