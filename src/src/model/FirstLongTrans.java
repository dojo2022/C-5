package model;

import java.io.Serializable;
import java.util.Date;

public class FirstLongTrans implements Serializable{
private int id;
private String user_id;
private int counter;
private String type;
private int long_complete;
private int goal_count;
private int nogoal_count;
private Date date;

public FirstLongTrans(int id, String user_id, int counter, String type, int long_complete, int goal_count,
		int nogoal_count, Date date) {
	super();
	this.id = id;
	this.user_id = user_id;
	this.counter = counter;
	this.type = type;
	this.long_complete = long_complete;
	this.goal_count = goal_count;
	this.nogoal_count = nogoal_count;
	this.date = date;
}


public FirstLongTrans() {
	super();
	this.id = 0;
	this.user_id = "";
	this.counter = 0;
	this.type = "";
	this.long_complete = 0;
	this.goal_count = 0;
	this.nogoal_count = 0;
	this.date = null;
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
public int getCounter() {
	return counter;
}
public void setCounter(int counter) {
	this.counter = counter;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public int getLong_complete() {
	return long_complete;
}
public void setLong_complete(int long_complete) {
	this.long_complete = long_complete;
}
public int getGoal_count() {
	return goal_count;
}
public void setGoal_count(int goal_count) {
	this.goal_count = goal_count;
}
public int getNogoal_count() {
	return nogoal_count;
}
public void setNogoal_count(int nogoal_count) {
	this.nogoal_count = nogoal_count;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}

}
