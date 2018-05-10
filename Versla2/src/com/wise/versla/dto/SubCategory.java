package com.wise.versla.dto;

public class SubCategory {
private int id;
private String name;
private String image;
private int delete;
private Moderator moderator;
private Category category;

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
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public Moderator getModerator() {
	return moderator;
}
public void setModerator(Moderator moderator) {
	this.moderator = moderator;
}
public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category = category;
}
public int getDelete() {
	return delete;
}
public void setDelete(int delete) {
	this.delete = delete;
}
@Override
public String toString() {
	return "SubCategory [id=" + id + ", name=" + name + ", image=" + image + ", moderator=" + moderator + ", category="
			+ category + ", delete=" + delete + "]";
}
}
