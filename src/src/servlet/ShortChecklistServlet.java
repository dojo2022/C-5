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

import dao.ShortMasterDAO;
import model.ShortMaster;

/**
 * Servlet implementation class ShortChecklistServlet
 */
@WebServlet("/ShortChecklistServlet")
public class ShortChecklistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//やりたいこと
		//・shortMasterDAOからデータを持ってきてjspに渡す（出力部）

		//セッションスコープからuser_idを取り出す
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		//		リクエストスコープにuser_idを入れる
		request.setAttribute("user_id", user_id);


		//		DAOの処理をする（DAOの処理に）引数を渡す
		ShortMasterDAO StmDao = new ShortMasterDAO();
		List<ShortMaster> shortList = StmDao.short_display(user_id);


		//今日の目標チェックリストへフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ShortChecklist.jsp");
		dispatcher.forward(request, response);

		//		リクエストスコープに短期目標のリストをセット
		request.setAttribute("shortList", shortList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
