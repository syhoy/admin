package com.demo.controller;


import com.demo.entity.GroupEntity;
import com.demo.entity.RoleEntity;
import com.demo.service.GroupService;
import com.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroupController {


    @Autowired
    private GroupService groupService;

    @GetMapping(value="/group", produces = "application/json")
    private List<GroupEntity> getAll() {
        return groupService.findAll();
    }

    @GetMapping(value="/group/{id}", produces = "application/json")
    public GroupEntity getById(@PathVariable(name="id") Integer id) {
        return groupService.findById(id);
    }


}
