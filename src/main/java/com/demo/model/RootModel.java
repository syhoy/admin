package com.demo.model;

import com.demo.controller.WebController;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Data
@Builder
//@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "root")
@Relation(itemRelation = "root")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RootModel extends RepresentationModel<RootModel> {

    private final String content;

    @JsonCreator
    public RootModel(@JsonProperty("content") String content) {
        this.content = content;

        this.add(linkTo(methodOn(WebController.class).getUser()).withSelfRel());



        this.add(linkTo(methodOn(WebController.class).getUserAll()).withRel("users").withType("get"));

        this.add(linkTo(methodOn(WebController.class).addUser(null)).withRel("user").withType("post"));
        this.add(linkTo(methodOn(WebController.class).updateUser(null,null)).withRel("user").withType("put"));
        this.add(linkTo(methodOn(WebController.class).deleteUser(null)).withRel("user").withType("delete"));

        this.add(linkTo(methodOn(WebController.class).getUserByIdGroup(null)).withRel("user").withType("get"));


        this.add(linkTo(methodOn(WebController.class).getGroupAll()).withRel("groups").withType("get"));

        this.add(linkTo(methodOn(WebController.class).addGroup(null)).withRel("group").withType("post"));
        this.add(linkTo(methodOn(WebController.class).updateGroup(null,null)).withRel("group").withType("put"));
        this.add(linkTo(methodOn(WebController.class).deleteGroup(null)).withRel("group").withType("delete"));

        this.add(linkTo(methodOn(WebController.class).getRoleAll()).withRel("roles").withType("get"));

        this.add(linkTo(methodOn(WebController.class).addRole(null)).withRel("role").withType("post"));
        this.add(linkTo(methodOn(WebController.class).updateRole(null,null)).withRel("role").withType("put"));
        this.add(linkTo(methodOn(WebController.class).deleteRole(null)).withRel("role").withType("delete"));

    }

    public String getContent() {
        return content;
    }
}
