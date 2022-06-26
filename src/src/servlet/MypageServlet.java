package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AnimationDAO;
import dao.AvaterDAO;
import dao.FaceImageDAO;
import dao.FirstLongTransDAO;
import dao.MypageDAO;
import dao.ResultDAO;
import dao.UsersDAO;
import model.AvaterHead;
import model.FirstLongMaster;
import model.FirstLongTrans;
import model.Mypage;
import model.Result;
import model.ShortMaster;
import model.Users;
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

		//ユーザーidを取得
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");


		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/health_management/LoginServlet");
			return;
		}

		//長期・短期目標表示（兼平）
		//DAOの処理をする（DAOの処理に）引数を渡す
		MypageDAO mpTgDao = new MypageDAO();
		Calendar cal = Calendar.getInstance();
		Date exe_date1 = new Date(cal.getTimeInMillis());			//現在日付
//		Date exe_date1 = new Date(System.currentTimeMillis());

		cal.add(Calendar.DATE, 1);									//現在日付に+1日
		Date exe_date2 = new Date(cal.getTimeInMillis());			//明日の日付

		FirstLongMaster mp_lg_item = mpTgDao.mp_lg_display(user_id);
		ShortMaster mp_st_item = mpTgDao.mp_st_display(user_id, exe_date1);
		ShortMaster mp_st_item_tomorrw = mpTgDao.mp_st_display(user_id, exe_date2);

		Mypage mypage = mpTgDao.get(user_id, exe_date1);

		//リクエストスコープに長期、短期目標、明日の短期目標をセット
		request.setAttribute("mp_lg_item", mp_lg_item);
		request.setAttribute("mp_st_item", mp_st_item);
		request.setAttribute("mp_st_item_tomorrw", mp_st_item_tomorrw);
		request.setAttribute("mypage", mypage);

		//------------------------------------------------------
		//スタンプカードの表示処理

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
		FirstLongTransDAO fDao = new FirstLongTransDAO();
		FirstLongTrans stampcard = fDao.select(user_id);

		//jspに渡したい値をリクエストスコープに格納する
		for (int i = 1; i <= 14; i++) {
			if(stampcard == null) {
				//スタンプ情報が取得できなった場合
				request.setAttribute("stamp"+(i), false);

			} else if(stampcard.getGoal_count() >= i) {
				request.setAttribute("stamp"+(i), true);

			} else {
				request.setAttribute("stamp"+(i), false);
			}
		}

		//アバターの表示処理----------------------------------------------------------------------
		//（金指）アバターの顔の表示face

		FaceImageDAO lDao = new FaceImageDAO();
		AvaterHead lastFaceImage = lDao.selectLast(user_id);
		request.setAttribute("lastFaceImage", lastFaceImage);

		//-------------------------------------------------------------------------------------------------------------------
		//（安部・小島作業）アバターbody表示


		//安部さんがSELECTで持ってきたbmi=idとcolor_idをjspに渡す
		//体アバターが表示できるようになる
		AvaterDAO avaDao = new AvaterDAO();
		Users ids = avaDao.select_bodyids(user_id);

		int bmi_id =ids.getBmi_id();
		int color_id =ids.getColor_id();

		request.setAttribute("bmi_id", bmi_id);
		request.setAttribute("color_id", color_id);

		// ---------------------------------------------------------------------------------------------------
		AnimationDAO aDao = new AnimationDAO();
		List<Mypage> animationList = aDao.select(user_id);

		//体重推移データをリクエストスコープに格納
		request.setAttribute("animationList", animationList);


		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Mypage.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//-----------------------------------------------------------------------------------------------------------------
		// （安部・小島）その日の体重と短期目標にチェックしたか否かを取り出す
		//		→取り出したその日の体重からその日のBMIを計算→マイページトランザクションにINSERT

		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");

		//入力された体重と計算したBMIをデータベースに格納する
		Double day_weight = Double.parseDouble(request.getParameter("weight"));
		UsersDAO udao = new UsersDAO();
		Double height = udao.height(user_id);

		Double a = height/100;
		Double b = a*a;
		Double bmi = day_weight/b;

		MypageDAO mdao = new MypageDAO();
		mdao.insert_weights(user_id,day_weight,bmi);

		//アバターの体系を画像を切替えるために、一番古いbmi情報と最新のbmi情報を取得。
		//取得したbmi値を使って体画像のidを判定して更新する。
		Double newbmi = mdao.newbmi(user_id);
		Double oldbmi = mdao.oldbmi(user_id);
		int bmi_id ;

		double bmi_diff = oldbmi-newbmi;

		if(newbmi > oldbmi) {
			bmi_id = 4;
			//変数に４を代入
		}
		else if(bmi_diff < 1) {
			bmi_id = 3;
		}
		else if(bmi_diff < 2) {
			bmi_id = 2;
		}
		else {
			bmi_id = 1;
		}
		//その変数をDAOのアップデートに与える
		mdao.bmi_update(bmi_id, user_id);



		//短期目標を達成したか？達成していないか？をデータベースに格納する処理。
		//shortboxで取得した値によって、処理を判定する。

		//選択せれている長期目標のtypeを画面に隠したデータ(hidden)から取得。
		String type = request.getParameter("type");

		FirstLongTransDAO fDao2 = new FirstLongTransDAO();
		Date exe_date = new Date(System.currentTimeMillis());

		String okSubmit = request.getParameter("ok");
		if(okSubmit != null) {
			System.out.println("チェックボックスのチェックが入っているときの処理。");
			//チェックボックスにチェックが入っている状態

			//goal_countを+1かつ、短期目標の実績を格納する。

			//firstlongtransDAOのgoal_countが1増えたらtrue（Mypageでスタンプ画像表示されるようになるはず）
			//　UPDATE文を呼び出す（updateGoalCount）
			boolean updateGoalCount = fDao2.updateGoalCount(user_id,exe_date,type);


		}else {
			System.out.println("チェックボックスのチェックが入っていないときの処理。");
			//チェックボックスにチェックが入っていない状態

			//nogoal_countを+1かつ、短期目標の実績を格納する。

			//firstlongtransDAOのnogoal_countが1増えたらfalse（Mypageでスタンプが増えないはず）
			//　UPDATE文を呼び出す（updateNoGoalCount）
			boolean updateNoGoalCount = fDao2.updateNoGoalCount(user_id,exe_date,type);

		}



		//-----------------------------------------------------------------------------------------------------------------
		//達成評価に飛ぶ/飛ばない ＆ ほめページに飛ぶ/励ましページに飛ぶ（兼平）
		//報告するたびにこの判定が行われるので、一番さいご
		ResultDAO tran = new ResultDAO();
		Result goalSet = tran.evaluate(user_id);

		int goal_count = goalSet.getGoal_count();
		int nogoal_count = goalSet.getNogoal_count();

		//int goal_count = 12;
		//int nogoal_count = 2;

		String title;
		String message ;

		if(goal_count == 12 || nogoal_count == 3) {
			//スタンプ
			FirstLongTransDAO fDao = new FirstLongTransDAO();
			FirstLongTrans stampcard = fDao.select(user_id);

			//jspに渡したい値をリクエストスコープに格納する
			for (int i = 1; i <= 14; i++) {
				if(stampcard.getGoal_count() >= i) {
					request.setAttribute("stamp"+(i), true);

				} else {
					request.setAttribute("stamp"+(i), false);
				}
			}


			AvaterDAO avaterDao = new AvaterDAO();
			if(goal_count == 12 && nogoal_count <= 3) {
				//達成メッセージ
				title = "長期目標達成おめでとう!!!";

				message = "この二週間よく頑張りました！ あなたはまた1歩健康へと近づいた!\r\n"
						+ "けれどもっともっとできるはずだ…\r\n"
						+ "習慣を続けることに終わりはない! 引き続き頑張っていこう!!!";
				//ここにlong_completeを2にUPDATEする処理（安部さん）
				avaterDao.long_complete2(user_id);

				//long_complete=0 OR 1の数を数える
				int count = avaterDao.color_select(user_id);
				//その数をusersテーブルのcolor_idにUPDATEする
				avaterDao.color_update(count, user_id);


			}else {
				//未達成メッセージ
				title = "残念、次回は頑張ろう！";
				message = "今回は失敗しちゃったけど、諦めちゃだめだよ！\r\n"
						+ "また明日から頑張ろう！";
				//ここにlong_completeを0にUPDATEする処理（安部さん）
				avaterDao.long_complete0(user_id);
			}

			request.setAttribute("title", title);
			request.setAttribute("message", message);



			//体重
			AnimationDAO aDao = new AnimationDAO();
			List<Mypage> animationList = aDao.select(user_id);
			request.setAttribute("animationList", animationList);

			//アバター（顔）
			FaceImageDAO lDao = new FaceImageDAO();
			AvaterHead lastFaceImage = lDao.selectLast(user_id);
			request.setAttribute("lastFaceImage", lastFaceImage);

			//アバター（体）
			AvaterDAO avaDao = new AvaterDAO();
			Users ids = avaDao.select_bodyids(user_id);
			request.setAttribute("bmi_id", ids.getBmi_id());
			request.setAttribute("color_id", ids.getColor_id());


			//result.jspへフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Result.jsp");
			dispatcher.forward(request, response);

		} else {

			//	達成評価に飛ばず、マイページのまま

			//次の日の短期目標を表示する画面に遷移するように変更

			//MypageからShortChecklistServletが呼ばれたことが分かるようにセッションスコープに値を格納。
			session.setAttribute("mypage_post", "mypage_post");

			response.sendRedirect("/health_management/ShortChecklistServlet");


		}

	}

}
