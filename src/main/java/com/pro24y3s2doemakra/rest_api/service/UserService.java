package com.pro24y3s2doemakra.rest_api.service;

import com.pro24y3s2doemakra.rest_api.entity.User;

public interface UserService {
    void create(User user);
    User getById(Long id);
    User updateById(Long id, User user);
    void deleteById(Long id);
}
