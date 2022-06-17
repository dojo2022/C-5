<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>健康アプリ</title>
<link rel="stylesheet" href="/health_management/css/checklist.css">
<link rel="stylesheet" href="/health_management/css/common.css">
</head>
<body>
	<h1>
		<img src="" alt="健康アプリ">
	</h1>
	<h2>初期チェックリスト</h2>
	<h4>
		あなたの長期目標は以下の〇点です<br> この2週間の長期目標を一つ選択してください
	</h4>

	<c:forEach var="question" items="${questionList}">
		<table>
			<tr>
				<th>${question.id}</th>
				<td>${question.first_test}</td>
				<td><input type="checkbox" name="first_ans"
					value="${question.id}"></td>
			</tr>
		</table>
	</c:forEach>
	<form method="POST" action="/health_management/RegisterServlet">

		<input type="submit" name="" value="戻る">
	</form>

	<form method="GET" action="/health_management/LongChecklistServlet">
		<input type="submit" name="" value="次へ進む">
	</form>

</body>
<script src="/health_management/js/checklist.js"></script>
</html>