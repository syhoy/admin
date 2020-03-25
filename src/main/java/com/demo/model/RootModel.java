package com.demo.model;

import com.demo.controller.WebController;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.*;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "root")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RootModel extends RepresentationModel<RootModel> {
    //private UserModel user;
    private CollectionModel<UserModel> userList;

    private CollectionModel<GroupModel> groupList;

    private CollectionModel<RoleModel> roleList;

    public RootModel(Link initialLink) {
        super(initialLink);
    }

}
