package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Users;

public class AvaterDAO
{

	public Users select_bodyids(String user_id) {
		Connection conn = null;
		//List<FirstLongTrans> stampcard1 = null;
		Users ids = null;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");

			// SQL文を準備する
			String sql = "SELECT bmi_id,color_id FROM Users WHERE user_id=?";

			// SQLインジェクション防ぐ
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1,user_id);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			if (rs.next()) {
				//FirstLongTrans scdata = new FirstLongTrans();
				ids = new Users();
				ids.setBmi_id(rs.getInt("bmi_id"));
				ids.setColor_id(rs.getInt("color_id"));


			}

		}
		catch (SQLException e) {
			e.printStackTrace();
			ids = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			ids = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					ids = null;
				}
			}
		}
		// 結果を返す
		return ids;
	}

	//---------------------------------------------------------------------------------------------------------

	public int color_select(String user_id)
	{
		Connection conn = null;
		int nogoal_number = 0;
		try {
			//			JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			//			データベース接続
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");

			//			SQL文を準備する
			//			insertする項目だけを記述する。
			String sql = "SELECT COUNT(*) FROM FirstLongTrans WHERE long_complete in ( 0, 1 ) and user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//			SQL文を完成させる
			pStmt.setString(1, user_id);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			// FirstLongTransでjavabeansのコンストラクタを全部順番通り呼ぶ
			if(rs.next()) {
				nogoal_number = rs.getInt("count(*)");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			nogoal_number = -1;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			nogoal_number = -1;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					nogoal_number = -1;
				}
			}
		}

		// 結果を返す
		return nogoal_number;
	}


	public boolean color_update(int color ,String user_id) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");

			// SQL文を準備する
			String sql = "UPDATE Users SET  color_id = ? WHERE user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, color);
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

	public boolean long_complete2(int color ,String user_id) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");

			// SQL文を準備する
			String sql = "UPDATE FirstLongTrans SET  long_complete = 2 WHERE user_id = ? AND long_complete = 1";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, user_id);

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

	public boolean long_complete0(int color ,String user_id) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");

			// SQL文を準備する
			String sql = "UPDATE FirstLongTrans SET  long_complete = 0,goal_count = 0, nogoal_count = 0 "
					+ "WHERE user_id = ? AND long_complete = 1";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, user_id);

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
}


