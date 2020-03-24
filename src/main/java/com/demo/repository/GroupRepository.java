package com.demo.repository;

import com.demo.entity.GroupEntity;
import com.demo.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GroupRepository extends JpaRepository<GroupEntity,Integer> {

    @Override
     List<GroupEntity> findAll();


}
