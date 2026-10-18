package com.pro24y3s2doemakra.rest_api.service.impl;

import com.pro24y3s2doemakra.rest_api.dto.request.UserRequest;
import com.pro24y3s2doemakra.rest_api.dto.response.UserResponse;
import com.pro24y3s2doemakra.rest_api.entity.User;
import com.pro24y3s2doemakra.rest_api.mapper.UserMapper;
import com.pro24y3s2doemakra.rest_api.repository.UserRepository;
import com.pro24y3s2doemakra.rest_api.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    UserServiceImpl(UserRepository repository, UserMapper userMapper) {

        this.userRepository = repository;
        this.userMapper = userMapper;
    }


    @Override
    public UserResponse create(UserRequest user) {
        //Reference Type objectNam Object
        User userEntity = new User();
        userEntity.setNickName(user.getNickName());
        userEntity.setUsername(user.getUsername());
        userEntity.setPasswordHash(user.getPasswordHash());
        userEntity.setEnabled(user.isEnabled());

        User save = userRepository.save(userEntity);

        UserResponse userResponse = new UserResponse();

        userResponse.setId(save.getId());
        userResponse.setNickName(save.getNickName());
        userResponse.setUsername(save.getUsername());
        userResponse.setEnabled(save.getEnabled());

        return userResponse;
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
    public void deleteById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("Data User Not Found with id: " + id)
                );
        userRepository.delete(user);
    }

    @Override
    public UserResponse getById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("Data Not Found")
                );

        return userMapper.toResponse(user);
    }

}
