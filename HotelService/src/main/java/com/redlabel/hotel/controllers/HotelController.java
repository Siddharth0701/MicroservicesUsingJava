package com.redlabel.hotel.controllers;

import java.util.List;

import com.redlabel.hotel.entities.Hotel;
import com.redlabel.hotel.service.HotelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/hotel")
public class HotelController {
	@Autowired
	private HotelService hotelService;

	// create
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));

	}

	// getAllHotel

	// getSingleHotel
	@GetMapping("{id}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable String id) {
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.get(id));

	}

	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotel() {
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAllHotel());

	}

}
