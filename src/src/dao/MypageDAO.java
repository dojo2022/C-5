package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Mypage;
public class MypageDAO {
	public boolean makeIllustration(Mypage ){
		try {

			Connection conn = null;
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
						conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");

		
		}
	}

}
