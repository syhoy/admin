package com.demo.controller;


import com.demo.entity.Group;
import com.demo.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroupController {


    @Autowired
    private GroupService groupService;

    @GetMapping(value="/group", produces = "application/json")
    private List<Group> getAll() {
        return groupService.findAll();
    }

    @GetMapping(value="/group/{id}", produces = "application/json")
    public Group getById(@PathVariable(name="id") Integer id) {
        return groupService.findById(id);
    }


}
