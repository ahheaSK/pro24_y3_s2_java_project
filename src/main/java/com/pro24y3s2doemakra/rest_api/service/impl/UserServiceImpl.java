package com.pro24y3s2doemakra.rest_api.service.impl;

import com.pro24y3s2doemakra.rest_api.entity.User;
import com.pro24y3s2doemakra.rest_api.repository.UserRepository;
import com.pro24y3s2doemakra.rest_api.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    UserServiceImpl(UserRepository repository) {
        this.userRepository = repository;
    }


    @Override
    public void create(User user) {
        user.setId(0);
        userRepository.save(user);
    }
}
