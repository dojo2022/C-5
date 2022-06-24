package model;

public class BodyImage {
private int id;
private String body_id;
private String body_image;
public BodyImage(int id, String body_id, String body_image) {
	super();
	this.id = id;
	this.body_id = body_id;
	this.body_image = body_image;
}
public BodyImage() {
	super();
	this.id = 0;
	this.body_id = "";
	this.body_image = "";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getBody_id() {
	return body_id;
}
public void setBody_id(String body_id) {
	this.body_id = body_id;
}
public String getBody_image() {
	return body_image;
}
public void setBody_image(String body_image) {
	this.body_image = body_image;
}


}
