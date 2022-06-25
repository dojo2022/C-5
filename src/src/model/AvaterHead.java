package model;
import java.util.Date;
public class AvaterHead {
	private int id;
	private String user_id;
	private String face_id;
	private Date image_date;
	private String face_image;

	public AvaterHead(int id, String user_id, String face_id, Date image_date, String face_image) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.face_id = face_id;
		this.image_date = image_date;
		this.face_image = face_image;
	}
	public AvaterHead() {
		super();
		this.id = 0;
		this.user_id = "";
		this.face_id = "";
		this.image_date = null;
		this.face_image ="";
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
	public String getFace_id() {
		return face_id;
	}
	public void setFace_id(String face_id) {
		this.face_id = face_id;
	}
	public Date getUp_date() {
		return image_date;
	}
	public void setImage_date(Date image_date) {
		this.image_date = image_date;
	}
	public String getFace_image() {
		return face_image;
	}
	public void setFace_image(String face_image) {
		this.face_image = face_image;
	}


}
