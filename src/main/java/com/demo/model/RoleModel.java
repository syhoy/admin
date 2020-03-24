package com.demo.model;

import com.demo.entity.GroupEntity;
import com.demo.entity.RoleEntity;
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
@JsonRootName(value = "role")
@Relation(collectionRelation = "roleList")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleModel extends RepresentationModel<RoleModel> {

    private Integer id;
    private String roleName;
    List<UserModel> userList;

}
