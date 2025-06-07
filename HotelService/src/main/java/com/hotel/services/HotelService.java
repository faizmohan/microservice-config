package com.hotel.services;

import java.util.List;

import com.hotel.entities.Hotel;

public interface HotelService {
	
	Hotel saveHotel(Hotel hotel);
	
	List<Hotel> getAllHotel();
	
	Hotel getHotel(String hotelId);

}
