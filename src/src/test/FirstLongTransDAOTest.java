package test;

import java.util.List;

import dao.FirstLongTransDAO;
import model.FirstLongTrans;

public class FirstLongTransDAOTest {
	public static void main(String[] args) {
		FirstLongTransDAO dao = new FirstLongTransDAO();


		// select()のテスト
		System.out.println("---------- select()のテスト ----------");
		List<FirstLongTrans> scdata2 = dao.select(new FirstLongTrans("id_saburi","","",1,"",""));
		for (FirstLongTrans stamp : scdata2) {
			System.out.println("user_id" + stamp.getUser_id());
			System.out.println("long_complete" + stamp.getLong_complete());
		}
	}
}

