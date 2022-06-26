package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Result;

public class ResultDAO {
	public Result evaluate(String user_id) {

		Connection conn = null;

		Result goalSet = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");

			// SQL文を準備する
			String sql = "SELECT date, user_id, goal_count, nogoal_count, long_complete FROM FIRSTLONGTRANS WHERE  user_id = ? ORDER BY date desc LIMIT 1";

			// SQLインジェクション防ぐ
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1,user_id);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			if(rs.next()) {
				goalSet = new Result();
				goalSet.setDate(rs.getDate("date"));
				goalSet.setUser_id(rs.getString("user_id"));
				goalSet.setGoal_count(rs.getInt("goal_count"));
				goalSet.setNogoal_count(rs.getInt("nogoal_count"));
				goalSet.setLong_complete(rs.getInt("long_complete"));
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
			goalSet = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			goalSet = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					goalSet = null;
				}
			}
		}

		// 結果を返す
		return goalSet;

	}
}
