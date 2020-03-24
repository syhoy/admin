package com.demo.controller;


import com.demo.entity.GroupEntity;
import com.demo.entity.UserGroupEntity;
import com.demo.service.GroupService;
import com.demo.service.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserGroupController {


    @Autowired
    private UserGroupService userGroupService;

    @GetMapping(value="/usergroup", produces = "application/json")
    private List<UserGroupEntity> getAll() {
        //ityService1;
        return userGroupService.findAll();
    }

}
