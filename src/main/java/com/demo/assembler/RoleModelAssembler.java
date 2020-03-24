package com.demo.assembler;

import com.demo.controller.WebController;
import com.demo.entity.GroupEntity;
import com.demo.entity.RoleEntity;
import com.demo.model.GroupModel;
import com.demo.model.RoleModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Component
public class RoleModelAssembler extends RepresentationModelAssemblerSupport<RoleEntity, RoleModel> {

    public RoleModelAssembler() {
         super(WebController.class, RoleModel.class);
    }

    @Override
    public RoleModel toModel(RoleEntity entity) {
        RoleModel roleModel = instantiateModel(entity);

        Link link = linkTo(WebMvcLinkBuilder.methodOn(WebController.class).getRoleById(entity.getId())).withSelfRel();
        roleModel.add(link);

        roleModel.setId(entity.getId());
        roleModel.setRoleName(entity.getRoleName());

        return roleModel;
    }

    @Override
    public  CollectionModel<RoleModel> toCollectionModel(Iterable<? extends RoleEntity> entities) {
        CollectionModel<RoleModel> roleModels = super.toCollectionModel(entities);

        //groupModel.add(linkTo(methodOn(WebController.class).getAllGroup()).withSelfRel());
        Link link = linkTo(methodOn(WebController.class).getAllRole()).withSelfRel();
        roleModels.add(link);

        return roleModels;
    }


    //  public UserModelAssembler(Class<?> controllerClass, Class<UserModel> resourceType) {
  //      super(controllerClass, resourceType);
  //  }

}