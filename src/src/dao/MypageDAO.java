package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class MypageDAO {
	public String LongTarget(String user_id) {
		Connection conn = null;
		String rs1 = "";

			// JDBCドライバを読み込む
		try {
			Class.forName("org.h2.Driver");
			// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");
					String sqlLong="SELECT  long_goal FROM FirstLongMaster "
							+ "INNER JOIN FirstLongTrans ON"
							+ "  FirstLongMaster.type ="
							+ "  FirstLongTrans.type where user_id ="
							+ " ? and long_complete = 1";
					PreparedStatement pStmt = conn.prepareStatement(sqlLong);
					// SELECT文を実行し、結果表を取得する
					ResultSet rsl = pStmt.executeQuery();

					if(rsl.next()) {
						//データがあればココに入る。
						 rs1= sqlLong;
					}
					//else {
						//データがなければココに入る。
					}
					catch (SQLException e) {
						e.printStackTrace();
						rs1 = null;
					}
					catch (ClassNotFoundException e) {
						e.printStackTrace();
						rs1 = null;
		}
					finally {}

			return rs1;
	}
	public String ShortTarget(String user_id,Date date) {
		Connection conn = null;
		String rs2 = "";
;
			// JDBCドライバを読み込む
		try {
			Class.forName("org.h2.Driver");
			// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");
					String sqlShort="SELECT  short_goal "
							+ "FROM ShortMaster INNER JOIN "
							+ "ShortTrans ON ShortMaster.no =  "
							+ "ShortTrans.no and ShortMaster.type =  ShortTrans.type "
							+ "where user_id = ? and exe_date = ?";

					PreparedStatement pStmt = conn.prepareStatement(sqlShort);
					// SELECT文を実行し、結果表を取得する
					ResultSet rss = pStmt.executeQuery();

					if(rss.next()) {
						//データがあればココに入る。
						 rs2= sqlShort;
					}
					//else {
						//データがなければココに入る。
					}
					catch (SQLException e) {
						e.printStackTrace();
						rs2 = null;
					}
					catch (ClassNotFoundException e) {
						e.printStackTrace();
						rs2 = null;
		}
					finally {}

			return rs2;
	}
}



	/*private static String getString(String string) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
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


}*/
