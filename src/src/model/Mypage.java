package model;
import java.io.Serializable;
public class Mypage implements Serializable{
//宣言
	private int id;
	private String user_id;
	private String date;
	private double day_weight;
	private double bmi;

//コンストラクタ
	public Mypage(int id, String user_id, String date, double day_weight, double bmi) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.date = date;
		this.day_weight = day_weight;
		this.bmi = bmi;
	}
//デフォルトコンストラクタ
	public Mypage(){
		super();
		this.user_id = "";
		this.date = "";
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getDay_eight() {
		return day_weight;
	}
	public void setDay_weight(double day_weight) {
		this.day_weight = day_weight;
	}
	public double getBmi() {
		return bmi;
	}
	public void setBmi(double bmi) {
		this.bmi = bmi;
	}
}
