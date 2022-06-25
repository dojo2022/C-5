package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.AvaterHead;

public class FaceImageDAO {
	// 引数paramでjavabeansから検索項目を指定し、検索結果のリストを返す
		//selectで検索する（SQLの命令と同じ）
		public AvaterHead selectLast(String user_id) {
			Connection conn = null;
			//List<FirstLongTrans> stampcard1 = null;
			AvaterHead lastFaceImage= null;
			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");
				// SQL文を準備する
				String sql = "SELECT user_id, face_image, image_date FROM FACEIMAGE WHERE user_id=? order by faceimage.image_date desc LIMIT 1";

				// SQLインジェクション防ぐ
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				pStmt.setString(1,user_id);

				// SQL文を実行し、結果表を取得する
				ResultSet rsLastFace = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				// FirstLongTransでjavabeansのコンストラクタを全部順番通り呼ぶ
				if (rsLastFace.next()) {
					//FirstLongTrans scdata = new FirstLongTrans();
					lastFaceImage = new AvaterHead();
					lastFaceImage.setUser_id(rsLastFace.getString("user_id"));
					lastFaceImage.setFace_image(rsLastFace.getString("face_image"));
					lastFaceImage.setImage_date(rsLastFace.getDate("image_date"));
					//stampcard.add(scdata);
				}

			}
			catch (SQLException e) {
				e.printStackTrace();
				lastFaceImage = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				lastFaceImage = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						lastFaceImage = null;
					}
				}
			}

			// 結果を返す
			return lastFaceImage;
		}



		public AvaterHead selectFirst(String user_id) {
	Connection conn = null;
	//List<FirstLongTrans> stampcard1 = null;
	AvaterHead firstFaceImage= null;
	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");

		// SQL文を準備する
		String sql = "SELECT user_id, face_image, image_date FROM FACEIMAGE WHERE user_id=? order by faceimage.image_date asc LIMIT 1";

		// SQLインジェクション防ぐ
		PreparedStatement pStmt = conn.prepareStatement(sql);

		// SQL文を完成させる
		pStmt.setString(1,user_id);

		// SQL文を実行し、結果表を取得する
		ResultSet rsFirstFace = pStmt.executeQuery();

		// 結果表をコレクションにコピーする
		// FirstLongTransでjavabeansのコンストラクタを全部順番通り呼ぶ
		if (rsFirstFace.next()) {
			//FirstLongTrans scdata = new FirstLongTrans();
			firstFaceImage = new AvaterHead();
			firstFaceImage.setUser_id(rsFirstFace.getString("user_id"));
			firstFaceImage.setFace_image(rsFirstFace.getString("face_image"));
			firstFaceImage.setImage_date(rsFirstFace.getDate("image_date"));
			//stampcard.add(scdata);
		}

	}
	catch (SQLException e) {
		e.printStackTrace();
		firstFaceImage = null;
	}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
		firstFaceImage = null;
	}
	finally {
		// データベースを切断
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
				firstFaceImage = null;
			}
		}
	}

	// 結果を返す
	return firstFaceImage;
	}

}
