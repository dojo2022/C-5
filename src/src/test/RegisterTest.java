package test;

import dao.UsersDAO;
import model.Users;


public class RegisterTest {
	public static void main(String[] args) {
		UsersDAO dao = new UsersDAO();

		// insert()のテスト
		System.out.println("---------- insert()のテスト ----------");
		Users insRec = new Users("kokoji", "iiii", "ジミー", 163,58 );
		if (dao.insert(insRec)) {
			System.out.println("登録成功！");
			/*List<Users> cardList3 = dao.select(insRec);
			for (Users users : cardList3) {
				System.out.println("user_id：" + users.getUser_id());
				System.out.println("password：" + users.getPassword());
				System.out.println("user_name：" + users.getUser_name());
				System.out.println("height：" + users.getHeight());
				System.out.println("weight：" + users.getWeight());

			}*/
		}
		else {
			System.out.println("登録失敗！");
		}
	}
}
