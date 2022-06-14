<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録</title>
<link rel = "stylesheet" href = "/health_management/css/register.css">
<link rel = "stylesheet" href = "/health_management/css/common.css">
</head>
<body>
<h1  >
	<img src="" alt="健康アプリ">
	</h1>
<hr>
新規登録
<form method = "GET" action ="/health_management/FirstChecktest">
 <input type = "submit" name ="regist" value = "登録">
</form>
<!--
<a href="/health_management/FirstChecktest">
    <button type="button">初期チェックテストへ</button>
</a>
 -->
<!-- <a href ="/health_management/FirstChecktest">初期チェックテストへ</a> -->
</body>
<script src = "/health_management/js/register.js"></script>
</html>