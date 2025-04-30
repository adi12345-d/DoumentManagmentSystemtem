package com.document.dmdemo.service;

import com.document.dmdemo.model.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity createUser (UserEntity user);
    UserEntity updateUser (UserEntity user);
    void deleteUser (Long userId);
    UserEntity getUserById(Long userId);
    UserEntity getUserByUsername(String username);
    List<UserEntity> getAllUsers();
}