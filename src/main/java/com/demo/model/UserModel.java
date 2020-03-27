package com.demo.model;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.*;
import org.springframework.hateoas.*;
import org.springframework.hateoas.server.core.Relation;


import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "user")
@Relation(collectionRelation = "users")
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserModel extends RepresentationModel<UserModel> {

    private Integer id;
    private String firstName;
    private String lastName;
    private RoleModel role;
    List<GroupModel> groupList;

}
