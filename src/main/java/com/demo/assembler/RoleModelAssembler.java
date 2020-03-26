package com.demo.assembler;

import com.demo.controller.WebController;
import com.demo.entity.Role;
import com.demo.model.RoleModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Component
public class RoleModelAssembler extends RepresentationModelAssemblerSupport<Role, RoleModel> {

    public RoleModelAssembler() {
         super(WebController.class, RoleModel.class);
    }

    @Override
    public RoleModel toModel(Role entity) {
        RoleModel roleModel = instantiateModel(entity);

        roleModel.add(linkTo(WebMvcLinkBuilder.methodOn(WebController.class).getRoleById(entity.getId())).withSelfRel());

        roleModel.setId(entity.getId());
        roleModel.setRoleName(entity.getRoleName());

        return roleModel;
    }

    @Override
    public  CollectionModel<RoleModel> toCollectionModel(Iterable<? extends Role> entities) {
        CollectionModel<RoleModel> roleModels = super.toCollectionModel(entities);

        roleModels.add( linkTo(methodOn(WebController.class).getRoleAll()).withSelfRel());

        return roleModels;
    }


    //  public UserModelAssembler(Class<?> controllerClass, Class<UserModel> resourceType) {
  //      super(controllerClass, resourceType);
  //  }

}