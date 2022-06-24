package model;
import java.io.Serializable;
import java.util.Date;
public class ShortTrans implements Serializable{


	private int id;
	private String user_id;
	private Date exe_date;
	private int counter;
	private String type;
	private int no;
	private int short_complete;

	public ShortTrans(int id, String user_id, Date exe_date, int counter, String type, int no, int short_complete) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.exe_date = exe_date;
		this.counter = counter;
		this.type = type;
		this.no = no;
		this.short_complete = short_complete;
	}

	public ShortTrans(int id, String user_id, Date exe_date, String type, int no) {
		super();
		this.user_id = user_id;
		this.type = type;
		this.no = no;
	}

	public ShortTrans(String user_id, Date exe_date) {
		super();
		this.user_id = user_id;
		this.exe_date = exe_date;
	}

	public ShortTrans() {
		super();
		this.id = 0;
		this.user_id = "";
		this.exe_date = null;
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

	public Date getExe_date() {
		return exe_date;
	}

	public void setExe_date(Date exe_date) {
		this.exe_date = exe_date;
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
