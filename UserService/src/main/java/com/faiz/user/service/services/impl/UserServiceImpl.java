package com.faiz.user.service.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.faiz.user.service.entities.Hotel;
import com.faiz.user.service.entities.Rating;
import com.faiz.user.service.entities.User;
import com.faiz.user.service.exceptions.ResourceNotFoundException;
import com.faiz.user.service.repositories.UserRepository;
import com.faiz.user.service.services.HotelService;
import com.faiz.user.service.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {
		
		String userId = UUID.randomUUID().toString();
		user.setUserId(userId);
		
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		
		 List<User> users = userRepository.findAll();
		 for(User user : users) {
			 Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
			 logger.info(" {} ",ratingsOfUser);
			 List<Rating> allRatings = Arrays.stream(ratingsOfUser).collect(Collectors.toList());
			 for(Rating rate : allRatings) {
//				 Hotel hotel = restTemplate.getForObject("http://HOTEL-SERVICE/hotels/"+rate.getHotelId(), Hotel.class);
				 Hotel hotel = hotelService.getHotel(rate.getHotelId());
				 rate.setHotel(hotel);
			 }
			 user.setRatings(allRatings);
		 }
		 return users;
	}

	@Override
	public User getUser(String userId) {
		
		 User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given "
				+ "userId not found. " + userId));
//		 http://localhost:8082/ratings/users/164486f0-0166-423c-bbf0-cd8742c93489
		 Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
		 List<Rating> allRatings = Arrays.stream(ratingsOfUser).collect(Collectors.toList());
		 logger.info(" {} ",ratingsOfUser);
		 for(Rating rate : allRatings) {
//			 Hotel hotel = restTemplate.getForObject("http://HOTEL-SERVICE/hotels/"+rate.getHotelId(), Hotel.class);
			 Hotel hotel = hotelService.getHotel(rate.getHotelId());
			 rate.setHotel(hotel);
		 }
		 user.setRatings(allRatings);
		 return user;
	}

}
