package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ShortTransDAO {
	//	やりたいこと
	//	・選択された一つの短期目標の行をshortTransテーブルに格納
	//	（・報告されなければ、ランダムで目標を選択）
	//	やること
	//	・user_idを得る
	//	・どの短期目標が選択されたかを取得
	//	・それをテーブルに格納

	public boolean short_insert(String user_id, String type, int no){
		//最終的には行が得られたか（格納できたか）の真偽値を返す のでboolean

		Connection conn = null;
		//DBとのコネクションのためのオブジェクトconnを用意

		boolean result = false;
		//いったんboolean型の変数resultにはfalseを格納、行が得られたらtrueに変わるようにしておく

		try {
			//ここから実際に行いたい処理を記述


			//JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			//データベース接続
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");

			//SQL文を準備する
			//	insertする項目だけを記述する
			String sql = "INSERT INTO ShortTrans (user_id, exe_date, type, no, short_complete)\r\n"
					+ "values(?, CURDATE(), ?, ?, 0)";
			//user_idをServletがセッションスコープから取得、short_insertメソッドの引数として渡す
			//exe_dateはCURDATE関数（）で自動取得
			//typeをServletが持ってくる（shortList）
			//noをリクエストスコープから取得？
			//short_completeは選択中のフラグにすればよいので0をセット


			PreparedStatement pStmt = conn.prepareStatement(sql);

			//user_id, type, noをかき集めてくるのはServlet（参照：FCS75行目）
			//かき集めてきたものを引数として渡すので、short_insertメソッドの仮引数に指定

			//SQL文を完成させる
			pStmt.setString(1, user_id);
			pStmt.setString(2, type);
			pStmt.setInt(3, no);

			//SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
				//ここで最初にfalseにした戻り値をtrueにする = 正常に行が作れました
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
		//値を返す
	}
}

