package com.singh.user.service.userservice.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.singh.user.service.userservice.entities.User;
import com.singh.user.service.userservice.exceptions.ResourceNotFoundException;
import com.singh.user.service.userservice.repositories.UserRepository;
import com.singh.user.service.userservice.services.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User savUser(User user) {
        //generate unique userId
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);

        return userRepository.save(user);
    }

    @Override
    public List getAllUser() {

        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {

        return userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("user with given id is not found in server !!" + userId));
    }

    @Override
    public boolean deleteUserById(String userId) {
        User user = userRepository.findById(userId).get();
        if (user != null) {
            userRepository.deleteById(userId);
            return true;

        }
        return false;
    }

    @Override
    public User updatUser(User user, String userId) {
        User user2 = userRepository.findById(userId).get();
        if (user2 != null) {
            user2.setUserId("101");
            user2.setName("siddharth singh");
            user2.setEmail("siddharth.singh@gmail.com");
            user2.setAbout("something");
            userRepository.save(user2);
            return user2;
        }
        return null;
    }

}
