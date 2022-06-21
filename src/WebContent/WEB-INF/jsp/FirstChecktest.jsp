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
		初期チェック説明の文章<br> 初期チェック説明の文章
	</h4>

	<!--初期チェックテストのid・項目・チェックボックスを繰り返し表示
	チェックボックスの番号も繰り返すことで、データが別々に格納される-->
		<!-- ここの値をFirstChecktestServletのdoPostで処理 -->
	<form method="POST" action="/health_management/FirstChecktestServlet">
	<c:forEach var="question" items="${questionList}">
		<table>
			<tr>
				<th>${question.id}</th>
				<td>${question.first_test}</td>
				<td><input type="checkbox" name="first_ans"
					value="${question.type}"></td>
					<!-- 値をとるためのvalueをid→typeに変更 -->
			</tr>
		</table>
	</c:forEach>
	<!-- methodでPOST使う時はDo POSTで送る -->
		<input type="submit" name="" value="次へ進む">
	</form>

		<form method="GET" action="/health_management/RegisterServlet">
		<input type="submit" name="" value="戻る">
	</form>


</body>
<script src="/health_management/js/checklist.js"></script>
</html>