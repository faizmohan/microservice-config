package com.faiz.user.service.entities;

public class Hotel {

	private String hotelId;
	private String name;
	private String location;
	
	public Hotel() {
		super();
		
	}
	public Hotel(String hotelId, String name, String location) {
		super();
		this.hotelId = hotelId;
		this.name = name;
		this.location = location;
	}
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", name=" + name + ", location=" + location + "]";
	}
	
}
