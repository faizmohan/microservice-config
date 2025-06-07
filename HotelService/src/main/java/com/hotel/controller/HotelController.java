package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.entities.Hotel;
import com.hotel.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		Hotel saveHotel = hotelService.saveHotel(hotel);
		return new ResponseEntity<>(saveHotel, HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Hotel>> getAllHotels(){
		return ResponseEntity.ok(this.hotelService.getAllHotel());
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getSingleUser(@PathVariable String hotelId){

		return ResponseEntity.ok(this.hotelService.getHotel(hotelId));
	}


}
