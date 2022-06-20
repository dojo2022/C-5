package model;

import java.io.Serializable;

public class Users implements Serializable{
private int id;
private String user_id;
private String password;
private String user_name;
private double height;
private double weight;
private int bmi_id;
private int color_id;

public Users(int id, String user_id, String password, String user_name, double height, double weight, int bmi_id,
		int color_id) {
	super();
	this.id = id;
	this.user_id = user_id;
	this.password = password;
	this.user_name = user_name;
	this.height = height;
	this.weight = weight;
	this.bmi_id = bmi_id;
	this.color_id = color_id;
}

public Users(String user_id, String password) {
	super();
	this.user_id = user_id;
	this.password = password;
}

public Users(String user_id) {
	super();
	this.user_id = user_id;
}

public Users() {
	super();
	this.id = 0;
	this.user_id = "";
	this.password = "";
	this.user_name = "";
	this.height = 0;
	this.weight = 0;
	this.bmi_id = 0;
	this.color_id = 0;
}



public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getUser_id() {
	return user_id;
}

public void setUser_id(String user_id) {
	this.user_id = user_id;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getUser_name() {
	return user_name;
}

public void setUser_name(String user_name) {
	this.user_name = user_name;
}

public double getHeight() {
	return height;
}

public void setHeight(double height) {
	this.height = height;
}

public double getWeight() {
	return weight;
}

public void setWeight(double weight) {
	this.weight = weight;
}

public int getBmi_id() {
	return bmi_id;
}

public void setBmi_id(int bmi_id) {
	this.bmi_id = bmi_id;
}

public int getColor_id() {
	return color_id;
}

public void setColor_id(int color_id) {
	this.color_id = color_id;
}


}
