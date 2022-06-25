package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AvaterDAO {
	]//---------------------------------------------------------------------------------------------------------

			public int body_color(String user_id) {
				Connection conn = null;
				boolean result = false;
				try {
					//			JDBCドライバを読み込む
					Class.forName("org.h2.Driver");
					//			データベース接続
					conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");

					//			SQL文を準備する
					//			insertする項目だけを記述する。
					String sql = "SELECT COUNT(*) FROM FirstLongTrans WHERE long_complete = 0 OR 1 and user_id = ?";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					//			SQL文を完成させる
					pStmt.setString(1, user_id);

					// SQL文を実行し、結果表を取得する
								ResultSet rs = pStmt.executeQuery();

								// 結果表をコレクションにコピーする
								// FirstLongTransでjavabeansのコンストラクタを全部順番通り呼ぶ
								if (rs.next()) {
									pStmt.setInt(count(*));
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
