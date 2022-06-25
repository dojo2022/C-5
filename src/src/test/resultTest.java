package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ResultDAO;
import model.Result;

public class resultTest {
String user_id;
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//HttpSession session = request.getSession();
String user_id ="id_taro"; //(String)session.getAttribute("user_id");//
////		リクエストスコープにuser_idを入れる
request.setAttribute("user_id",user_id);

ResultDAO rDao = new ResultDAO();
Result goalSet  = rDao.evaluate(user_id);

	request.setAttribute("result", goalSet);
	System.out.println(goalSet);
// パーソナルデータページにフォワードする
	/*RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Result.jsp");
	dispatcher.forward(request, response);*/

//		//達成メッセージ
//	}else {
//		//未達成メッセージ
//
//	}
//
//	//result.jspへフォワード
//} else {
}
}