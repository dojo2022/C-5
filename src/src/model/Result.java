package model;

import java.io.Serializable;
import java.util.Date;

public class Result implements Serializable {
	private String title;		// タイトル
	private String message;	// メッセージ
	private String backTo;		// 戻り先

//	（↓5つ兼平）
	private Date date;
	private String user_id;
	private int goal_count;
	private int nogoal_count;
	private int long_complete;

	public Result() {
		this(null, null, null);
	}

	public Result(String title, String message, String backTo) {
		this.title = title;
		this.message = message;
		this.backTo = backTo;
	}


	public Result(Date date, String user_id, int goal_count, int nogoal_count, int long_complete) {
		super();
		this.date = date;
		this.user_id = user_id;
		this.goal_count = goal_count;
		this.nogoal_count = nogoal_count;
		this.long_complete = long_complete;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getBackTo() {
		return backTo;
	}

	public void setBackTo(String backTo) {
		this.backTo = backTo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
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

	public int getLong_complete() {
		return long_complete;
	}

	public void setLong_complete(int long_complete) {
		this.long_complete = long_complete;
	}

}
