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
import dao.FirstLongTransDAO;
import model.FirstLongTrans;
import model.Mypage;
/**
 * Servlet implementation class ResultServlet
 */
@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//-----
		//ログインしていない状態なので便宜上id_kanehira
				String result_title="";
				String message="";
				String result_id ="id_yamada"; //(String)session.getAttribute("user_id");//
		//-------------------------------------------------------
				//		リクエストスコープにuser_idを入れる 疑似的にuser_id入れてるので悪しからず
				request.setAttribute("result_id", result_id);
		//--------------
				FirstLongTransDAO sDao = new FirstLongTransDAO();
				FirstLongTrans stampcard = sDao.select(result_id);
				//ゲッターを使用して値を取得、変数に格納、比較する。
				int gCount = stampcard.getGoal_count();
				int ngCount = stampcard.getNogoal_count();
				if(gCount>=12||ngCount>=3) {
					result_title="長期目標達成おめでとう!!!";
					message="この二週間よく頑張りました！ あなたはまた1歩健康へと近づいた!"
							+ "	けれどもっともっとできるはずだ…"
							+ "	習慣を続けることに終わりはない! 引き続き頑張っていこう!!!";
				}
				else {
					result_title="残念、次回は頑張ろう！";
					message="今回は失敗しちゃったけど、諦めちゃだめだよ！"
							+ "	また明日から頑張ろう！";
				}
				request.setAttribute("result_title",result_title);
				request.setAttribute("message", message);
				//------------------------------ 達成評価ページにフォワードする
					/*	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Result.jsp");
						dispatcher.forward(request, response);*/
		//String animation_id ="id_kanehira"; //(String)session.getAttribute("user_id");//
//		リクエストスコープにuser_idを入れる 疑似的にuser_id入れてるので悪しからず
		request.setAttribute("user_id", result_id);

		AnimationDAO aDao = new AnimationDAO();
		List<Mypage> animationList = aDao.select(result_id);

		request.setAttribute("animationList", animationList);
		// 達成評価ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Result.jsp");
				dispatcher.forward(request, response);
			}
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
