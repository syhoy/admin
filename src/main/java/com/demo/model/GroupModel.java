package com.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "group")
@Relation(collectionRelation = "groupList")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GroupModel extends RepresentationModel<GroupModel> {

    private Integer id;
    private String groupName;
    List<UserModel> userList;

}
