package com.redlabel.rating.repository;

import java.util.List;

import com.redlabel.rating.entities.Rating;

import org.springframework.data.jpa.repository.JpaRepository;
//if mango db then use MongoRepository

public interface RatingRepository extends JpaRepository<Rating, String> {

	//custom finder method
	List<Rating> findByUserId(String userId);
	List<Rating> findByHotelId(String hotelId);
}
