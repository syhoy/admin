package com.demo.repository;

import com.demo.entity.RoleEntity;
import com.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;
import java.util.List;


@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,Integer> {

    @Override
     List<RoleEntity> findAll();


}
