package com.demo.controller;


import com.demo.entity.Role;
import com.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {


    @Autowired
    private RoleService roleService;

    @GetMapping(value="/role", produces = "application/json")
    private List<Role> getAll() {
        //ityService1;
        return roleService.findAll();
    }

    @GetMapping(value="/role/{id}", produces = "application/json")
    private Role getById(@PathVariable(name="id") Integer id) {
         return roleService.findById(id);
    }

}
