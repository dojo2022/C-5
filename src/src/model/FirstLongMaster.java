package model;
import java.io.Serializable;
public class FirstLongMaster implements Serializable{
	private int id;
	private String type;
	private String first_test;
	private String long_goal;


	public FirstLongMaster(int id, String type, String first_test, String long_goal) {
		super();
		this.id = id;
		this.type = type;
		this.first_test = first_test;
		this.long_goal = long_goal;

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
	public String getFirst_test() {
		return first_test;
	}
	public void setFirst_test(String first_test) {
		this.first_test = first_test;
	}
	public String getLong_goal() {
		return long_goal;
	}
	public void setLong_goal(String long_goal) {
		this.long_goal = long_goal;
	}

}