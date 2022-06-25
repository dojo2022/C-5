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

import dao.ShortMasterDAO;
import dao.ShortTransDAO;
import model.ShortMaster;

/**
 * Servlet implementation class ShortChecklistServlet
 */
@WebServlet("/ShortChecklistServlet")
public class ShortChecklistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//やりたいこと
		//・shortMasterDAOからデータを持ってきてjspに渡す（出力部）

		//セッションスコープからuser_idを取り出す
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");

		//		リクエストスコープにuser_idを入れる
		request.setAttribute("user_id", user_id);


		//		DAOの処理をする（DAOの処理に）引数を渡す
		ShortMasterDAO StmDao = new ShortMasterDAO();
		List<ShortMaster> shortList = StmDao.short_display(user_id);

		//		リクエストスコープに短期目標のリストをセット
		request.setAttribute("shortList", shortList);

		//今日の目標チェックリストへフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ShortChecklist.jsp");
		dispatcher.forward(request, response);

	}




	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// やりたいこと
//		短期目標のチェックされた項目の行をshortTransテーブルに一行生成
//		・jspからidで値を取得
//		・DAOを引っ張ってきて値を渡す
//		・マイページに値を渡す
//		・マイページjspにフォワード

//		入力部
//		セッションスコープからユーザーidを取得
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");

//		画面から選択された短期チェック項目を取得
//		取得用に設定したname：short_ans
		String short_checked =  request.getParameter("short_ans");
//		short_ansの中には、jspでvalue="${shortitem.no},${shortitem.type}をとってある
//		※サーブレットが値を取得できるのはリクエストスコープから/セッションスコープからの二通りだけ！
//		short_ansの中身をセットで持ってきているので、分ける必要がある
//		今の中身は[3,veg]なので「,」で分かれるようにする
		String[] tmp = short_checked.split(",");	//	3,veg →	["3", "veg"]
		int no = Integer.parseInt(tmp[0]);
		String type = tmp[1];



		//int short_checked = Integer.parseInt(request.getParameter("short_ans"));
//		${shortitem.no}でとっているのでnoがとれる？
//		jsの機能により、ここには一つのデータしか入らない

//		処理部
//		データを処理したいので、DAOのメソッドを持ってくる
//		そのメソッドの引数に必要なデータ（今回はuser_id, type, no）を渡す
//		DAOの処理内容：チェックされた短期目標noの行をShortTransに一行生成
//		doGetと同じように、shortListを持ってくる（中にtypeが入っているので、DAOに渡したい）
//		user_id, type, noをかき集めてくるのはServlet（参照：FCS75行目）

//		初めにユーザーidは取得しているのでOK↑

//		doGetで画面から値を取得する際に使用したnoを取得
//		ShortMasterDAO StmDao = new ShortMasterDAO();
//		List<ShortMaster> shortList = StmDao.short_display(user_id);

//		DAOでshortListからnoを取得？

//		short_insertメソッドを使用し、値を格納
		ShortTransDAO srt_ins = new ShortTransDAO();
		srt_ins.short_insert(user_id, type, no);


//		URLを入力するとgetリクエストが送信されて勝手にdoGetやってくれる
		response.sendRedirect("/health_management/MypageServlet");



	}

}
