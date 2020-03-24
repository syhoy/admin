package com.demo.service;

import com.demo.entity.GroupEntity;
import com.demo.entity.RoleEntity;

import java.util.List;


public interface GroupService {

    GroupEntity findById(Integer id);


    List<GroupEntity> findAll();



}
