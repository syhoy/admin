package com.demo.assembler;

import com.demo.controller.WebController;
import com.demo.entity.Group;
import com.demo.model.GroupModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;



@Component
public class GroupModelAssembler extends RepresentationModelAssemblerSupport<Group, GroupModel> {

    public GroupModelAssembler() {
         super(WebController.class, GroupModel.class);
    }

    @Override
    public GroupModel toModel(Group entity) {
        GroupModel groupModel = instantiateModel(entity);


        groupModel.add(linkTo(WebMvcLinkBuilder.methodOn(WebController.class).getGroupById(entity.getId())).withSelfRel());

        groupModel.setId(entity.getId());
        groupModel.setGroupName(entity.getGroupName());

        return groupModel;
    }

    @Override
    public CollectionModel<GroupModel> toCollectionModel(Iterable<? extends Group> entities) {
        CollectionModel<GroupModel> groupModels = super.toCollectionModel(entities);
        groupModels.add(linkTo(methodOn(WebController.class).getGroupAll()).withSelfRel());
        return groupModels;
    }


    //  public UserModelAssembler(Class<?> controllerClass, Class<UserModel> resourceType) {
  //      super(controllerClass, resourceType);
  //  }

}