<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>健康アプリ</title>
<link rel = "stylesheet" href = "/health_management/css/checklist.css">
<link rel = "stylesheet" href = "/health_management/css/common.css">
</head>
<body>
<h1>
	<img src="" alt="健康アプリ">
	</h1>
初期チェックリスト

<form method = "GET" action = "/health_management/RegisterServlet">

<input type = "submit" name = "" value = "戻る">
</form>

<form method = "GET" action = "/health_management/LongChecklistServlet">
<input type = "submit" name = "" value = "次へ進む">
</form>

</body>
<script src = "/health_management/js/checklist.js"></script>
</html>