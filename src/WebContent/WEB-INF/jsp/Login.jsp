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
<h1  >
	<img src="" alt="健康アプリ">
	</h1>
<hr>
ログイン
<form>
<table>
<tr>
<td><input type = "text" class = "" placeholder = "ID"></td>
</tr>
<tr>
<td><input type = "password" class = "" placeholder = "PW"></td>
</tr>
<tr>
<td><input type = "submit" name = "" onclick="location.href='./index.html'"value = "ログイン"></td>
</tr>
</table>
</form>
<a href = "/health_management/RegisterServlet">新規登録</a>
</body>
<script src = "/health_management/js/login.js"></script>
</html>