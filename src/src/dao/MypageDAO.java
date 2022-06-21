package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MypageDAO {
	public String LongTarget(String user_id) {
		Connection conn = null;
		String rsl = "";

			// JDBCドライバを読み込む
		try {
			Class.forName("org.h2.Driver");
			// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");
					String sqlLong="SELECT  long_goal FROM FirstLongMaster \r\n"
							+ "INNER JOIN FirstLongTrans\r\n"
							+ "ON  FirstLongMaster.type =  FirstLongTrans.type\r\n"
							+ "where user_id = '?' and long_complete = 1;";

					PreparedStatement pStmt = conn.prepareStatement(sqlLong);
					// SELECT文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					if(rs.next()) {
						//データがあればココに入る。
						 rsl= sqlLong;
					}
					//else {
						//データがなければココに入る。
					}
					catch (SQLException e) {
						e.printStackTrace();
						rsl = null;
					}
					catch (ClassNotFoundException e) {
						e.printStackTrace();
						rsl = null;
		}
					finally {}

			return rsl;
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
