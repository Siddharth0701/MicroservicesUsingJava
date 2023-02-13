package com.singh.user.service.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.singh.user.service.userservice.entities.User;
import com.singh.user.service.userservice.services.impl.UserServiceImpl;

@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    private UserServiceImpl userserviceImpl;

    // create
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savUser = userserviceImpl.savUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savUser);
    }

    // getAllUser
    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        List<User> allUser = userserviceImpl.getAllUser();
        return ResponseEntity.ok(allUser);

    }

    @GetMapping("{userId}")
    // getSingleUser
    public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
        User user = userserviceImpl.getUser(userId);
        return ResponseEntity.ok(user);

    }

    

}
