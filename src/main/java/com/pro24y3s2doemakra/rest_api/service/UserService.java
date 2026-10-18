package com.pro24y3s2doemakra.rest_api.service;

import com.pro24y3s2doemakra.rest_api.dto.request.UserRequest;
import com.pro24y3s2doemakra.rest_api.dto.response.UserResponse;
import com.pro24y3s2doemakra.rest_api.entity.User;

public interface UserService {
    UserResponse create(UserRequest user);
    User getById(Long id);
    User updateById(Long id, User user);
    void deleteById(Long id);
}
