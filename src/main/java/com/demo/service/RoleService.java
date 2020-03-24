package com.demo.service;

import com.demo.entity.RoleEntity;

import java.util.List;


public interface RoleService {

    List<RoleEntity> findAll();


    RoleEntity findById(Integer id);
}
