package com.redlabel.user.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.redlabel.user.service.entities.Rating;
import com.redlabel.user.service.external.services.RatingService;

@SpringBootTest
class UserServicesApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private RatingService ratingService;

	// @Test
	// void createRating() {
	// 	Rating rating = Rating.builder().rating(6).userId("").hotelId("").feedback("this is created using feign client")
	// 			.build();
	// 	Rating savedRating = ratingService.createRating(rating);
	// 	System.out.println("New Rating is created");

	// }

}
