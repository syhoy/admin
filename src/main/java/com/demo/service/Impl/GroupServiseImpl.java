package com.demo.service.Impl;

import com.demo.entity.Group;
import com.demo.repository.GroupRepository;
import com.demo.service.GroupService;
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
    public Group findById(Integer id) {
        return groupRepository.findById(id).orElse(null);
    }

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }
}
