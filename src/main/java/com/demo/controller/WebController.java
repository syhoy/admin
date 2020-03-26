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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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


    //Ендпоинты для моделей:

    @GetMapping(value="/api/user/", produces = "application/hal+json")
    public ResponseEntity<RootModel> getUser() {

        RootModel rootModel = new RootModel();

        rootModel.add(linkTo(methodOn(WebController.class).getUser()).withSelfRel());

        rootModel.add(linkTo(methodOn(WebController.class).getUserAll()).withRel("Users"));
        rootModel.add(linkTo(methodOn(WebController.class).getGroupAll()).withRel("Groups"));
        rootModel.add(linkTo(methodOn(WebController.class).getRoleAll()).withRel("Roles"));

        rootModel.add(linkTo(methodOn(WebController.class).getUser()).withSelfRel());

        return new ResponseEntity<>(rootModel,HttpStatus.OK);
    }


    @GetMapping(value="/api/user/all", produces = "application/hal+json")
    public ResponseEntity<CollectionModel<UserModel>> getUserAll() {
        List<User> userList = userRepository.findAll();
        return new ResponseEntity<>(userModelAssembler.toCollectionModel(userList), HttpStatus.OK);
    }

    @GetMapping(value="/api/user/{id}", produces = "application/hal+json")
    public ResponseEntity<UserModel> getUserById(@PathVariable(name = "id") Integer id) {
        Optional<User> user = userRepository.findById(id);
       return user.map(userModelAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping(value="/api/user/{id}/groups", produces = "application/hal+json")
    public ResponseEntity<UserModel> getUserByIdGroups(@PathVariable(name = "id") Integer id) {
        //Optional<User> user = userRepository.findById(id);
        User user = userRepository.findById(id).orElse(null);

        user.setGroupList(userRepository.getGroupList(id));

        return new ResponseEntity<>(userModelAssembler.toModel(user),HttpStatus.OK);
                //.map(ResponseEntity::ok)
                //.orElse(ResponseEntity.notFound().build());
    }




    //****

    @GetMapping(value="/api/group/all", produces = "application/hal+json")
    public ResponseEntity<CollectionModel<GroupModel>> getGroupAll() {
        List<Group> groupList = groupRepository.findAll();
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

    @GetMapping(value="/api/role/all", produces = "application/hal+json")
    public ResponseEntity<CollectionModel<RoleModel>> getRoleAll() {
        List<Role> roleList = roleRepository.findAll();
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
