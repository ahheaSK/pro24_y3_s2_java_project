package com.pro24y3s2doemakra.rest_api.service.impl;

import com.pro24y3s2doemakra.rest_api.entity.User;
import com.pro24y3s2doemakra.rest_api.repository.UserRepository;
import com.pro24y3s2doemakra.rest_api.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

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


    @Override
    public User updateById(Long id, User user) {
        User user1 = userRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("Data Not Found")
                );
        user1.setUsername(user.getUsername());
        user1.setNickName(user.getNickName());

        return userRepository.save(user1);

    }

    @Override
    public User getById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("Data Not Found")
                );

        return user;
    }

}
