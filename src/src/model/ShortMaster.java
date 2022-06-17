package model;
import java.io.Serializable;
public class ShortMaster implements Serializable{

	private int id;
	private int type;
	private int no;
	private String short_goal;

	public ShortMaster(int id, int type, int no, String short_goal) {
		super();
		this.id = id;
		this.type = type;
		this.no = no;
		this.short_goal = short_goal;
	}

	public ShortMaster() {
		super();
		this.id = 0;
		this.type = 0;
		this.no = 0;
		this.short_goal = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
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



}
