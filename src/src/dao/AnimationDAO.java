package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Mypage;

public class AnimationDAO {
	public List<Mypage> select(Mypage user_id){
		Connection conn = null;
//		変数の箱だけ作ってnullにする
		List<Mypage> animationList = new ArrayList<Mypage>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");

			// SQL文を準備する　改造
			String sql = "SELECT date,day_weight FROM Mypage WHERE user_id = '?' ORDER BY date ASC";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();


			while (rs.next()) {
//				値が得られる（trueである）限り
				Mypage animation = new Mypage(
						sql, rs.getDate("date"),
						rs.getDouble("day_weight")
						//jspのNAMEとそろえる
						);
				animationList.add(animation);
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
			animationList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			animationList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					animationList = null;
				}
			}
		}

		// 結果を返す
		return animationList;
	}
}
