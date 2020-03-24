package com.demo.service.Impl;

import com.demo.entity.GroupEntity;
import com.demo.entity.UserGroupEntity;
import com.demo.repository.GroupRepository;
import com.demo.repository.UserGroupRepository;
import com.demo.service.GroupService;
import com.demo.service.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserGroupServiseImpl implements UserGroupService {

    @Autowired
    private UserGroupRepository userGroupRepository;

    @Override
    public List<UserGroupEntity> findAll() {
        return userGroupRepository.findAll();
    }
}
