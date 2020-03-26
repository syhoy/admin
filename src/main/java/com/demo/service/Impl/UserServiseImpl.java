package com.demo.service.Impl;

import com.demo.entity.Group;
import com.demo.entity.User;
import com.demo.repository.UserRepository;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserServiseImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<Group> getGList(Integer id) {
        return  userRepository.getGroupList(id);
    }
}
