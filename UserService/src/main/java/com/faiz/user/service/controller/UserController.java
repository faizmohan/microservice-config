package com.faiz.user.service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.faiz.user.service.entities.User;
import com.faiz.user.service.services.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	int retryCount = 1;
	
	@PostMapping("/")
	public ResponseEntity<User> createUser(@RequestBody User user){
		User saveUser = userService.saveUser(user);
		return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.ok(this.userService.getAllUser());
	}
	
	@GetMapping("/{userId}")
//	@CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
//	@Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallback")
	@RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId){
		logger.info("Retry : "+retryCount);
		retryCount++;
		return ResponseEntity.ok(this.userService.getUser(userId));
	}
	
	public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex){
		logger.info("Fallback method is executed",ex.getMessage());
		User user = new User();
		user.setEmail("abc@gmail.com");
		user.setName("abc");
		user.setUserId("0000");
		return new ResponseEntity<User>(user,HttpStatus.OK);
		
	}

}
