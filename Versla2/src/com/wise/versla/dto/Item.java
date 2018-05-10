package com.wise.versla.dto;

import java.util.Date;
//import java.util.List;

public class Item {
private int id;
private String description;
private int oldMonths;
private int price;
private String sold;
private String image;
private int maxPrice;
private int minPrice;
private String locality;
private String city;
private String area;
private Date date;
private String state;
private String country;
private Moderator moderator;
private SubCategory subCategory;
private User user;

public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getOldMonths() {
	return oldMonths;
}
public void setOldMonths(int oldMonths) {
	this.oldMonths = oldMonths;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getSold() {
	return sold;
}
public void setSold(String sold) {
	this.sold = sold;
}
public Moderator getModerator() {
	return moderator;
}
public void setModerator(Moderator moderator) {
	this.moderator = moderator;
}
public SubCategory getSubCategory() {
	return subCategory;
}
public void setSubCategory(SubCategory subCategory) {
	this.subCategory = subCategory;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public int getMaxPrice() {
	return maxPrice;
}
public void setMaxPrice(int maxPrice) {
	this.maxPrice = maxPrice;
}
public int getMinPrice() {
	return minPrice;
}
public void setMinPrice(int minPrice) {
	this.minPrice = minPrice;
}
public String getLocality() {
	return locality;
}
public void setLocality(String locality) {
	this.locality = locality;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getArea() {
	return area;
}
public void setArea(String area) {
	this.area = area;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
@Override
public String toString() {
	return "Item [id=" + id + ", description=" + description + ", oldMonths=" + oldMonths + ", price=" + price
			+ ", sold=" + sold + ", image=" + image + ", moderator=" + moderator + ", subCategory=" + subCategory
			+ ", user=" + user + ", maxPrice=" + maxPrice + ", minPrice=" + minPrice + ", locality=" + locality
			+ ", city=" + city + ", area=" + area + ", date=" + date + "]";
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}

}
