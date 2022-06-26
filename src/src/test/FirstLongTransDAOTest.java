package test;

import dao.FirstLongTransDAO;
import model.FirstLongTrans;

public class FirstLongTransDAOTest {
	public static void main(String[] args) {
		FirstLongTransDAO dao = new FirstLongTransDAO();


		// select()のテスト
		System.out.println("---------- select()のテスト ----------");
		FirstLongTrans stamp = dao.select("id_saburi");

		System.out.println("user_id" + stamp.getUser_id());
		System.out.println("long_complete" + stamp.getLong_complete());

	}
}

