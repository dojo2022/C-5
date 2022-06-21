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

import dao.FirstLongMasterDAO;
import dao.FirstLongTransDAO;
import model.FirstLongMaster;
/**
 * Servlet implementation class FirstChecktestServlet
 */
@WebServlet("/FirstChecktestServlet")
public class FirstChecktestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		/*if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/health_management/LoginServlet");
			return;

		}*/
		//サーブレットによってDAOとjspをつなぐ処理
		FirstLongMasterDAO FlmDao = new FirstLongMasterDAO();
		List<FirstLongMaster> questionList = FlmDao.first_display();

		request.setAttribute("questionList", questionList);
		//初期目標チェックテストページへ
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/FirstChecktest.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*ここで初期チェック（FirstCheckTest.jsp）の値をDBに格納*/


		//入力部
		//セッションからログインしているユーザーidを取得しましょう

//		HttpSession（インターフェース）型のオブジェクトrequestを生成
//		requestオブジェクトが持つgetSessionメソッドのインスタンスsessionを生成
//		セッションスコープにアクセスするための権利はリクエストスコープが持っている
//		session.getAttribute("　　　");で値をセッションスコープに入れる
		HttpSession session = request.getSession();
		session.getAttribute("user_id");

		//画面から選択された長期チェックを取得しましょう。
		String[] first_checked = request.getParameterValues("first_ans");

		//処理部
		//firstlongtransDaoのfirst_insertメソッドを繰返し呼ぶ！？
//		くり返し値をDAOに渡したい
		FirstLongTransDAO fst_ins = new FirstLongTransDAO();
		for(String checked_list : first_checked) {
//			チェックされているtypeの行を生成
			fst_ins.first_insert("user_id", checked_list);
		}


		//出力部

		//リクエストスコープに入れるべきは、選択画面に表示する長期チェックの一覧
//		入れるもの：checked_list(くり返し)


		for(String checked_list : first_checked) {
//			チェックされているtypeの行を生成
			request.setAttribute("checked_list",checked_list);

		}
		//長期チェックリスト選択画面にフォーワードする。
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/LongChecklist.jsp");
		dispatcher.forward(request, response);



	}

}
