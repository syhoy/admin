package com.demo.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user_group")
public class UserGroupEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "group_id", nullable = false)
    private Integer groupId;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

}
