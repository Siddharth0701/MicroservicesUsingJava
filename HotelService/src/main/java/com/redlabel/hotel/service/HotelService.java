package com.redlabel.hotel.service;

import java.util.List;

import com.redlabel.hotel.entities.Hotel;

public interface HotelService {
	//create
	Hotel create(Hotel hotel);
	
	//get all hotel
	List<Hotel> getAllHotel();
	
	//get Single Hotel
	Hotel get(String id);
	

}
