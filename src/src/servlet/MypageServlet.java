package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FirstLongTransDAO;
import dao.MypageDAO;
import dao.ResultDAO;
import dao.UsersDAO;
import model.FirstLongMaster;
import model.FirstLongTrans;
import model.Result;
/**
 * Servlet implementation class MypageServlet
 */
@WebServlet("/MypageServlet")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	// もしもログインしていなかったらログインサーブレットにリダイレクトする
	// sessionスコープからuser_idを取得する
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		ユーザーidを取得
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");


		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/health_management/LoginServlet");
			return;
		}

//		長期・短期目標表示（兼平）

		//		リクエストスコープにuser_idを入れる 上記で取得済み
		request.setAttribute("user_id", user_id);


		//		DAOの処理をする（DAOの処理に）引数を渡す
		MypageDAO mpTgDao = new MypageDAO();
		FirstLongMaster mp_lg_item = mpTgDao.mp_lg_display(user_id);
//		ShortMaster mp_st_item = mpTgDao.mp_st_display(user_id, exe_date); 短期用


		//		リクエストスコープに短期目標のリストをセット
		request.setAttribute("mp_lg_item", mp_lg_item);
//		request.setAttribute("mp_st_item", mp_st_item); 短期用


		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Mypage.jsp");
		dispatcher.forward(request, response);


		//----------------------------------------------------
		//一時的に無効にしているだけなので悪しからず


		//		Users user = new Users(user_id);
		//		session.setAttribute("user_id", user);
		//		session.setAttribute("user_id", user_id);

		// データベースから検索処理を行う
		/*FirstLongTransDAO fDao = new FirstLongTransDAO();
		FirstLongTrans stampCard = fDao.select(user_id);*/
		/*この部分は金指がテスト上コメントアウトしています。
		 * 片付いたので記号消してOKです*/
		//------------------------------------------------------
		//		スタンプカード

		// 報告確定ボタンの処理ができるまでは手書きでスタンプを指定
		/*		request.setAttribute("stamp1", true);
		request.setAttribute("stamp2", true);
		request.setAttribute("stamp3", true);
		request.setAttribute("stamp4", true);
		request.setAttribute("stamp5", true);
		request.setAttribute("stamp6", true);
		request.setAttribute("stamp7", true);
		request.setAttribute("stamp8", false);
		request.setAttribute("stamp9", true);
		request.setAttribute("stamp10", true);
		request.setAttribute("stamp11", true);
		request.setAttribute("stamp12", true);
		request.setAttribute("stamp13", true);
		request.setAttribute("stamp14", true);
		 */
		//やりたいこと
		//firstlongtransのgoal_countとnogoal_countをマイページのスタンプカードに反映させる

		//やること
		// 済　firstlongtransDAOからuser_idとgoal_count、nogoal_countを取得
		//jspに渡したい値をリクエストスコープに格納する
		FirstLongTransDAO fDao = new FirstLongTransDAO();
		FirstLongTrans stampcard = fDao.select(user_id);
		request.setAttribute("stampcard", stampcard);

		//		for (int i = 1; i < 14; i++) {
		//			request.setAttribute("stamp"+i, false);
		//			//成功数2,失敗数3
		//			//stamp1	true
		//			//stamp2	true
		//			//stamp3	false
		//			// ...
		//		}
		//firstlongtransDAOのgoal_countが1増えたらtrue（スタンプ画像表示）
		//　UPDATE文を呼び出す（updateGoalCount）
		FirstLongTransDAO fDao2 = new FirstLongTransDAO();
		Date exe_date = new Date(System.currentTimeMillis());
		String type = new String();
		boolean updateGoalCount = fDao2.updateGoalCount(user_id,exe_date,type);
		request.setAttribute("updateGoalCount", updateGoalCount);

		//firstlongtransDAOのnogoal_countが1増えたらfalse（スタンプ押さない）
		//　UPDATE文を呼び出す（updateNoGoalCount）
		FirstLongTransDAO fDao3 = new FirstLongTransDAO();
		boolean updateNoGoalCount = fDao3.updateNoGoalCount(user_id,exe_date,type);
		request.setAttribute("updateNoGoalCount", updateNoGoalCount);

//-------------------------------------------------------------------------------------------------------------------
//（安部・小島作業）アバターbody表示

		MypageDAO mdao = new MypageDAO();
		Double newbmi = mdao.newbmi(user_id);
		Double oldbmi = mdao.oldbmi(user_id);
		int bmi ;

		double a = oldbmi-newbmi;

		if(newbmi > oldbmi) {
			bmi = 4;
			//変数に４を代入
		}
		else if(a < 1) {
			bmi = 3;
		}
		else if(a < 2) {
			bmi = 2;
		}
		else {
			bmi = 1;
		}
		mdao.bmi_update(bmi,user_id);
//		//その変数をDAOのアップデートに与える




		// ---------------------------------------------------------------------------------------------------
//		String animation_id ="id_kanehira"; //(String)session.getAttribute("user_id");//
//		//		リクエストスコープにuser_idを入れる
//		request.setAttribute("user_id", animation_id);

//		AnimationDAO aDao = new AnimationDAO();
//		List<Mypage> animationList = aDao.select(animation_id);

	//	request.setAttribute("animationList", animationList);
		// パーソナルデータページにフォワードする
	//	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Mypage.jsp");
	//	dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




//-----------------------------------------------------------------------------------------------------------------
// （安部・小島）その日の体重と短期目標にチェックしたか否かを取り出す
//		→取り出したその日の体重からその日のBMIを計算→マイページトランザクションにINSERT

		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");

		String shortbox = request.getParameter("shortbox");
		Double day_weight = Double.parseDouble("weight");

		UsersDAO udao = new UsersDAO();
		Double height = udao.height(user_id);


		Double a = height/100;
		Double b = a*a;
		Double bmi = day_weight/b;


		MypageDAO mdao = new MypageDAO();
		mdao.insert_weights(user_id,day_weight,bmi);


//		FirstLongTrans tran = new FirstLongTrans();
//		tran.setGoal_count(12);
//		tran.setNogoal_count(1);



////		達成評価に飛ぶ/飛ばない ＆ ほめページに飛ぶ/励ましページに飛ぶ（兼平）
//		報告するたびにこの判定が行われるので、一番さいご

		ResultDAO tran = new ResultDAO();
		Result goalSet = tran.evaluate(user_id);

		int goal_count = goalSet.getGoal_count();

//		if() {
////			達成評価に飛ぶ
//
//			if() {
//				//達成メッセージ
//			}else {
//				//未達成メッセージ
//
//			}
//
//			//result.jspへフォワード
//		} else {

////	達成評価に飛ばず、マイページのまま
		response.sendRedirect("/health_management/MypageServlet");




//}

	}

}
