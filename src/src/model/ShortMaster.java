package model;
import java.io.Serializable;
public class ShortMaster implements Serializable{

	private int id;
	private String type;
	private int no;
	private String short_goal;
	private String user_id;
	private int long_goal;

	public ShortMaster(int id, String type, int no, String short_goal) {
		super();
		this.id = id;
		this.type = type;
		this.no = no;
		this.short_goal = short_goal;
	}

	public ShortMaster(int id, String type,String short_goal, String user_id, int no) {
		super();
		this.id = id;
		this.type = type;
		this.short_goal = short_goal;
		this.user_id = user_id;
		this.no = no;
	}

	public ShortMaster(String user_id, int long_goal) {
		super();
		this.long_goal = long_goal;
	}

	public ShortMaster() {
		super();
		this.id = 0;
		this.type = "";
		this.no = 0;
		this.short_goal = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getShort_goal() {
		return short_goal;
	}

	public void setShort_goal(String short_goal) {
		this.short_goal = short_goal;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getLong_goal() {
		return long_goal;
	}

	public void setLong_goal(int long_goal) {
		this.long_goal = long_goal;
	}




}
