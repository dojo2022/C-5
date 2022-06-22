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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");

		// ログイン処理を行う
		UsersDAO iDao = new UsersDAO();
		Users aa = new Users(user_id, password);

		if (iDao.isLoginOK(aa)) {	// ログイン成功
			// セッションスコープにIDを格納する
			HttpSession session = request.getSession();

			Users user = new Users(user_id);
			session.setAttribute("user_id", user);
//			session.setAttribute("user_id", new Users(user_id));
			session.setAttribute("user_id", user_id);


			//マイページサーブレットにリダイレクトする
			response.sendRedirect("/health_management/MypageServlet");
		}
		else {									// ログイン失敗




			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");
			dispatcher.forward(request, response);

		}
	}
}
