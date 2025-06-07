package com.rate.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rate.entities.Rating;
import com.rate.repositories.RatingRepo;
import com.rate.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	private RatingRepo ratingRepo;

	@Override
	public Rating createRating(Rating rating) {
		
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getAllRatings() {
		
		return ratingRepo.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		
		return ratingRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		
		return ratingRepo.findByHotelId(hotelId);
	}

}
