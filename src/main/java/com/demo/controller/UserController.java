package com.demo.controller;


import com.demo.entity.RoleEntity;
import com.demo.entity.UserEntity;
import com.demo.model.UserModel;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.reactive.WebFluxLinkBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.List;

import static org.springframework.hateoas.server.reactive.WebFluxLinkBuilder.linkTo;
import static org.springframework.hateoas.server.reactive.WebFluxLinkBuilder.methodOn;

@RestController
//@Controller
public class UserController {


    @Autowired
    private UserService userService;


    @GetMapping(value="/user", produces = "application/json")
    private List<UserEntity> getAll() {
        //ityService1;
        return userService.findAll();
    }

    @GetMapping(value="/user/{id}", produces = "application/json")
    public UserEntity getById(@PathVariable(name = "id") Integer id) {


        return userService.findById(id);
    }

    //Create link

//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

//Method 1
/*
   WebFluxLinkBuilder.WebFluxLink link = linkTo(methodOn(UserController.class)
            .getAll())
            .withRel("user");
*/
// Method 2

 //   Method method = UserController.class.getMethod("getById", Integer.class);
 //   Link link2 = linkTo(method, 2).withSelfRel();

}
