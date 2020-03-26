package com.demo.service;

import com.demo.entity.Group;

import java.util.List;


public interface GroupService {

    Group findById(Integer id);


    List<Group> findAll();



}
