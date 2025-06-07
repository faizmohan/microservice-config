package com.faiz.user.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.faiz.user.service.entities.Rating;
import com.faiz.user.service.services.RateService;

@SpringBootTest
class ConnectionPooling1ApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private RateService rateService;
	
	@Test
	void createRating() {
		Rating rating = new Rating();
		rating.setUserId("");
		rating.setRating(6);
		rating.setFeedback("very good");
		rating.setHotelId("");
		
		Rating saveRating = rateService.createRating(rating);
		System.out.println("New rating created. " +saveRating);
	}

}
