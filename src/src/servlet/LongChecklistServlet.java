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
import model.FirstLongTrans;

/**
 * Servlet implementation class LongChecklistServlet
 */
@WebServlet("/LongChecklistServlet")
public class LongChecklistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//長期目標チェックリストページへ

		//出力部

				//リクエストスコープに入れるべきは、選択画面に表示する長期チェックの一覧
//				入れるもの：checked_list(くり返し)
//		セッションスコープからuser_idを取り出す
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
//		リクエストスコープにuser_idを入れる
		request.setAttribute("user_id", user_id);

		FirstLongMasterDAO FlmDao = new FirstLongMasterDAO();
		List<FirstLongTrans> longList = FlmDao.long_display(user_id);
		//longList = ["id","user_id","type","long_goal","id","user_id","type","long_goal"]

		//longList.add(id);
		//longList.add(user_id);
		//longList.add(type);
		//longList.add(long_goal);

		//longList = ["id","user_id","type","long_goal"]


		request.setAttribute("longList", longList);
//		FlmDAOからlong_displayメソッドを呼び出し、longList（user_id, type long_list）を貰ってきている

//				for(String checked_list : first_checked) {
////					チェックされているtypeの行を生成
//					request.setAttribute("checked_list",checked_list);
////		データは必ずオブジェクトで渡す
////		request.setAttribute("格納するオブジェクト指すキー", "格納するオブジェクト");
//		user_idをDAOに渡したい

		//目標チェックテストページへ
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/LongChecklist.jsp");
		dispatcher.forward(request, response);

				}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		/*ここで初期チェック（FirstCheckTest.jsp）の値をDBに格納*/


		//入力部
		//セッションからログインしているユーザーidを取得しましょう

//		HttpSession（インターフェース）型のオブジェクトrequestを生成
//		requestオブジェクトが持つgetSessionメソッドのインスタンスsessionを生成
//		セッションスコープにアクセスするための権利はリクエストスコープが持っている
//		session.getAttribute("　　　");で値をセッションスコープから取り出す
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");

		//画面から選択された長期チェックを取得しましょう。
		String[] long_checked = request.getParameterValues("long_ans");
//		String[] first_checked  = { "veg", "fat", "cal" };

		//処理部
		//firstlongtransDaoのfirst_insertメソッドを繰返し呼ぶ！？
//		くり返し値をDAOに渡したい
		FirstLongTransDAO fst_ins = new FirstLongTransDAO();



		for(String checked_list : long_checked) {
//			チェックされているtypeの行を、チェックされた分だけ生成
			fst_ins.first_insert(user_id, checked_list);
		}

//		request.setAttribute("user_id",user_id);

	//LongChecklistservletへリダイレクト
//	URLを入力するとgetリクエストが送信されて勝手にdoGetやってくれる
		response.sendRedirect("/health_management/LongChecklistServlet");


	}




}

