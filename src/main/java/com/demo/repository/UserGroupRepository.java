package com.demo.repository;

import com.demo.entity.GroupEntity;
import com.demo.entity.UserGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserGroupRepository extends JpaRepository<UserGroupEntity,Integer> {

    @Override
     List<UserGroupEntity> findAll();


}
