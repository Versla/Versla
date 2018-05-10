package com.wise.versla.dto;

public class Category {
private int id;
private String name;
private String logo;
private int delete;
private Moderator moderator;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLogo() {
	return logo;
}
public void setLogo(String logo) {
	this.logo = logo;
}
public Moderator getModerator() {
	return moderator;
}
public void setModerator(Moderator moderator) {
	this.moderator = moderator;
}
public int getDelete() {
	return delete;
}
public void setDelete(int delete) {
	this.delete = delete;
}
@Override
public String toString() {
	return "Category [id=" + id + ", name=" + name + ", logo=" + logo + ", moderator=" + moderator + ", delete="
			+ delete + "]";
}
}
