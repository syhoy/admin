package com.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.*;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.util.List;

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
    //private List<UserModel> userList;

}
