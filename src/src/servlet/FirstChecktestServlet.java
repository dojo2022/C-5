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
		// TODO Auto-generated method stub
		doGet(request, response);
		/*ここで初期チェック（FirstCheckTest.jsp）の値をDBに格納*/

	}

}
