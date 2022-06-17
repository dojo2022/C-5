package model;
import java.io.Serializable;
public class ShortTrans implements Serializable{


	private int id;
	private String user_id;
	private int date;
	private int counter;
	private String type;
	private int no;
	private int short_complete;

	public ShortTrans(int id, String user_id, int date, int counter, String type, int no, int short_complete) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.date = date;
		this.counter = counter;
		this.type = type;
		this.no = no;
		this.short_complete = short_complete;
	}

	public ShortTrans() {
		super();
		this.id = 0;
		this.user_id = "";
		this.date = 0;
		this.counter =0;
		this.type = "";
		this.no = 0;
		this.short_complete = 0;
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

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
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

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getShort_complete() {
		return short_complete;
	}

	public void setShort_complete(int short_complete) {
		this.short_complete = short_complete;
	}



}
