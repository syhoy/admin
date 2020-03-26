package com.demo.repository;

import com.demo.entity.Group;
import com.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Override
     List<User> findAll();


    //todo
    @Query("select g from User u " +
            "join "+
            //"fetch"+  //???????
            "u.groupList g " +
            "where u.id = :id")
    List<Group> getGroupList(@Param("id") Integer id);



}
