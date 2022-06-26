package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FaceImageDAO;
import model.AvaterHead;
/**
 * Servlet implementation class GraduateServlet
 */
@WebServlet("/GraduateServlet")
public class GraduateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session = request.getSession();
		//String user_id = (String)session.getAttribute("user_id");

		String user_id ="id_taro"; //(String)session.getAttribute("user_id");//
		//リクエストスコープにuser_idを入れる
		request.setAttribute("user_id", user_id);

		FaceImageDAO fDao = new FaceImageDAO();
		AvaterHead firstFaceImage = fDao.selectFirst(user_id);
		request.setAttribute("firstFaceImage", firstFaceImage);

		FaceImageDAO lDao = new FaceImageDAO();
		AvaterHead lastFaceImage = lDao.selectLast(user_id);
		request.setAttribute("lastFaceImage", lastFaceImage);


		// 卒業ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Graduate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}