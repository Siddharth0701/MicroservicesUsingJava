package com.redlabel.rating.service;

import java.util.List;

import com.redlabel.rating.entities.Rating;

public interface RatingService {
	
	//create
	Rating create(Rating rating);
	// find By Id 
	List<Rating>getRatingById(String userId);
		//findAll
	List<Rating> getAllrating();

	//get all by hotel
	List<Rating>getRatingByHotelId(String hotelId);

}
