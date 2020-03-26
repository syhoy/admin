package com.demo.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role")
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "role_name", nullable = false)
    private String roleName;


   // @ToString.Exclude
   // @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.EAGER)//, orphanRemoval = true)
    //@JsonIgnore
    //@JsonBackReference
    //@JsonManagedReference
    //private List<User> userList;// = new ArrayList<User>();

}
