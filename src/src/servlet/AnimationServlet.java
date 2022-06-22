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
 * Servlet implementation class AnimationServlet
 */
@WebServlet("/AnimationServlet")
public class AnimationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnimationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/health_management/LoginServlet");
			return;
		}*/
		//HttpSession session = request.getSession();
		String user_id ="id_kanehira"; //(String)session.getAttribute("user_id");//
//		リクエストスコープにuser_idを入れる
		request.setAttribute("user_id", user_id);

		AnimationDAO aDao = new AnimationDAO();
		List<Mypage> animationList = aDao.select("user_id");


		request.setAttribute("animationList", animationList);
		// 体重推移アニメーションページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Animation.jsp");
				dispatcher.forward(request, response);

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
