package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.FirstLongMaster;
import model.Mypage;
import model.ShortMaster;

public class MypageDAO {
	//	public String LongTarget(String user_id) {
	//		Connection conn = null;
	//		String rs1 = "";
	//
	//			// JDBCドライバを読み込む
	//		try {
	//			Class.forName("org.h2.Driver");
	//			// データベースに接続する
	//					conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");
	//					String sqlLong="SELECT  long_goal FROM FirstLongMaster "
	//							+ "INNER JOIN FirstLongTrans ON"
	//							+ "  FirstLongMaster.type ="
	//							+ "  FirstLongTrans.type where user_id ="
	//							+ " ? and long_complete = 1";
	//					PreparedStatement pStmt = conn.prepareStatement(sqlLong);
	//					// SELECT文を実行し、結果表を取得する
	//					ResultSet rsl = pStmt.executeQuery();
	//
	//					if(rsl.next()) {
	//						//データがあればココに入る。
	//						 rs1= sqlLong;
	//					}
	//					//else {
	//						//データがなければココに入る。
	//					}
	//					catch (SQLException e) {
	//						e.printStackTrace();
	//						rs1 = null;
	//					}
	//					catch (ClassNotFoundException e) {
	//						e.printStackTrace();
	//						rs1 = null;
	//		}
	//					finally {}
	//
	//			return rs1;
	//	}
	//	public String ShortTarget(String user_id,Date date) {
	//		Connection conn = null;
	//		String rs2 = "";
	//;
	//			// JDBCドライバを読み込む
	//		try {
	//			Class.forName("org.h2.Driver");
	//			// データベースに接続する
	//					conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");
	//					String sqlShort="SELECT  short_goal "
	//							+ "FROM ShortMaster INNER JOIN "
	//							+ "ShortTrans ON ShortMaster.no =  "
	//							+ "ShortTrans.no and ShortMaster.type =  ShortTrans.type "
	//							+ "where user_id = ? and exe_date = ?";
	//
	//					PreparedStatement pStmt = conn.prepareStatement(sqlShort);
	//					// SELECT文を実行し、結果表を取得する
	//					ResultSet rss = pStmt.executeQuery();
	//
	//					if(rss.next()) {
	//						//データがあればココに入る。
	//						 rs2= sqlShort;
	//					}
	//					//else {
	//						//データがなければココに入る。
	//					}
	//					catch (SQLException e) {
	//						e.printStackTrace();
	//						rs2 = null;
	//					}
	//					catch (ClassNotFoundException e) {
	//						e.printStackTrace();
	//						rs2 = null;
	//		}
	//					finally {}
	//
	//			return rs2;
	//	}



	/*private static String getString(String string) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}




	public boolean insert(){
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");
			String sql =

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


	public boolean update(Bc param, String order){
		boolean result = false;
		Connection conn = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");
			String sqlUpS1 ="UPDATE ShortTrans SET short_complete = 1 WHERE exe_date ='?'";

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


}*/

	//指定した、ユーザーＩＤの指定した日付の情報を取得する、もし該当するデータがなければnullが返る。
	public Mypage get(String user_id, Date today) {
		Connection conn = null;
		Mypage result = null;

		try {
			//JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			//データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");

			//SQL文を準備する
			String sql = "SELECT * FROM Mypage where user_id =  ? and date = ? ";

			//PreparedStatementのインスタンスを生成
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を完成させる
			pStmt.setString(1, user_id);
			pStmt.setDate(2, today);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			if(rs.next()) {
				result = new Mypage();
				result.setUser_id(rs.getString("user_id"));
				result.setDay_weight(rs.getDouble("day_weight"));
				result.setBmi(rs.getDouble("bmi"));
			}
		}catch (SQLException e) {
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
	}

	//--------------------------------------------------------------------------------------------------------
	//(安部)マイページServletのdoGetで体アバターを表示する
	public Double newbmi(String user_id) {
		Connection conn = null;
		Double newbmi =0.0;

		// JDBCドライバを読み込む
		try {
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");

			String sql="SELECT bmi FROM Mypage WHERE user_id = ? ORDER BY date DESC LIMIT 1";
			PreparedStatement pStmt1 = conn.prepareStatement(sql);

			//SQLを完成させる
			pStmt1.setString(1,user_id);

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt1.executeQuery();

			if(rs.next()) {
				//データがあればココに入る。
				newbmi=rs.getDouble("bmi") ;
			}
			else {
				//データがなければココに入る。
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

		return newbmi;

	}

	public Double oldbmi(String user_id) {
		Connection conn = null;
		Double oldbmi =0.0;

		// JDBCドライバを読み込む
		try {
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");

			String sql="SELECT bmi FROM Mypage WHERE user_id = ? ORDER BY date ASC LIMIT 1";
			PreparedStatement pStmt2 = conn.prepareStatement(sql);

			//SQLを完成させる
			pStmt2.setString(1,user_id);

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt2.executeQuery();

			if(rs.next()) {
				//データがあればココに入る。
				oldbmi=rs.getDouble("bmi") ;
			}
			else {
				//データがなければココに入る。
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

		return oldbmi;

	}

	public boolean bmi_update(int bmi ,String user_id) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");

			// SQL文を準備する
			String sql = "UPDATE Users SET  bmi_id = ? WHERE user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, bmi);
			pStmt.setString(2, user_id);

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

	public boolean insert_weights(String user_id,Double day_weight, Double bmi) {
		//データの登録
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");

			// SQL文を準備する ここを改造
			String sql = "insert into Mypage(user_id, date, day_weight, bmi) values (?,CURDATE(),? ,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, user_id);
			pStmt.setDouble(2, day_weight);
			pStmt.setDouble(3, bmi);

			// SQL文を実行する 検索時はxecuteQuwryだったがここは違う
			if (pStmt.executeUpdate() == 1) {
				result = true;
				//戻り値のリザルトをTRUEにする
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

		// 結果を返す
		return result;
	}

	//（安部↑）
	//------------------------------------------------------------------------------------------------------------------
	//長期目標表示(兼平)

	public FirstLongMaster mp_lg_display(String user_id){
		//	FirstLongMaster型なのでFirstLongMasterのBean

		Connection conn = null;
		//	DBとのコネクションのためのオブジェクトconnを用意
		FirstLongMaster mp_long = null;
		//	最後に値をセットするshortListを用意 適宜値を追加できるようにArrayListに
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");


			//	SQL文を準備する
			//	今回は選択された長期に対応する短期目標をすべて
			//	取り出す項目はtype, user_id, 短期目標のid, 短期目標
			String sql = "SELECT user_id, long_goal, FirstLongMaster.type as type FROM FirstLongMaster INNER JOIN FirstLongTrans ON  FirstLongMaster.type =  FirstLongTrans.type where user_id =  ? and long_complete = 1";

			//	PreparedStatementのインスタンスを生成
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//		SQL文を完成させる
			//		user_idをWHERE句にセット
			pStmt.setString(1, user_id);

			// SQL文を実行し、結果表を取得する
			// RESULTSETクラスのインスタンスとして得られる
			ResultSet rs = pStmt.executeQuery();

			//	必要な値：long_goal
			if(rs.next()) {
				mp_long = new FirstLongMaster();
				mp_long.setUser_id(rs.getString("user_id"));
				mp_long.setLong_goal(rs.getString("long_goal"));
				mp_long.setType(rs.getString("type"));
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			mp_long = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			mp_long = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					mp_long = null;
				}
			}
		}
		return mp_long;
	}


	//短期目標表示（兼平）	２０２２ー０６－２５　１０：５３　→　１０９７３９３７９２８ ミリ秒で取得され、画面上に表示する場合はそれのフォーマットを整える必要がある
	public ShortMaster mp_st_display(String user_id, Date exe_date){
		//	shortmaster型なのでshortmasterのBeanについか

		Connection conn = null;
		//	DBとのコネクションのためのオブジェクトconnを用意
		ShortMaster mp_short = null;
		//	最後に値をセットするshortListを用意 適宜値を追加できるようにArrayListに
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C5", "sa", "");


			//	SQL文を準備する
			//	今回は選択された長期に対応する短期目標をすべて
			//	取り出す項目はtype, user_id, 短期目標のid, 短期目標
			String sql = "SELECT user_id, short_goal FROM ShortMaster INNER JOIN ShortTrans ON ShortMaster.no =  ShortTrans.no and ShortMaster.type =  ShortTrans.type where user_id = ? and exe_date = ?;";

			//	PreparedStatementのインスタンスを生成
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//		SQL文を完成させる
			//		user_idをWHERE句にセット
			pStmt.setString(1, user_id);
			pStmt.setDate(2, exe_date);

			// SQL文を実行し、結果表を取得する
			// RESULTSETクラスのインスタンスとして得られる
			ResultSet rs = pStmt.executeQuery();

			//	必要な値：long_goal
			if(rs.next()) {
				mp_short =new ShortMaster(
						rs.getString("user_id"),
						rs.getString("short_goal")
						);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			mp_short = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			mp_short = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					mp_short = null;
				}
			}
		}
		return mp_short;
	}
}












