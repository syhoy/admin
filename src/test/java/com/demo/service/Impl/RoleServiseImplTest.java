package com.demo.service.Impl;

import com.demo.entity.RoleEntity;
import com.demo.entity.UserEntity;
import com.demo.service.RoleService;
import com.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)

public class RoleServiseImplTest {

    @Autowired
    private UserService userService;


    @Autowired
    private RoleService roleService;


    @Test
    public void  testFindAll(){

        List<RoleEntity> roleList = roleService.findAll();

        roleList.forEach(r->
            System.out.println("## role:"+r));


        // user.getGroupList().forEach(g->System.out.println("## group:"+g.getGroupName()));
        //System.out.println("## user:"+user.getLastName());

        //RoleEntity role = roleService.findById(2);
        //System.out.println("## role:"+role.getRoleName());

        //role.getUserList().forEach(x->System.out.println("## user:"+x.getLastName()));

        //List<UserEntity> ul = role.getUserList();

        //System.out.println("## userlist:"+ul);




    }

    @Test
    public void  testFindById(){
        int id = 1;
        UserEntity user = userService.findById(id);

        // user.getGroupList().forEach(g->System.out.println("## group:"+g.getGroupName()));
        System.out.println("## user:"+user.getLastName());

        RoleEntity role = roleService.findById(2);
        System.out.println("## role:"+role.getRoleName());

        //role.getUserList().forEach(x->System.out.println("## user:"+x.getLastName()));

        List<UserEntity> ul = role.getUserList();

        System.out.println("## userlist:"+ul);




    }

}