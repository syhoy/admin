package com.demo;

import com.demo.entity.Group;
import com.demo.entity.Role;
import com.demo.entity.User;
import com.demo.repository.GroupRepository;
import com.demo.repository.RoleRepository;
import com.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;


//Заполнение данными БД
@Component
public class DataInit implements ApplicationRunner {

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    private GroupRepository groupRepository;



    @Autowired
    public DataInit(UserRepository userRepository
            ,RoleRepository roleRepository
            , GroupRepository groupRepository
            ) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.groupRepository = groupRepository;

    }

    @Override
    public void run(ApplicationArguments args)  {
        //Группы
        Group group1 = new Group();
        group1.setGroupName("Группа продленного дня");
        groupRepository.save(group1);

        Group group2 = new Group();
        group2.setGroupName("Группа свидетелей Иеговы");
        groupRepository.save(group2);

        Group group3 = new Group();
        group3.setGroupName("Группа ссудного дня");
        groupRepository.save(group3);

        Group group4 = new Group();
        group4.setGroupName("Группа любителей пива и воблы");
        groupRepository.save(group4);

        Group group5 = new Group();
        group5.setGroupName("Группа сборщиков мебели");
        groupRepository.save(group5);

        Group group6 = new Group();
        group6.setGroupName("Группа крови на рукаве");
        groupRepository.save(group6);

        //роли
        Role role1 = new Role();
        //role.setId(1);
        role1.setRoleName("Администратор");
        roleRepository.save(role1);

        Role role2 = new Role();
        //role.setId(2);
        role2.setRoleName("Руководитель");
        roleRepository.save(role2);

        //пользователи
        User user=new User();
        user.setFirstName("Иван");
        user.setLastName("Иванов");
        user.setRole(role1);

        user.getGroupList().addAll(Arrays.asList(group1, group2, group3, group4, group6));
        userRepository.save(user);




        user=new User();
        user.setFirstName("Петр");
        user.setLastName("Петров");
        user.setRole(role2);
        user.getGroupList().add(group1);
        userRepository.save(user);

        user=new User();
        user.setFirstName("Сидор");
        user.setLastName("Сидоров");
        user.setRole(null);
        user.getGroupList().addAll(Arrays.asList(group1, group4, group3));
        userRepository.save(user);

        user=new User();
        user.setFirstName("Сергей");
        user.setLastName("Сергеев");
        user.setRole(role2);
        userRepository.save(user);



        //Связи пользоватедь - группа
        /*
        UserGroupEntity userGroup = new UserGroupEntity();
        userGroup.setGroupId(1);
        userGroup.setUserId(1);
        userGroupRepository.save(userGroup);

        userGroup = new UserGroupEntity();
        userGroup.setGroupId(2);
        userGroup.setUserId(1);
        userGroupRepository.save(userGroup);

        userGroup = new UserGroupEntity();
        userGroup.setGroupId(3);
        userGroup.setUserId(1);
        userGroupRepository.save(userGroup);

        userGroup = new UserGroupEntity();
        userGroup.setGroupId(4);
        userGroup.setUserId(1);
        userGroupRepository.save(userGroup);


        userGroup = new UserGroupEntity();
        userGroup.setGroupId(4);
        userGroup.setUserId(3);
        userGroupRepository.save(userGroup);

        userGroup = new UserGroupEntity();
        userGroup.setGroupId(1);
        userGroup.setUserId(3);
        userGroupRepository.save(userGroup);
*/
    }
}
