package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDAO;
import model.Users;


/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 新規登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Register.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");
		String user_name = request.getParameter("user_name");
		Double height = Double.parseDouble(request.getParameter("height"));
		Double weight = Double.parseDouble(request.getParameter("weight"));

		// 登録処理を行う
		UsersDAO bDao = new UsersDAO();
		Users insRec = new Users(user_id, password, user_name, height,weight );
		if (bDao.insert(insRec)) {
			// 登録成功したらユーザーIDをセッションスコープに入れる
			HttpSession session = request.getSession();
			//		Users user = new Users(user_id);
			//		session.setAttribute("user_id", user);
			//		session.setAttribute("user_id", new Users(user_id));
			session.setAttribute("user_id", user_id);

			//初期チェックテストサーブレットへリダイレクトする
			response.sendRedirect("/health_management/FirstChecktestServlet");
		}
		else {												// 登録失敗
			//新規登録ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Register.jsp");
			dispatcher.forward(request, response);
		}
	}
}
