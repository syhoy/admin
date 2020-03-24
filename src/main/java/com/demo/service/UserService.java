package com.demo.service;

import com.demo.entity.UserEntity;
import com.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public interface UserService {

    List<UserEntity> findAll();


    UserEntity findById(Integer id);
}
