package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import model.Mypage;
import model.FirstLongMaster;
public class MypageDAO {
	public List<Long> LongTarget(FirstLongmaster) {
		Connection conn = null;

			// JDBCドライバを読み込む
		try {
			Class.forName("org.h2.Driver");
			// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");
					String sqlLong="SELECT  long_goal FROM FirstLongMaster \r\n"
							+ "INNER JOIN FirstLongTrans\r\n"
							+ "ON  FirstLongMaster.type =  FirstLongTrans.type\r\n"
							+ "where user_id = '?' and long_complete = 1;";


					PreparedStatement pStmtLong = conn.prepareStatement(sqlLong);
					// SQL文を完成させる　改造
					if (.getLong_goal() != null) {
						pStmt.setString(1, "%" + .getLong_goal() + "%");
					}
					//paramのゲット番号が空白でなけりゃ1-クエスチョンの番号
					else {
						pStmt.setString(1, "%");

					Resultset rsLong =pStmtLong.executeQuery();

		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}

			}
		// 結果を返す
		return result;
	}


	public boolean insert(){
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");
			String sql =

		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}

			}
		// 結果を返す
		return result;
	}


	public boolean update(Bc param, String order){
		boolean result = false;
		Connection conn = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");
			String sqlUpS1 ="UPDATE ShortTrans SET short_complete = 1 WHERE exe_date ='?'";

		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}

			}
		// 結果を返す
		return result;
	}


}
