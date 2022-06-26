package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.FaceImageDAO;

/**
 * Servlet implementation class PersonalServlet
 */
@MultipartConfig(location = "C:\\dojo6\\src\\WebContent\\images") // アップロードファイルの一時的な保存先

@WebServlet("/PersonalServlet")

public class PersonalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// パーソナルデータページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Personal.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// formの属性として enctype="multipart/form-data" 画像ファイルを取得するときはPartクラスを使う。
		// 他の値はいつも通り、request.getParameterを使う。
		Part part = request.getPart("newface"); // getPartで取得

		//sessionからuser_idを取得
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");

		//ファイル名を取得、ファイル名を自動でつける場合はココで名前を生成する必要あり
		String image = this.getFileName(part);

		// 保存する際のパスはクラスの上でアノテーションを使って、設定している。忘れたら上手く動かないよ！
		part.write(image);

		FaceImageDAO faceImageDao = new FaceImageDAO();
		faceImageDao.insert(user_id, image);

		response.sendRedirect("/health_management/MypageServlet");
	}

	//ファイルの名前を取得してくる
	private String getFileName(Part part) {
        String name = null;
        for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
            if (dispotion.trim().startsWith("filename")) {
                name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
                name = name.substring(name.lastIndexOf("\\") + 1);
                break;
            }
        }
		return name;
	}

}
