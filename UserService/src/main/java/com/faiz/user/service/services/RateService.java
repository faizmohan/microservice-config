package com.faiz.user.service.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.faiz.user.service.entities.Rating;

@Service
@FeignClient(name = "RATING-SERVICE")
public interface RateService {
	
	@PostMapping("/ratings/")
	Rating createRating(@RequestBody Rating rating);	
	
	@PutMapping("/ratings/{ratingId}")
	Rating updateRating(@PathVariable String ratingId, @RequestBody Rating rating);

	@DeleteMapping("/ratings/{ratingId}")
	Rating deleteRating(@PathVariable String ratingId);


}
