package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AnimationDAO;
import dao.FirstLongTransDAO;
import model.FirstLongTrans;
import model.Mypage;
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
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/health_management/LoginServlet");
			return;
		}


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
		//firstlongtransDAOのnogoal_countが1増えたらfalse（スタンプ押さない）


		// ---------------------------------------------------------------------------------------------------
		String animation_id ="id_kanehira"; //(String)session.getAttribute("user_id");//
		//		リクエストスコープにuser_idを入れる
		request.setAttribute("user_id", animation_id);

		AnimationDAO aDao = new AnimationDAO();
		List<Mypage> animationList = aDao.select(animation_id);

		request.setAttribute("animationList", animationList);
		// パーソナルデータページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Mypage.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {





		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Mypage.jsp");
		dispatcher.forward(request, response);



	}

}
