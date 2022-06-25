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
		String sql = "SELECT user_id, face_image, up_date FROM FACEIMAGE WHERE user_id=? order by faceimage.up_date asc LIMIT 1";

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
			firstFaceImage.setUp_date(rsFirstFace.getDate("up_date"));
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

		public boolean insertFace() {//未定
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");

				// SQL文を準備する<ここを改造する>
				 String sql ="INSERT INTO Face_image(id,user_id,face_id,up_date,face_image) VALUES(null,user_id,null,null,?)";

				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (users.getUser_id() != null && !users.getUser_id().equals("")) {
					pStmt.setString(1, users.getUser_id());
				}
				else {
					pStmt.setString(1, null);
				}
				if (users.getPassword() != null && !users.getPassword().equals("")) {
					pStmt.setString(2, users.getPassword());
				}
				else {
					pStmt.setString(2, null);
				}
				if (users.getUser_name() != null && !users.getUser_name().equals("")) {
					pStmt.setString(3, users.getUser_name());
				}
				else {
					pStmt.setString(3, null);
				}

				pStmt.setDouble(4, users.getHeight());

				pStmt.setDouble(5, users.getWeight());





				// SQL文を実行する
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
