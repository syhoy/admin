package com.demo.service.Impl;

import com.demo.entity.Role;
import com.demo.entity.User;
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

public class UserServiseImplTest {

    @Autowired
    private UserService userService;


    @Autowired
    private RoleService roleService;


    @Test
    public void  testFindAll(){

        List<User> userList = userService.findAll();

        userList.forEach(u->
            System.out.println("## user:"+u));
    }

    @Test
    public void  testFindById(){
        int id = 1;
        User user = userService.findById(id);

        System.out.println("## user:"+user);

        System.out.println("## user:"+userService.getGList(1));



        // user.getGroupList().forEach(g->System.out.println("## group:"+g.getGroupName()));
        //System.out.println("## user:"+user.getLastName());

        //Role role = roleService.findById(2);
        //System.out.println("## role:"+role.getRoleName());

        //role.getUserList().forEach(x->System.out.println("## user:"+x.getLastName()));

        //List<User> ul = role.getUserList();

        //System.out.println("## userlist:"+ul);




    }

}