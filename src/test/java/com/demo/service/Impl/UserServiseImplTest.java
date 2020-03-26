package com.demo.service.Impl;

import com.demo.entity.Group;
import com.demo.entity.Role;
import com.demo.entity.User;
import com.demo.service.RoleService;
import com.demo.service.UserService;
import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.concurrent.atomic.AtomicMarkableReference;


@SpringBootTest
@RunWith(SpringRunner.class)

public class UserServiseImplTest {

    @Autowired
    private UserService userService;


    @Autowired
    private RoleService roleService;


    //@Autowired
   // private EntityManagerFactory emf;

    //@PersistenceContext
    @Autowired
    private EntityManager entityManager;



    @Test
    public void  testFindAll(){

        List<User> userList = userService.findAll();

        userList.forEach(u->
            System.out.println("## user:"+u));
    }

    @Test
    public void  testFindById(){
        Integer id = 1;

        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("User");
        User user = userService.findById(id);

        System.out.println("## user:"+user);

         //em=emf.createEntityManager();

        List<Group> gl = user.getGroupList();


        user.setGroupList(userService.getGroupList(1));

        gl = user.getGroupList();

        System.out.println("## gl:"+gl);

        //System.out.println("## user:"+user);

        //EntityManager entityManager = emf.createEntityManager();

        //User user2 = entityManager.getReference(User.class, id);

        //User user2 = entityManager.find(User.class, id);

        //User user2 = session.load(User.class,id);


        //System.out.println("## user:"+user);

        //System.out.println("## user:"+userService.getGList(1));



        // user.getGroupList().forEach(g->System.out.println("## group:"+g.getGroupName()));
        //System.out.println("## user:"+user.getLastName());

        //Role role = roleService.findById(2);
        //System.out.println("## role:"+role.getRoleName());

        //role.getUserList().forEach(x->System.out.println("## user:"+x.getLastName()));

        //List<User> ul = role.getUserList();

        //System.out.println("## userlist:"+ul);




    }

}