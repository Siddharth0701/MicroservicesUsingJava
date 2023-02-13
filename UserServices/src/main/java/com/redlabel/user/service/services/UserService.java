package com.redlabel.user.service.services;

import java.util.List;

import com.redlabel.user.service.entities.User;

public interface UserService<T> {
    // user operation
    // Create
    User savUser(User user);

    // get all user
    List<User> getAllUser();

    // get Single user by id
    User getUser(String userId);

    
}