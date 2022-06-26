package test;


import dao.ResultDAO;
import model.Result;

public class resultTest {

	public static void main(String[] args) {
		//HttpSession session = request.getSession();
		String user_id ="id_taro";
		//(String)session.getAttribute("user_id");//
		////		リクエストスコープにuser_idを入れる
		//request.setAttribute("user_id",user_id);

		ResultDAO rDao = new ResultDAO();
		//インスタンスの生成
		Result goalSet  = rDao.evaluate(user_id);
		// select()のテスト
		//request.setAttribute("result", goalSet);
		//System.out.println(goalSet);

		System.out.println(goalSet.getGoal_count());
		System.out.println(goalSet.getNogoal_count());
		//入力するときはコンストラクタの何番目かは意識して
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