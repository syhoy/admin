package com.demo.service;

import com.demo.entity.Group;
import com.demo.entity.User;

import java.util.List;


public interface UserService {

    List<User> findAll();


    User findById(Integer id);

    List<Group> getGroupList(Integer id);
}
