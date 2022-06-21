package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.FirstLongTrans;

public class FirstLongTransDAO {
	//初期チェックテストの結果をDBに格納

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
	/*finally {
		// データベースを切断
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}*/

		return result;
	}
//}
	//スタンプカード：スタンプを押すためのデータ取得する

		//BcDAO.javaからいったんコピペ。
		//cardがよくわからず変更していない

		 // 引数paramでjavabeansから検索項目を指定し、検索結果のリストを返す
			//selectで検索する（SQLの命令と同じ）
			public List<FirstLongTrans> select(FirstLongTrans param) {
				Connection conn = null;
				List<FirstLongTrans> stampcard = new ArrayList<FirstLongTrans>();

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/health_management", "sa", "");

					// SQL文を準備する
					String sql = "SELECT user_id,counter,type,long_comlete,goal_count,nogoal_count FROM FirstLongTrans";

	                // SQLインジェクション防ぐ
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					// 結果表をコレクションにコピーする
					// FirstLongTransでjavabeansのコンストラクタを全部順番通り呼ぶ
					while (rs.next()) {
						FirstLongTrans scdata = new FirstLongTrans();
					    scdata.setUser_id(rs.getString("user_id"));
					    scdata.setCounter(rs.getInt("counter"));
						scdata.setType(rs.getString("type"));
						scdata.setLong_complete(rs.getInt("long_comlete"));
						scdata.setGoal_count(rs.getInt("goal_count"));
						scdata.setNogoal_count(rs.getInt("nogoal_count"));

						stampcard.add(scdata);
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


}
