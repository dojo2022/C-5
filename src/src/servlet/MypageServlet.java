package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FirstLongTransDAO;
import model.FirstLongTrans;
/**
 * Servlet implementation class MypageServlet
 */
@WebServlet("/MypageServlet")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*デフォ　コメントアウトでOK
	 * protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}*/
	// もしもログインしていなかったらログインサーブレットにリダイレクトする

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session = request.getSession();
		/*if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/health_management/LoginServlet");
			return;
		}*/

		//sessionスコープからuser_idを取得する
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");

//		Users user = new Users(user_id);
//		session.setAttribute("user_id", user);
//		session.setAttribute("user_id", user_id);

		// データベースから検索処理を行う
		FirstLongTransDAO fDao = new FirstLongTransDAO();
		FirstLongTrans stampCard = fDao.select(user_id);

		// 報告確定ボタンの処理ができるまでは手書きでスタンプを指定
		request.setAttribute("stamp1", true);
		request.setAttribute("stamp2", true);
		request.setAttribute("stamp3", false);
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

//      報告確定ボタンでgoal_countとgoal_countを処理できるようになったら
//		//リクエストスコープに格納する
		//3，8週目で失敗、他成功
//		request.setAttribute("stampCard", stampCard);
//		for (int i = 1; i < 14; i++) {
//			request.setAttribute("stamp"+i, false);
//			//成功数2,失敗数3
//			//stamp1	true
//			//stamp2	true
//			//stamp3	false
//			// ...
//		}



		// パーソナルデータページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Mypage.jsp");
		dispatcher.forward(request, response);
	}
	//}
	//}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


//		// リクエストパラメータを取得する Q.コンストラクタはスタンプカードに必要な項目だけでいい？
//		request.setCharacterEncoding("UTF-8");
//		int id = Integer.parseInt("id");
//		String user_id = request.getParameter("user_id");
//		int counter = Integer.parseInt("counter");
//		String type = request.getParameter("type");
//		int long_comlete = Integer.parseInt("long_comlete");
//		int goal_count = Integer.parseInt("goal_count");
//		int nogoal_count = Integer.parseInt("nogoal_count");
////		Date date = SimpleDateFormat.parse("date");
//		Date date = null;
		// ↑Date型調べる

		// 検索処理を行う
//		FirstLongTransDAO fDao = new FirstLongTransDAO();
//		FirstLongTrans stampCard = fDao.select("saburi");

		//List<FirstLongTrans> stampCard = fDao.select(new FirstLongTrans(id,user_id,counter,type,
		//		long_comlete,goal_count,nogoal_count,date));
//
//		// 検索結果をリクエストスコープに格納する
//		request.setAttribute("stampCard", stampCard);
//		//request.setAttribute("test", test);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Mypage.jsp");
		dispatcher.forward(request, response);

		// スタンプ押す・押さないの判断処理（要検討）
		// 報告ボタン→報告ページ（ShortChecklist）→確定ボタンでgoal_countとnogoal_countが変わる
		// スタンプ押す時　long_comlete==1 かつ goal_countが1増えた時、画像表示
		// スタンプ押さない時　long_comlete==1 かつ nogoal_countが1増えた時、画像表示しない
//		if((long_comlete==1) && (goal_count++)) {
//			System.out.print(/Webcontent/images/taihennyokuganbarimasita.png);
//		}else if((long_comlete==1) && (nogoal_count++)) {
//
//		}

	}

}
