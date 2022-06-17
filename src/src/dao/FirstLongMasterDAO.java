package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Bc;


//書き足し
public class BcDAO {

	// 引数paramで検索項目を指定し、検索結果のリストを返す

		public List<Bc> display() {
			Connection conn = null;
			List<Bc> cardList = new ArrayList<Bc>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

				// SQL文を準備する　改造
				String sql = "select * FROM Bc ORDER BY date DESC LIMIT 10 OFFSET 0";
				PreparedStatement pStmt = conn.prepareStatement(sql);


				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();
				//RESULTSETクラスのインスタンスとして得られる

				//改造
				// 結果表をコレクションにコピーする
				//RESULTSETに入ってたやつをARRYに入れなおしている
				//ネクスト…順番に返してくれる
				//CHAR,は文字列として取り出す
				while (rs.next()) {
					Bc card = new Bc(
					rs.getString("number"),
					rs.getString("name"),
					rs.getString("ruby"),
					rs.getString("company"),
					rs.getString("department"),
					rs.getString("date"),
					rs.getString("address"),
					rs.getString("tel"),
					rs.getString("email"),
					rs.getString("fax"),
					rs.getString("postal"),
					rs.getString("memo")
					);
					cardList.add(card);
				}
				}




				catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
					cardList = null;
				}
				finally {
					// データベースを切断
					if (conn != null) {
						try {
							conn.close();
						}
						catch (SQLException e) {
							e.printStackTrace();
							cardList = null;
						}
					}
				}

				// 結果を返す
				return cardList;
			}
