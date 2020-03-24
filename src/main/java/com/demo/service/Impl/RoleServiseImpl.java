package com.demo.service.Impl;

import com.demo.entity.RoleEntity;
import com.demo.repository.RoleRepository;
import com.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class RoleServiseImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<RoleEntity> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public RoleEntity findById(Integer id) {
        return roleRepository.findById(id).orElse(null);
    }
}
