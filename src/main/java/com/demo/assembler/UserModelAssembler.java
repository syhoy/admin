package com.demo.assembler;

import com.demo.controller.GroupController;
import com.demo.controller.UserController;
import com.demo.controller.WebController;
import com.demo.entity.GroupEntity;
import com.demo.entity.RoleEntity;
import com.demo.entity.UserEntity;
import com.demo.model.GroupModel;
import com.demo.model.RoleModel;
import com.demo.model.UserModel;
import org.springframework.hateoas.CollectionModel;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.Link;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Component;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;



@Component
public class UserModelAssembler extends RepresentationModelAssemblerSupport<UserEntity, UserModel> {

    public UserModelAssembler() {
        super(WebController.class, UserModel.class);
    }

    @Override
    public UserModel toModel(UserEntity entity) {
        UserModel userModel = instantiateModel(entity);
        Link link = linkTo(methodOn(WebController.class).getUserById(entity.getId())).withSelfRel();
        userModel.add(link);
        userModel.setId(entity.getId());
        userModel.setFirstName(entity.getFirstName());
        userModel.setLastName(entity.getLastName());
        userModel.setRole(toRoleModel(entity.getRole()));
        userModel.setGroupList(toCroupModel(entity.getGroupList()));
        return userModel;
    }

    @Override
    public CollectionModel<UserModel> toCollectionModel(Iterable<? extends UserEntity> entities) {
        CollectionModel<UserModel> userModels = super.toCollectionModel(entities);
        Link link = linkTo(methodOn(WebController.class).getAllUser()).withSelfRel();
        userModels.add(link);
        return userModels;
    }

    private List<GroupModel> toCroupModel(List<GroupEntity> groupList) {
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

    private RoleModel toRoleModel(RoleEntity entity) {

        RoleModel roleModel= new RoleModel();

        //Integer id = entity.getId();

        if (entity==null) return null;
        Link link = linkTo(methodOn(WebController.class).getRoleById(entity.getId())).withSelfRel();
        roleModel.add(link);


        roleModel.setId(entity.getId());
        roleModel.setRoleName(entity.getRoleName());
        return  roleModel;
    }



}