<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
今日の目標設定

<form method = "GET" action = "/health_management/LongChecklistServlet">
<!--
やること
・リストの名前決める
・アイテムの名前決める
・foreachで短期目標をくり返し取り出す
・チェックボックスを用意し、idで値を取得
・値の送り先を指定
※foreachのインポート？忘れずに！
次はmodelを確認しよう
  -->
  <c:forEach var="shortitem" items="${shortList}">
		<table>
			<tr>
				 <th>${shortitem.id}</th>
				<td>${shortitem.long_goal}</td>
				<td><input type="checkbox" name="first_ans"
					value="${shortitem.id}"></td>
			</tr>
		</table>
	</c:forEach>
<input type = "submit" name = "" value = "戻る">
</form>

<form method = "GET" action = "/health_management/MypageServlet">
<input type = "submit" name = "" value = "確定">
</form>


</body>
<script src = "/health_management/js/checklist.js">
</script>

</html>