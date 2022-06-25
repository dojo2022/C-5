package test;
import dao.FaceImageDAO;
import model.AvaterHead;

public class facetest {

	public static void main(String[] args) {
	//HttpSession session = request.getSession();
String user_id ="id_taro";
//(String)session.getAttribute("user_id");//
////		リクエストスコープにuser_idを入れる
//request.setAttribute("user_id",user_id);

FaceImageDAO lDao = new FaceImageDAO();
FaceImageDAO fDao = new FaceImageDAO();
//インスタンスの生成
AvaterHead lhead  = lDao.selectLast(user_id);
AvaterHead fhead  = fDao.selectFirst(user_id);
// select()のテスト
	//request.setAttribute("result", goalSet);
	//System.out.println(goalSet);
// パーソナルデータページにフォワードする
	/*RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Result.jsp");
	dispatcher.forward(request, response);*/
	System.out.println(lhead.getFace_image());
	System.out.println(fhead.getFace_image());

}
}
