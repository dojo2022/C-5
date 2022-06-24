package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ShortMaster;

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

//安部
//マイページServletのdoGetで体アバターを表示する
public Double newbmi() {
	Connection conn = null;
	Double newbmi =0.0;

		// JDBCドライバを読み込む
	try {
		Class.forName("org.h2.Driver");
		// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");

				String sql="SELECT bmi FROM Mypage ORDER BY date DESC LIMIT 1";
				PreparedStatement pStmt1 = conn.prepareStatement(sql);

				// SELECT文を実行し、結果表を取得する
				ResultSet rs = pStmt1.executeQuery();

				if(rs.next()) {
					//データがあればココに入る。
					 newbmi=Double.parseDouble(sql) ;
				}
				else {
					//データがなければココに入る。
				}
	}

				catch (SQLException e) {
					e.printStackTrace();
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
	}
				finally {}

		return newbmi;

}

public Double oldbmi() {
	Connection conn = null;
	Double oldbmi =0.0;

		// JDBCドライバを読み込む
	try {
		Class.forName("org.h2.Driver");
		// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");

				String sql="SELECT bmi FROM Mypage ORDER BY date DESC LIMIT 1";
				PreparedStatement pStmt1 = conn.prepareStatement(sql);

				// SELECT文を実行し、結果表を取得する
				ResultSet rs = pStmt1.executeQuery();

				if(rs.next()) {
					//データがあればココに入る。
					 oldbmi=Double.parseDouble(sql) ;
				}
				else {
					//データがなければココに入る。
				}
	}

				catch (SQLException e) {
					e.printStackTrace();
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
	}
				finally {}

		return oldbmi;

}

public boolean bmi_update(int bmi ,String user_id) {
	Connection conn = null;
	boolean result = false;

	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");

		// SQL文を準備する
		String sql = "UPDATE Users SET  bmi_id = ? WHERE user_id = ?";
		PreparedStatement pStmt = conn.prepareStatement(sql);

		// SQL文を完成させる
		pStmt.setInt(1, bmi);
		pStmt.setString(2, user_id);

		if (pStmt.executeUpdate() == 1) {
			result = true;
		}

	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
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

//（安部）
//------------------------------------------------------------------------------------------------------------------

public ShortMaster mp_st_display(String user_id){
	//	shortmaster型なのでshortmasterのBeanについか

	Connection conn = null;
	//	DBとのコネクションのためのオブジェクトconnを用意
	ShortMaster mp_short = null;
	//	最後に値をセットするshortListを用意 適宜値を追加できるようにArrayListに
	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");


		//	SQL文を準備する
		//	今回は選択された長期に対応する短期目標をすべて
		//	取り出す項目はtype, user_id, 短期目標のid, 短期目標
		String sql = "SELECT user_id, long_goal FROM FirstLongMaster INNER JOIN FirstLongTrans ON  FirstLongMaster.type =  FirstLongTrans.type where user_id = '?' and long_complete = 1;";

		//	PreparedStatementのインスタンスを生成
		PreparedStatement pStmt = conn.prepareStatement(sql);

//		SQL文を完成させる
//		user_idをWHERE句にセット
		pStmt.setString(1, user_id);

		// SQL文を実行し、結果表を取得する
		// RESULTSETクラスのインスタンスとして得られる
		ResultSet rs = pStmt.executeQuery();

		//	必要な値：long_goal
		if(rs.next()) {
			mp_short =new ShortMaster(
					rs.getString("user_id"),
					rs.getInt("long_goal")
					);
		}

	}

	catch (SQLException e) {
		e.printStackTrace();
		mp_short = null;
	}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
		mp_short = null;
	}
	finally {
		// データベースを切断
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
				mp_short = null;
			}
		}
	}
	return mp_short;
}
}












