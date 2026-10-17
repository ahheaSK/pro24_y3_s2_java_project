package com.pro24y3s2doemakra.rest_api.repository;

import com.pro24y3s2doemakra.rest_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
