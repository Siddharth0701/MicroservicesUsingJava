package com.singh.user.service.userservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.singh.user.service.userservice.entities.User;


public interface UserRepository extends JpaRepository<User,String> {
    //repository
}
