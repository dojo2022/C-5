package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ShortMaster;

public class ShortMasterDAO {
	//	やりたいこと
	//	・選択された長期目標に応じて短期目標を全部表示
	//	やること
	//	・user_id取得
	//	・どの長期目標が選択されたか情報を持ってくる
	//	・それに応じた短期目標を全表示

	public List<ShortMaster> short_display(String user_id){
		//	短期目標を表示するためのメソッドshort_display()
		//引数にはuser_idが入るようにしたいのでString user_id
		//	値をid,type,short_goalのセットで返すためbeanを型にしている

		Connection conn = null;
		//	DBとのコネクションのためのオブジェクトconnを用意
		List<ShortMaster> shortList = new ArrayList<ShortMaster>();
		//	最後に値をセットするshortListを用意 適宜値を追加できるようにArrayListに
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");


			//	SQL文を準備する
			//	今回は選択された長期に対応する短期目標をすべて
			//	取り出す項目はtype, user_id, 短期目標のid, 短期目標
			String sql = "SELECT FIRSTLONGTRANS .type, FIRSTLONGTRANS.user_id, SHORTMASTER.id, SHORTMASTER.short_goal\r\n"
					+ "FROM ShortMaster INNER JOIN FirstLongTrans ON\r\n"
					+ "ShortMaster.type = FirstLongTrans.type\r\n"
					+ "where user_id = ? and long_complete = 1;";

			//	PreparedStatementのインスタンスを生成
			PreparedStatement pStmt = conn.prepareStatement(sql);

//			SQL文を完成させる
//			user_idをWHERE句にセット
			pStmt.setString(1, user_id);

			// SQL文を実行し、結果表を取得する
			// RESULTSETクラスのインスタンスとして得られる
			ResultSet rs = pStmt.executeQuery();

			//	必要な値：短期目標のid,type,short_goal,DBで見る用に一応user_id
			while(rs.next()) {
				ShortMaster shortitem = new ShortMaster(
						rs.getInt("id"),
						rs.getString("type"),
						rs.getString("short_goal"),
						rs.getString("user_id")
						);
				shortList.add(shortitem);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			shortList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			shortList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					shortList = null;
				}
			}
		}
		return shortList;
	}
}
