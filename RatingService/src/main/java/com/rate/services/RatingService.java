package com.rate.services;

import java.util.List;

import com.rate.entities.Rating;

public interface RatingService {
	
	Rating createRating(Rating rating);
	
	List<Rating> getAllRatings();
	
	List<Rating> getRatingByUserId(String userId);
	
	List<Rating> getRatingByHotelId(String hotelId);

}
