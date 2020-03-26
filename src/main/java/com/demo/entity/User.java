package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.collection.internal.PersistentList;
import org.springframework.transaction.annotation.Transactional;

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
//@PersistenceContext(type = PersistenceContextType.EXTENDED)
//@Transactional()
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


    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    //todo
    @ToString.Exclude
    //@ManyToMany(fetch = FetchType.EAGER)  //???????
    @ManyToMany(fetch = FetchType.LAZY)  //???????
    @JoinTable(
            name = "user_group",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))

    List<Group> groupList = new ArrayList<>();
}
