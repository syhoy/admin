package com.demo.controller;


import com.demo.assembler.GroupModelAssembler;
import com.demo.assembler.RoleModelAssembler;
import com.demo.assembler.UserModelAssembler;
import com.demo.entity.Group;
import com.demo.entity.Role;
import com.demo.entity.User;
import com.demo.model.GroupModel;
import com.demo.model.RoleModel;
import com.demo.model.RootModel;
import com.demo.model.UserModel;
import com.demo.repository.GroupRepository;
import com.demo.repository.RoleRepository;
import com.demo.repository.UserRepository;
import com.demo.service.GroupService;
import com.demo.service.RoleService;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.Link;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
//import org.springframework.hateoas.CollectionModel;
//import org.springframework.hateoas.EntityModel;

//
@RestController
public class WebController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupRepository groupRepository;



    @Autowired
    private RoleRepository roleRepository;


    @Autowired
    private UserService userService;


    @Autowired
    private GroupService groupService;

    @Autowired
    private RoleService roleService;


    @Autowired
    private UserModelAssembler userModelAssembler;

    @Autowired
    private GroupModelAssembler groupModelAssembler;

    @Autowired
    private RoleModelAssembler roleModelAssembler;


    @GetMapping(value="/api/user", produces = "application/hal+json")
    public ResponseEntity<RootModel> getUser() {
        RootModel rootModel = new RootModel("Root for User");
       return new ResponseEntity<>(rootModel,HttpStatus.OK);
    }


    @GetMapping(value="/api/user/all", produces = "application/hal+json")
    public ResponseEntity<CollectionModel<UserModel>> getUserAll() {
        List<User> userList = userRepository.findAll();
        return new ResponseEntity<>( userModelAssembler.toCollectionModel(userList),HttpStatus.OK);
    }


    @GetMapping(value="/api/user/{id}", produces = "application/hal+json")
    public ResponseEntity<UserModel> getUserById(@PathVariable(name = "id") Integer id) {
        Optional<User> user = userRepository.findById(id);
       return user.map(userModelAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping(value="/api/user/{id}/groups", produces = "application/hal+json")
    public ResponseEntity<UserModel> getUserByIdGroup(@PathVariable(name = "id") Integer id) {
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(u->u.setGroupList(userRepository.getGroupList(id)));
         return user.map(userModelAssembler::toModelWithGroups)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping(value="/api/user", produces = "application/hal+json")
    public ResponseEntity<UserModel> addUser(@RequestBody User user) {
        User add = new  User();
        add.setFirstName(user.getFirstName());
        add.setLastName(user.getLastName());
        add.setRole(user.getRole());
        add.setGroupList(user.getGroupList());
        userRepository.save(add);
        return new ResponseEntity<>(userModelAssembler.toModel(add),HttpStatus.OK);
    }

    @PutMapping(value="/api/user/{id}", produces = "application/hal+json")
    public ResponseEntity<UserModel> updateUser(@PathVariable(name = "id") Integer id,@RequestBody User user) {
        User update =userService.findById(id);
        update.setFirstName(user.getFirstName());
        update.setLastName(user.getLastName());
        update.setRole(user.getRole());
        update.setGroupList(user.getGroupList());
        userRepository.save(update);
        return new ResponseEntity<>(userModelAssembler.toModel(update),HttpStatus.OK);
    }


    @DeleteMapping(value="/api/user/{id}", produces = "application/hal+json")
    public ResponseEntity<Void> deleteUser(@PathVariable(name="id") Integer id) {
        userRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    //Справочники



    @GetMapping(value="/api/group", produces = "application/hal+json")
    public ResponseEntity<CollectionModel<GroupModel>> getGroupAll() {
        List<Group> groupList = groupRepository.findAll();
        return new ResponseEntity<>(groupModelAssembler.toCollectionModel(groupList),HttpStatus.OK);
    }

    @PostMapping(value="/api/group", produces = "application/hal+json")
    public ResponseEntity<GroupModel> addGroup(@RequestBody Group group) {
        Group add= new Group();
        add.setGroupName(group.getGroupName());
        groupRepository.save(add);
        return new ResponseEntity<>(groupModelAssembler.toModel(add), HttpStatus.OK);
    }

    @GetMapping(value="/api/group/{id}", produces = "application/hal+json")
    public ResponseEntity<GroupModel> getGroupById(@PathVariable(name="id") Integer id) {
        return groupRepository.findById(id)
                .map(groupModelAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value="/api/group/{id}", produces = "application/hal+json")
    public ResponseEntity<GroupModel> updateGroup(@PathVariable(name="id") Integer id,@RequestBody Group group) {
        Group update = groupService.findById(id);
        update.setGroupName(group.getGroupName());
        groupRepository.save(update);
        return new ResponseEntity<>(groupModelAssembler.toModel(update), HttpStatus.OK);
    }

    @DeleteMapping(value="/api/group/{id}", produces = "application/hal+json")
    public ResponseEntity<Void> deleteGroup(@PathVariable(name="id") Integer id) {
        groupRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value="/api/role", produces = "application/hal+json")
    public ResponseEntity<CollectionModel<RoleModel>> getRoleAll() {
        List<Role> roleList = roleRepository.findAll();
        return new ResponseEntity<>(roleModelAssembler.toCollectionModel(roleList),HttpStatus.OK);
    }

    @PostMapping(value="/api/role", produces = "application/hal+json")
    public ResponseEntity<RoleModel> addRole(@RequestBody Role role) {
        Role add= new Role();
        add.setRoleName(role.getRoleName());
        roleRepository.save(add);
        return new ResponseEntity<>(roleModelAssembler.toModel(add), HttpStatus.OK);
    }

    @GetMapping(value="/api/role/{id}", produces = "application/hal+json")
    public ResponseEntity<RoleModel> getRoleById(@PathVariable(name="id") Integer id) {
        return roleRepository.findById(id)
                .map(roleModelAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value="/api/role/{id}", produces = "application/hal+json")
    public ResponseEntity<RoleModel> updateRole(@PathVariable(name="id") Integer id,@RequestBody Role role) {
        Role update = roleService.findById(id);
        update.setRoleName(role.getRoleName());
        roleRepository.save(update);
        return new ResponseEntity<>(roleModelAssembler.toModel(update), HttpStatus.OK);
    }

    @DeleteMapping(value="/api/role/{id}", produces = "application/hal+json")
    public ResponseEntity<Void> deleteRole(@PathVariable(name="id") Integer id) {
        roleRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
