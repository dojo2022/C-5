<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link rel = "stylesheet" href = "/health_management/css/login.css">
<link rel = "stylesheet" href = "/health_management/css/common.css">
</head>
<body>
<main>
<h1  >
	<img src="/health_management/images/rogo.png" alt="健康アプリ">
	</h1>
<hr>
<h2>ログイン</h2>
<h3>頑張れ！</h3>
<form method = "POST" action ="/health_management/LoginServlet">
<table>
<tr>
<td><input type = "text" class = "" placeholder = "user_id" name = "user_id" required></td>
</tr>
<tr>
<td><input type = "password" class = "" placeholder = "password" name = "password" required></td>
</tr>
<tr>
<td>
 <input type = "submit" name ="regist" value = "ログイン">
</td>
</tr>

</table>

</form>

<a href = "/health_management/RegisterServlet" class = "toregister">新規登録</a>
</main>
</body>
<script src = "/health_management/js/login.js"></script>
</html>