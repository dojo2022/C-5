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
		Connection conn = null;
		List<FirstLongMaster> questionList = new ArrayList<FirstLongMaster>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");

			// SQL文を準備する　改造
			String sql = "select * from FirstLongMaster";
			PreparedStatement pStmt = conn.prepareStatement(sql);


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			//RESULTSETクラスのインスタンスとして得られる


			while (rs.next()) {
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
}