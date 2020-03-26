package com.demo.assembler;

import com.demo.controller.WebController;
import com.demo.entity.Group;
import com.demo.entity.Role;
import com.demo.entity.User;
import com.demo.model.GroupModel;
import com.demo.model.RoleModel;
import com.demo.model.UserModel;
import org.springframework.hateoas.CollectionModel;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.Link;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Component;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;



@Component
public class UserModelAssembler extends RepresentationModelAssemblerSupport<User, UserModel> {

    public UserModelAssembler() {
        super(WebController.class, UserModel.class);
    }

    @Override
    public UserModel toModel(User entity) {
        UserModel userModel = instantiateModel(entity);
        Link link = linkTo(methodOn(WebController.class).getUserById(entity.getId())).withSelfRel();
        userModel.add(link);
        userModel.setId(entity.getId());
        userModel.setFirstName(entity.getFirstName());
        userModel.setLastName(entity.getLastName());
        userModel.setRole(toRoleModel(entity.getRole()));
        userModel.add(linkTo(methodOn(WebController.class).getUserByIdGroups(userModel.getId())).withRel("groups"));
        userModel.setGroupList(toCroupModel(entity.getGroupList()));
        return userModel;
    }

    @Override
    public CollectionModel<UserModel> toCollectionModel(Iterable<? extends User> entities) {
        CollectionModel<UserModel> userModels = super.toCollectionModel(entities);
        Link link = linkTo(methodOn(WebController.class).getUserAll()).withSelfRel();
        userModels.add(link);
        return userModels;
    }

    private List<GroupModel> toCroupModel(List<Group> groupList) {
        if (groupList.isEmpty())
            return Collections.emptyList();



        return groupList.stream()
                .map(gr -> GroupModel.builder()
                        .id(gr.getId())
                        .groupName(gr.getGroupName())
                        .build()
                        .add(linkTo(methodOn(WebController.class).getGroupById(gr.getId())).withSelfRel()))
                .collect(Collectors.toList());
    }

    private RoleModel toRoleModel(Role entity) {

        RoleModel roleModel= new RoleModel();

        if (entity==null) return null;
        Link link = linkTo(methodOn(WebController.class).getRoleById(entity.getId())).withSelfRel();
        roleModel.add(link);


        roleModel.setId(entity.getId());
        roleModel.setRoleName(entity.getRoleName());
        return  roleModel;
    }



}