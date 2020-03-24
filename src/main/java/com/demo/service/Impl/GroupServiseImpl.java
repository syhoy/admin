package com.demo.service.Impl;

import com.demo.entity.GroupEntity;
import com.demo.entity.RoleEntity;
import com.demo.repository.GroupRepository;
import com.demo.repository.RoleRepository;
import com.demo.service.GroupService;
import com.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class GroupServiseImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public GroupEntity findById(Integer id) {
        return groupRepository.findById(id).orElse(null);
    }

    @Override
    public List<GroupEntity> findAll() {
        return groupRepository.findAll();
    }
}
