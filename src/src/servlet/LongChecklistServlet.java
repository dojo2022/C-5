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
import model.FirstLongMaster;

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
		FirstLongMasterDAO FlmDao = new FirstLongMasterDAO();
		List<FirstLongMaster> questionList = FlmDao.first_display();

		request.setAttribute("questionList", questionList);
//		"questionList"がjspの変数名、questionListがDAOの変数名
		//目標チェックテストページへ
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/LongChecklist.jsp");
		dispatcher.forward(request, response);
		//出力部

				//リクエストスコープに入れるべきは、選択画面に表示する長期チェックの一覧
//				入れるもの：checked_list(くり返し)
//		セッションスコープからuser_idを取り出す
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");

		request.setAttribute("user_id", user_id);

//				for(String checked_list : first_checked) {
////					チェックされているtypeの行を生成
//					request.setAttribute("checked_list",checked_list);
////		データは必ずオブジェクトで渡す
////		request.setAttribute("格納するオブジェクト指すキー", "格納するオブジェクト");
//		user_idをDAOに渡したい




				}
////LongChecklistservletへリダイレクト
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/LongChecklist.jsp");
				dispatcher.forward(request, response);


	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
