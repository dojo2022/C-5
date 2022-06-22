package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.FirstLongMaster;


//書き足し
public class FirstLongMasterDAO{

	// 引数paramで検索項目を指定し、検索結果のリストを返す

	public List<FirstLongMaster> first_display() {
//		FirstLongMaster型のList型のメソッド
//		ここ
		Connection conn = null;
//		変数の箱だけ作ってnullにする
		List<FirstLongMaster> questionList = new ArrayList<FirstLongMaster>();
		//		FirstLongMaster型のArrayList questionListを生成
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");

			// SQL文を準備する　改造
			String sql = "select * from FirstLongMaster";
//			変数sqlにSELECT文を格納
			PreparedStatement pStmt = conn.prepareStatement(sql);
//			ここ
//			PreparedStatementのインスタンスを生成

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			//RESULTSETクラスのインスタンスとして得られる


			while (rs.next()) {
//				値が得られる（trueである）限り
				FirstLongMaster question = new FirstLongMaster(
						rs.getInt("id"),
						rs.getString("type"),
						rs.getString("first_test"),
						rs.getString("long_goal")
						//jspのNAMEとそろえる
						);
				questionList.add(question);
			}
		}




		catch (SQLException e) {
			e.printStackTrace();
			questionList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			questionList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					questionList = null;
				}
			}
		}

		// 結果を返す
		return questionList;
	}

//	チェックされた項目の長期目標を表示

	public List<String> long_display(String user_id) {
//		FirstLongMaster型のList型のメソッド
//		ここ
		Connection conn = null;
//		変数の箱だけ作ってnullにする
		List<String> longList = new ArrayList<String>();
		//		FirstLongMaster型のArrayList longListを生成
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");

			// SQL文を準備する　改造
			String sql = "SELECT FIRSTLONGMASTER.id, user_id, FIRSTLONGTRANS.type, long_goal FROM FIRSTLONGTRANS inner join FIRSTLONGMASTER\r\n"
					+ "on FIRSTLONGTRANS.type = FIRSTLONGMASTER .type\r\n"
					+ "where user_id = ?";

//			変数sqlにSELECT文を格納
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を完成させる
				pStmt.setString(1, user_id);
//			値が絶対入るように 条件分岐はしない

//			PreparedStatementのインスタンスを生成

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			//RESULTSETクラスのインスタンスとして得られる


			while (rs.next()) {
//				値が得られる（trueである）限り
//				String user_id = (String)session.getAttribute("user_id"); (LCServletより引用)
				String id =(String)rs.getString("id");
				rs.getString("user_id");
				String type = (String)rs.getString("type");
				String long_goal = (String)rs.getString("long_goal");
				//jspのNAMEとそろえる
				longList.add(id);
				longList.add(user_id);
				longList.add(type);
				longList.add(long_goal);
			}
		}


		catch (SQLException e) {
			e.printStackTrace();
			longList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			longList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					longList = null;
				}
			}
		}

		// 結果を返す
		return longList;
	}


}