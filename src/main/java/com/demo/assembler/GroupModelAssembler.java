package com.demo.assembler;

import com.demo.controller.WebController;
import com.demo.entity.GroupEntity;
import com.demo.entity.UserEntity;
import com.demo.model.GroupModel;
import com.demo.model.UserModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;



@Component
public class GroupModelAssembler extends RepresentationModelAssemblerSupport<GroupEntity, GroupModel> {

    public GroupModelAssembler() {
         super(WebController.class, GroupModel.class);
    }

    @Override
    public GroupModel toModel(GroupEntity entity) {
        GroupModel groupModel = instantiateModel(entity);

        Link link = linkTo(WebMvcLinkBuilder.methodOn(WebController.class).getGroupById(entity.getId())).withSelfRel();
        groupModel.add(link);

/*
        groupModel.add((Iterable<Link>) linkTo(
                methodOn(WebController.class)
                        .getUserById(entity.getId()))
                .withSelfRel());
*/
        groupModel.setId(entity.getId());
        groupModel.setGroupName(entity.getGroupName());

        return groupModel;
    }

    @Override
    public CollectionModel<GroupModel> toCollectionModel(Iterable<? extends GroupEntity> entities) {
        CollectionModel<GroupModel> groupModels = super.toCollectionModel(entities);

        //groupModel.add(linkTo(methodOn(WebController.class).getAllGroup()).withSelfRel());
        Link link = linkTo(methodOn(WebController.class).getAllGroup()).withSelfRel();
        groupModels.add(link);

        return groupModels;
    }


    //  public UserModelAssembler(Class<?> controllerClass, Class<UserModel> resourceType) {
  //      super(controllerClass, resourceType);
  //  }

}