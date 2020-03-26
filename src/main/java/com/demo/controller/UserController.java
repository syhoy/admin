package com.demo.controller;


import com.demo.entity.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.reactive.WebFluxLinkBuilder.linkTo;

@RestController
//@Controller
public class UserController {


    @Autowired
    private UserService userService;


    @GetMapping(value="/user", produces = "application/json")
    private List<User> getAll() {
        //ityService1;
        return userService.findAll();
    }

    @GetMapping(value="/user/{id}", produces = "application/json")
    public User getById(@PathVariable(name = "id") Integer id) {


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
