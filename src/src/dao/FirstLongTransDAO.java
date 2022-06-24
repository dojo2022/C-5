package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.FirstLongTrans;

public class FirstLongTransDAO {
	//初期チェックテストの結果をDBに格納
	//--------------------------------------------------------------------------------
	//first_check変数に格納されるデータ　→　servletが責任を持ってデータを集める。
	public boolean first_insert(String user_id, String type) {
		Connection conn = null;
		boolean result = false;
		try {
			//			JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			//			データベース接続
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");

			//			SQL文を準備する

			//insertする項目だけを記述する。
			String sql = "INSERT INTO FIRSTLONGTRANS (user_id, type, date) values (?,?,CURDATE())";

			//必要な項目（insertする文のみ）記述する。
			//			String sql = "INSERT INTO FIRSTLONGTRANS (id, user_id, counter, type, complete, date) "
			//					+ "values (NULL, ?, DEFAULT, ?,  DEFAULT, ?)"
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//			SQL文を完成させる



			if(user_id != null && !user_id.equals("")) {
				pStmt.setString(1, user_id);
			}
			else {
				pStmt.setString(1, null);
			}
			if(type!= null && !type.equals("")) {
				pStmt.setString(2, type);
			}
			else {
				pStmt.setString(2, null);
			}


			// SQL文を実行する 検索時はxecuteQuwryだったがここは違う
			if (pStmt.executeUpdate() == 1) {
				result = true;
				//戻り値のリザルトをTRUEにする
			}
		}
		//例外処理
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
		return result;

	}
	//----------------------------------------------------------------------------------
	public boolean long_update(String user_id, String type) {
		Connection conn = null;
		boolean result = false;
		try {
			//			JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			//			データベース接続
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");

			//			SQL文を準備する
			//			insertする項目だけを記述する。
			String sql = "UPDATE FirstLongTrans SET long_complete = 1 WHERE user_id = ? and type  = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//			SQL文を完成させる
			pStmt.setString(1, user_id);
			pStmt.setString(2, type);

			//			 SQL文を実行する 検索時はxecuteQuwryだったがここは違う
			if (pStmt.executeUpdate() == 1) {
				result = true;
				//戻り値のリザルトをTRUEにする
			}
		}
		//例外処理
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
		return result;
	}


	//スタンプカード：スタンプを押すためのデータ取得する
	//-------------------------------------------------------------------------------------
	// 引数paramでjavabeansから検索項目を指定し、検索結果のリストを返す
	//selectで検索する（SQLの命令と同じ）
	public FirstLongTrans select(String user_id) {
		Connection conn = null;
		//List<FirstLongTrans> stampcard1 = null;
		FirstLongTrans stampcard = null;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/health_management", "sa", "");

			// SQL文を準備する
			String sql = "SELECT user_id,counter,type,long_complete,goal_count,nogoal_count FROM FirstLongTrans WHERE user_id=? and long_complete=1";

			// SQLインジェクション防ぐ
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1,user_id);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			// FirstLongTransでjavabeansのコンストラクタを全部順番通り呼ぶ
			if (rs.next()) {
				//FirstLongTrans scdata = new FirstLongTrans();
				stampcard = new FirstLongTrans();
				stampcard.setUser_id(rs.getString("user_id"));
				stampcard.setCounter(rs.getInt("counter"));
				stampcard.setType(rs.getString("type"));
				stampcard.setLong_complete(rs.getInt("long_comlete"));
				stampcard.setGoal_count(rs.getInt("goal_count"));
				stampcard.setNogoal_count(rs.getInt("nogoal_count"));

				//stampcard.add(scdata);
			}

		}
		catch (SQLException e) {
			e.printStackTrace();
			stampcard = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			stampcard = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					stampcard = null;
				}
			}
		}

		// 結果を返す
		return stampcard;
	}

	//----------------------------------------------------------------------------------

	public boolean updateGoalCount(String user_id ,Date exe_date, String type) {
		boolean result = false;
		Connection conn = null;

		try {
			// JDBC ドライバを読み込む
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/health_management", "sa", "");

			// SQL文を準備する
			String sql1 = "UPDATE ShortTrans SET short_complete = 1 WHERE user_id = ? and exe_date =?";

			// SQLインジェクション防ぐ
			PreparedStatement pStmt = conn.prepareStatement(sql1);

			// SQL文を完成させる
			pStmt.setString(1,user_id);
			pStmt.setDate(2,exe_date);


			//String sql1 = "UPDATE ShortTrans SET short_complete = 1 WHERE user_id = ? and exe_date =?;"
			//準備して、用意して、実行。
			if (pStmt.executeUpdate() == 1) {
				result = true;
				//戻り値のリザルトをTRUEにする
			}
			// SQL文を準備する
			String sql2 = "UPDATE FirstLongTrans set goal_count = goal_count + 1 WHERE user_id = ? and type=?";
			// SQLインジェクション防ぐ
			PreparedStatement pStmt2 = conn.prepareStatement(sql2);
			// SQL文を完成させる
			pStmt2.setString(1,user_id);
			pStmt2.setString(2,type);
			// SQL文を実行する 検索時はxecuteQuwryだったがここは違う
			if (pStmt2.executeUpdate() == 1) {
				result = true;
				//戻り値のリザルトをTRUEにする
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			//オブジェクト型は変数が確保したメモリの領域にアドレスを保存　→nullを入れることができる
			//基本型は変数が確保したメモリの領域に値を保存 →基本型にはnullを入れることができない。
			//int,double,boolean,char・・・・
			result = false;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			result = false;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					result = false;
				}
			}
		}
		return result;
	}
	public boolean updateNoGoalCount(String user_id ,Date exe_date, String type) {
		boolean result = false;
		Connection conn = null;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");
			// SQL文を準備する
			String sql1 = "UPDATE ShortTrans SET short_complete = 2 WHERE user_id = ? and exe_date =?";
			// SQLインジェクション防ぐ
			PreparedStatement pStmt = conn.prepareStatement(sql1);
			// SQL文を完成させる
			pStmt.setString(1,user_id);
			pStmt.setDate(2,exe_date);
			// SQL文を実行する 検索時はxecuteQuwryだったがここは違う
			if (pStmt.executeUpdate() == 1) {
				result = true;
				//戻り値のリザルトをTRUEにする
			}
			// SQL文を準備する
			String sql2 = "UPDATE FirstLongTrans set nogoal_count = nogoal_count + 1 WHERE user_id = ? and type=?";
			// SQLインジェクション防ぐ
			PreparedStatement pStmt2 = conn.prepareStatement(sql2);
			// SQL文を完成させる
			pStmt2.setString(1,user_id);
			pStmt2.setString(2,type);
			// SQL文を実行する 検索時はxecuteQuwryだったがここは違う
			if (pStmt2.executeUpdate() == 1) {
				result = true;
				//戻り値のリザルトをTRUEにする
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			//オブジェクト型は変数が確保したメモリの領域にアドレスを保存　→nullを入れることができる
			//基本型は変数が確保したメモリの領域に値を保存 →基本型にはnullを入れることができない。
			//int,double,boolean,char・・・・
			result = false;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			result = false;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					result = false;
				}
			}
		}
		return result;
	}

}
