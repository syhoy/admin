package com.demo.controller;


import com.demo.assembler.GroupModelAssembler;
import com.demo.assembler.RoleModelAssembler;
import com.demo.assembler.UserModelAssembler;
import com.demo.entity.GroupEntity;
import com.demo.entity.RoleEntity;
import com.demo.entity.UserEntity;
import com.demo.model.GroupModel;
import com.demo.model.RoleModel;
import com.demo.model.RootModel;
import com.demo.model.UserModel;
import com.demo.repository.GroupRepository;
import com.demo.repository.RoleRepository;
import com.demo.repository.UserRepository;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
    private UserModelAssembler userModelAssembler;

    @Autowired
    private GroupModelAssembler groupModelAssembler;

    @Autowired
    private RoleModelAssembler roleModelAssembler;


    @GetMapping(value="/api/root", produces = "application/hal+json")
    public ResponseEntity<RootModel> getRoot() {
        RootModel rootModel = new RootModel(linkTo(methodOn(WebController.class).getRoot()).withSelfRel());

        return new ResponseEntity<>(rootModel,HttpStatus.OK);
    }


    @GetMapping(value="/api/root/user", produces = "application/hal+json")
    public ResponseEntity<RootModel> getRootUser() {
        RootModel rootModel = new RootModel();

        Link link = linkTo(methodOn(WebController.class).getRootUser()).withSelfRel();
        rootModel.add(link);

        List<UserEntity> userList = userRepository.findAll();

        CollectionModel<UserModel> userModels = userModelAssembler.toCollectionModel(userList);
        rootModel.setUserList(userModels);

        return new ResponseEntity<>(rootModel,HttpStatus.OK);
    }

    @GetMapping(value="/api/root/user/{id}", produces = "application/hal+json")
    public ResponseEntity<RootModel> getRootUserById(@PathVariable(name = "id") Integer id) {
        RootModel rootModel = new RootModel();

        Link link = linkTo(methodOn(WebController.class).getRootUserById(id)).withSelfRel();
        rootModel.add(link);

        List<UserEntity> userList = new ArrayList<>();

        userRepository.findById(id).ifPresent(u->userList.add(u));

        CollectionModel<UserModel> userModels = userModelAssembler.toCollectionModel(userList);
        rootModel.setUserList(userModels);

        return new ResponseEntity<>(rootModel,HttpStatus.OK);
    }

    @GetMapping(value="/api/root/group", produces = "application/hal+json")
    public ResponseEntity<RootModel> getRootGroup() {


        RootModel rootModel = new RootModel();

        Link link = linkTo(methodOn(WebController.class).getRootGroup()).withSelfRel();
        rootModel.add(link);

        List<GroupEntity> groupList = groupRepository.findAll();

        CollectionModel<GroupModel> groupModels = groupModelAssembler.toCollectionModel(groupList);
        rootModel.setGroupList(groupModels);

        return new ResponseEntity<>(rootModel,HttpStatus.OK);
    }


    @GetMapping(value="/api/root/group/{id}", produces = "application/hal+json")
    public ResponseEntity<RootModel> getRootGroupById(@PathVariable(name = "id") Integer id) {
        RootModel rootModel = new RootModel();

        Link link = linkTo(methodOn(WebController.class).getRootGroupById(id)).withSelfRel();
        rootModel.add(link);

        List<GroupEntity> groupList = new ArrayList<>();

        groupRepository.findById(id).ifPresent(g->groupList.add(g));

        CollectionModel<GroupModel> groupModels = groupModelAssembler.toCollectionModel(groupList);
        rootModel.setGroupList(groupModels);

        return new ResponseEntity<>(rootModel,HttpStatus.OK);
    }


    @GetMapping(value="/api/user", produces = "application/hal+json")
    public ResponseEntity<CollectionModel<UserModel>> getAllUser() {
        List<UserEntity> userList = userRepository.findAll();
        return new ResponseEntity<>(
                userModelAssembler.toCollectionModel(userList),
                HttpStatus.OK);
    }

    @GetMapping(value="/api/user/{id}", produces = "application/hal+json")
    public ResponseEntity<UserModel> getUserById(@PathVariable(name = "id") Integer id) {


        Optional<UserEntity> user = userRepository.findById(id);


        return user.map(userModelAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping(value="/api/group", produces = "application/hal+json")
    public ResponseEntity<CollectionModel<GroupModel>> getAllGroup() {
        List<GroupEntity> groupList = groupRepository.findAll();
        return new ResponseEntity<>(
                groupModelAssembler.toCollectionModel(groupList),
                HttpStatus.OK);
    }

    @GetMapping(value="/api/group/{id}", produces = "application/hal+json")
    public ResponseEntity<GroupModel> getGroupById(@PathVariable(name="id") Integer id) {
        return groupRepository.findById(id)
                .map(groupModelAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(value="/api/role", produces = "application/hal+json")
    public ResponseEntity<CollectionModel<RoleModel>> getAllRole() {
        List<RoleEntity> roleList = roleRepository.findAll();
        return new ResponseEntity<>(
                roleModelAssembler.toCollectionModel(roleList),
                HttpStatus.OK);
    }

    @GetMapping(value="/api/role/{id}", produces = "application/hal+json")
    public ResponseEntity<RoleModel> getRoleById(@PathVariable(name="id") Integer id) {
        return roleRepository.findById(id)
                .map(roleModelAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
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
