package com.singh.user.service.userservice.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.singh.user.service.userservice.entities.Hotel;
import com.singh.user.service.userservice.entities.Rating;
import com.singh.user.service.userservice.entities.User;
import com.singh.user.service.userservice.exceptions.ResourceNotFoundException;
import com.singh.user.service.userservice.repositories.UserRepository;
import com.singh.user.service.userservice.services.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User savUser(User user) {
		// generate unique userId
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);

		return userRepository.save(user);
	}

	@Override
	public List getAllUser() {

		return userRepository.findAll();
	}

//    @Override
//    public User getUser(String userId) {
//
//        return userRepository.findById(userId).orElseThrow(
//                () -> new ResourceNotFoundException("user with given id is not found in server !!" + userId));
//    }
	// get single user
	@Override
	public User getUser(String userId) {
		// get user from database with the help of user repository
		User user = userRepository.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("user with given id is not found in server !!" + userId));
		// fetch rating of the above user from rating
		// http://localhost:8083/api/rating/users/5290c29a-c5f5-4fdc-873f-38c55b0df1da
		
//	Rating[] ratingOfUser = restTemplate
//				.getForObject("http://localhost:8083/api/rating/users/" + user.getUserId(), Rating[].class);
		Rating[] ratingOfUser = restTemplate.getForObject("http://localhost:8083/api/rating/users/" + user.getUserId(), Rating[].class);
		logger.info("{}", ratingOfUser);
		
		 List<Rating> ratings = Arrays.stream(ratingOfUser).toList();
		List<Rating> collectionList =ratings.stream().map(rating -> {
			// api call to hotel service to get the hotel
			// http://localhost:8082/api/hotel/3f7682c8-7529-49ea-ba67-698bafc29ad2
			ResponseEntity<Hotel> forEntity = restTemplate
					.getForEntity("http://localhost:8082/api/hotel/" + rating.getHotelId(), Hotel.class);
			Hotel hotel = forEntity.getBody();
			logger.info("response status code:{}", forEntity.getStatusCode());
			// set the hotel to return
			rating.setHotel(hotel);

			// return the rating
			return rating;

		}).collect(Collectors.toList());

		// user.setRatings(ratingOfUser);
		user.setRatings(collectionList);
		return user;
	}

}
