<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録</title>
<link rel="stylesheet" href="/health_management/css/register.css">
<link rel="stylesheet" href="/health_management/css/common.css">
</head>
<body>
	<main>
		<h1>
			<img src="" alt="健康アプリ">
		</h1>
		<hr>
		<h2>新規登録</h2>
		<form method="POST" action="/health_management/RegisterServlet">

			<table>
				<tr>
					<th>ユーザーID</th>
					<td><input type="text" name="user_id" required></td>
				</tr>
				<tr>
					<th>パスワード</th>
					<td><input type="text" name="password" required></td>
				</tr>
				<tr>
					<th>ユーザーネーム</th>
					<td><input type="text" name="user_name" required></td>

				</tr>
				<tr>
					<th>身長</th>
					<td><input type="text" name="height" required></td>

				</tr>
				<tr>
					<th>体重</th>
					<td><input type="text" name="weight" required></td>
				</tr>
				<tr>
					<th>顔画像</th>
					<td><input type="file" name="face_id"></td>
				</tr>

				<tr>
					<td><input type="submit" name="SUBMIT" value="初期チェックテストへ">
					</td>
				</tr>

			</table>


		</form>
 <a href="/health_management/LoginServlet">
  <button type="button">ログインページに戻る</button>
</a>


		<!-- <a href ="/health_management/FirstChecktest">初期チェックテストへ</a> -->
	</main>
</body>
<script src="/health_management/js/register.js"></script>
</html>