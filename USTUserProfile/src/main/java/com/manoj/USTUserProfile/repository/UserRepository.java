package com.manoj.USTUserProfile.repository;

import com.manoj.USTUserProfile.model.Users;
import com.manoj.USTUserProfile.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {


    @Query(value="select * from users u where u.id = :id",nativeQuery=true)
    public Users findByCustosmId(@Param("id") Long id);

    @Query(value="select * from users u where u.name=:name",nativeQuery=true)
    public  Users findByNameCustom(@Param("name") String name);
}
