package model;
import java.io.Serializable;
import java.util.Date;
public class Mypage implements Serializable{
//宣言
	private int id;
	private String user_id;
	private Date date;
	private double day_weight;
	private double bmi;

//コンストラクタ
	public Mypage(int id, String user_id, Date date, double day_weight, double bmi) {
		super();
		this.id = id;

		this.date = date;
		this.day_weight = day_weight;
		this.bmi = bmi;
	}
	public Mypage(String user_id ,Date date, double day_weight) {
		super();
		this.id=0;
		this.user_id=user_id;
		this.date = date;
		this.day_weight = day_weight;
		this.bmi =0;
	}

//デフォルトコンストラクタ
	public Mypage(){
		super();
		this.user_id = "";
		this.date = null;
		this.day_weight =0;
	}
//ゲッターとセッター
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getDay_weight() {
		return day_weight;
	}
	public void setDay_weight(double day_weight) {
		this.day_weight = day_weight;
	}
	public double getBmi() {
		//return bmi;
		return Math.floor(bmi * 100) /100;
	}
	public void setBmi(double bmi) {
		this.bmi = bmi;
	}
}
