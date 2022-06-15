package model;
import java.io.Serializable;
public class Mypage implements Serializable{
//宣言
	private String id;
	private String user_id;
	private String date;
	private String day_weight;
	private String bmi;

//コンストラクタ
	public Mypage(String id, String user_id, String date, String day_weight, String bmi) {
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
		this.day_weight ="";
	}
//ゲッターとセッター
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public String getDay_eight() {
		return day_weight;
	}
	public void setDay_weight(String day_weight) {
		this.day_weight = day_weight;
	}
	public String getBmi() {
		return bmi;
	}
	public void setBmi(String bmi) {
		this.bmi = bmi;
	}
}
