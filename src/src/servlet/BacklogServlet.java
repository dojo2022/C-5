package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AnimationDAO;
import model.Mypage;

/**
 * Servlet implementation class BacklogServlet
 */
@WebServlet("/BacklogServlet")
public class BacklogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String user_id ="id_kanehira"; //(String)session.getAttribute("user_id");//
//		リクエストスコープにuser_idを入れる
		request.setAttribute("user_id", user_id);

		AnimationDAO aDao = new AnimationDAO();
		List<Mypage> animationList = aDao.select(user_id);


		request.setAttribute("animationList", animationList);
		// 過去データ閲覧ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Backlog.jsp");
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
