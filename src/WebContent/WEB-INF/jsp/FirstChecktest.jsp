<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>健康アプリ</title>
<link rel="stylesheet" href="/health_management/css/checklist.css">
</head>
<body>
	<h1>
		<img src="" alt="健康アプリ">
	</h1>
	<h2>初期チェックリスト</h2>
	<h3>
		あなたの健康度合いをチェックします！<br> 当てはまる項目<span>すべて</span>にチェックを付けてください
	</h3>

	<!--初期チェックテストのid・項目・チェックボックスを繰り返し表示
	チェックボックスの番号も繰り返すことで、データが別々に格納される-->
	<!-- ここの値をFirstChecktestServletのdoPostで処理 -->
	<form method="POST" action="/health_management/FirstChecktestServlet">
		<c:forEach var="question" items="${questionList}">
			<table>
				<tr>
					<th>${question.id}</th>
					<td class = "element">${question.first_test}</td>
					<td><input type="checkbox" name="first_ans"
						value="${question.type}"></td>
					<!-- 値をとるためのvalueをid→typeに変更 -->
				</tr>
			</table>
		</c:forEach>
		<!-- methodでPOST使う時はDo POSTで送る -->
		<div class=rightbtn>
			<input type="submit" name="" value="次へ進む" class = "button">
		</div>
	</form>

	<form method="GET" action="/health_management/RegisterServlet">
		<div class=leftbtn>
			<input type="submit" name="" value="戻る" class = "button">
		</div>
	</form>


</body>
<script src="/health_management/js/checklist.js"></script>
</html>