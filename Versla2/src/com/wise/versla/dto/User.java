package com.wise.versla.dto;

import java.util.Date;

//import java.util.Date;

public class User {
 private int userId;
 private String userName;
 private long phone;
 private String emailId;
 private String password;
 private int unsubscribe;
 private Date dateOfBirth;

public Date getDateOfBirth() {
	return dateOfBirth;
}
public void setDateOfBirth(Date dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getUnsubscribe() {
	return unsubscribe;
}
public void setUnsubscribe(int unsubscribe) {
	this.unsubscribe = unsubscribe;
}
 
@Override
public String toString() {
	return "User [userId=" + userId + ", userName=" + userName + ", phone=" + phone + ", emailId=" + emailId
			+ ", password=" + password + ", unsubscribe=" + unsubscribe + "]";
}
 
}
