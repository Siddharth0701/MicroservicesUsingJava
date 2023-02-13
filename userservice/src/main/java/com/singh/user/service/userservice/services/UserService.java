package com.singh.user.service.userservice.services;

import com.singh.user.service.userservice.entities.User;

import java.util.List;

public interface UserService<T> {
    // user operation
    // Create
    User savUser(User user);

    // get all user
    List<User> getAllUser();

    // get Single user by id
    User getUser(String userId);

    
}
