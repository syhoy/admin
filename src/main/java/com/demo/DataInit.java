package com.demo;

import com.demo.entity.GroupEntity;
import com.demo.entity.RoleEntity;
import com.demo.entity.UserEntity;
import com.demo.entity.UserGroupEntity;
import com.demo.repository.GroupRepository;
import com.demo.repository.RoleRepository;
import com.demo.repository.UserGroupRepository;
import com.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements ApplicationRunner {

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    private GroupRepository groupRepository;
    private UserGroupRepository userGroupRepository;

    @Autowired
    public DataInit(UserRepository userRepository
            ,RoleRepository roleRepository
            , GroupRepository groupRepository
            ,UserGroupRepository userGroupRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.groupRepository = groupRepository;
        this.userGroupRepository = userGroupRepository;
    }

    @Override
    public void run(ApplicationArguments args)  {

       GroupEntity group = new GroupEntity();
        group.setGroupName("Группа продленного дня");
        groupRepository.save(group);

        group = new GroupEntity();
        group.setGroupName("Группа свидетелей Иеговы");
        groupRepository.save(group);

        group = new GroupEntity();
        group.setGroupName("Группа ссудного дня");
        groupRepository.save(group);

        group = new GroupEntity();
        group.setGroupName("Группа любителей пива и воблы");
        groupRepository.save(group);

        group = new GroupEntity();
        group.setGroupName("Группа сборщиков мебели");
        groupRepository.save(group);




        RoleEntity role1 = new RoleEntity();
        //role.setId(1);
        role1.setRoleName("Администратор");
        roleRepository.save(role1);

        RoleEntity role2 = new RoleEntity();
        //role.setId(2);
        role2.setRoleName("Руководитель");
        roleRepository.save(role2);


        UserEntity user=new UserEntity();
        user.setFirstName("Иван");
        user.setLastName("Иванов");
        user.setRole(role1);
        userRepository.save(user);

        user=new UserEntity();
        user.setFirstName("Петр");
        user.setLastName("Петров");
        user.setRole(role2);
        userRepository.save(user);

        user=new UserEntity();
        user.setFirstName("Сидор");
        user.setLastName("Сидоров");
        user.setRole(null);
        userRepository.save(user);

        user=new UserEntity();
        user.setFirstName("Сергей");
        user.setLastName("Сергеев");
        user.setRole(role2);
        userRepository.save(user);


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

    }
}
