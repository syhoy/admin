package com.demo.repository;

import com.demo.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GroupRepository extends JpaRepository<Group,Integer> {

    @Override
     List<Group> findAll();


}
