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
