package com.wise.versla.dto;

public class Moderator {
private int id;
private String name;
private String password;
private String emailId;
private long phone;

public int getId(){
	return id;
}
public void setId(int id){
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}
@Override
public String toString() {
	return "Moderator [id=" + id + ", name=" + name + ", password=" + password + ", emailId=" + emailId
			+ ", phone=" + phone + "]";
}
}
