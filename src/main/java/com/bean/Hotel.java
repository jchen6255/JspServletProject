package com.bean;

import java.sql.Date;

public class Hotel {

	private int hotelNum;
	private String name;
	private String city;
	private String location;
	private String rating;
	private double price;
	private Date checkin;
	private Date checkout;
	
	
	public Hotel(int hotelNum, String name, String city, String location, String rating, double price, Date checkin, Date checkout) {
		this.hotelNum =hotelNum;
		this.name = name;
		this.city = city;
		this.location = location;
		this.rating = rating;
		this.checkin = checkin;
		this.checkout = checkout;
		this.price = price;
	
	}
	
	
	public int getHotelNum() {
		return hotelNum;
	}
	public void setHotalNum(int hotelNum) {
		this.hotelNum = hotelNum;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getCheckin() {
		return checkin;
	}
	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}
	public Date getCheckout() {
		return checkout;
	}
	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}
	
	
	
}
