package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Mypage;

public class MypageDAO {
		Connection conn = null;

			// JDBCドライバを読み込む
		try {
			Class.forName("org.h2.Driver");
			// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");
					String sqlLong="SELECT  long_goal FROM FirstLongMaster \r\n"
							+ "INNER JOIN FirstLongTrans\r\n"
							+ "ON  FirstLongMaster.type =  FirstLongTrans.type\r\n"
							+ "where user_id = '?' and long_complete = 1;";

					String sqlShort="SELECT  short_goal FROM ShortMaster \r\n"
							+ "INNER JOIN ShortTrans\r\n"
							+ "ON ShortMaster.no =  ShortTrans.no and ShortMaster.type =  ShortTrans.type\r\n"
							+ "where user_id = '?' and exe_date = '?';";
					PreparedStatement pStmtLong = conn.prepareStatement(sqlLong);
					PreparedStatement pStmtShort = conn.prepareStatement(sqlShort);

					Resultset rsLong =pStmtLong.executeQuery();
					Resultset rsShort =pStmtShort.executeQuery();

					pStmtLong.setString(1, .getId());//一個目に引数で渡されたgetIdでえたidをいれる
					pStmtShort.setString(2,idpw.getPw());

		}
	}
