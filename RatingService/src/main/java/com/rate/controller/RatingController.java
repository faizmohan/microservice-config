package com.rate.controller;

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

import com.rate.entities.Rating;
import com.rate.services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	
	@PostMapping("/")
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
		Rating saveRating = ratingService.createRating(rating);
		return new ResponseEntity<>(saveRating, HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Rating>> getAllRatings(){
		return ResponseEntity.ok(this.ratingService.getAllRatings());
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){

		return ResponseEntity.ok(this.ratingService.getRatingByUserId(userId));
	}
	
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){

		return ResponseEntity.ok(this.ratingService.getRatingByHotelId(hotelId));
	}

}
