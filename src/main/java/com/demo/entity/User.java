package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

   // @Column(name = "role_id")
    //private Integer roleId;
    //@ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "role_id")
    //@JsonBackReference
    //@JsonManagedReference
    //@JsonIgnore
    private Role role;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_group",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    //@JsonIgnore
    // @JsonBackReference
    //@JsonManagedReference
    List<Group> groupList=new ArrayList<>();
}
