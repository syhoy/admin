package com.demo.service;

import com.demo.entity.Role;

import java.util.List;


public interface RoleService {

    List<Role> findAll();


    Role findById(Integer id);
}
