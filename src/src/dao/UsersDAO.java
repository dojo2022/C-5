
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Users;

public class UsersDAO {

	//ログイン
	// ログインできるならtrueを返す
	public boolean isLoginOK(Users users) {
		Connection conn = null;
		boolean loginResult = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する*
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");

			// SELECT文を準備する*
			String sql = "select count(*) from Users where user_id = ? and password = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, users.getUser_id());
			pStmt.setString(2, users.getPassword());

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
			rs.next();
			if (rs.getInt("count(*)") == 1) {
				loginResult = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			loginResult = false;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			loginResult = false;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					loginResult = false;
				}
			}
		}

		// 結果を返す
		return loginResult;
	}


	//新規登録

	// 引数usersで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Users users) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");

			// SQL文を準備する<ここを改造する>
			String sql = "INSERT INTO Users (user_id, password, user_name, height, weight) values (?, ?, ?, ?, ?)";
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

	//身長を取り出す
	public Double height(String user_id) {
		Connection conn = null;
		Double height =0.0;

		// JDBCドライバを読み込む
		try {
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");

			String sql="SELECT height FROM Users WHERE user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQLを完成させる
			pStmt.setString(1,user_id);

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			if(rs.next()) {
				//データがあればココに入る。
				height=rs.getDouble("height");
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

		return height;

	}

}



