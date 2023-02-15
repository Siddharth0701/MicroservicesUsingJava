package com.redlabel.user.service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redlabel.user.service.entities.User;
import com.redlabel.user.service.services.impl.UserServiceImpl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    private UserServiceImpl userserviceImpl;
    private Logger logger = LoggerFactory.getLogger(UserController.class);

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
    int retryCount=1;

    @GetMapping("{userId}")
    // @CircuitBreaker(name = "ratingHoterBreaker", fallbackMethod =
    // "ratingHotelFallback")
    @Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallback")
    // getSingleUser
    public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
        logger.info("Get Single User Handler: UserController");
        logger.info("Retry count:{}", retryCount);
        retryCount++;
        User user = userserviceImpl.getUser(userId);
        return ResponseEntity.ok(user);

    }

    // created fall back method for circuit braker
   
    public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex) {
        //logger.info("Fallback is executed because service is down : ", ex.getMessage());
        User user = User.builder().email("dummy@gmail.com").name("Dummy")
                .about("This user is created dummy because some service is down").userId("141234").build();
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

}
