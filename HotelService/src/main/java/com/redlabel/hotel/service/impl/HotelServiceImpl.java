package com.redlabel.hotel.service.impl;

import java.util.List;
import java.util.UUID;

import com.redlabel.hotel.entities.Hotel;
import com.redlabel.hotel.exception.ResourceNotFoundException;
import com.redlabel.hotel.repository.HotelRepository;
import com.redlabel.hotel.service.HotelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl implements HotelService {
	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel create(Hotel hotel) {
		String hotelId = UUID.randomUUID().toString();
	  hotel.setId(hotelId);	
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotel() {
		// TODO Auto-generated method stub
		return hotelRepository.findAll();
	}

	@Override
	public Hotel get(String id) {
		// TODO Auto-generated method stub
		 return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("hotel with given id not found !!"));
	}

}
