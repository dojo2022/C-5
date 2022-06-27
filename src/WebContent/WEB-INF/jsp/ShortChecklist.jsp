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
	<h2>短期の目標設定</h2>
	<h3>
		本日設定する短期目標を<span>１つ</span>選んでください
	</h3>

	<form method="POST" action="/health_management/ShortChecklistServlet">
		<!--
doGetやること
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
					<th>${shortitem.no}</th>

					<td class = "element">${shortitem.short_goal}</td>
					<td><input type="checkbox" name="short_ans"
						value="${shortitem.no},${shortitem.type}"></td>
					<!-- valueをid→noに変更 短期は一種類のtypeしか持ってこないので、noでも良いと考えた -->
				</tr>
			</table>
			<!--
doPostやること
・idでtrue/falseを取得 -->
		</c:forEach>
		<div class=rightbtn>
			<input type="submit" name="" value="確定" class = "button">
		</div>
	</form>

	<form method="GET" action="/health_management/MypageServlet">
		<div class=leftbtn>
			<input type="submit" name="" value="戻る" class = "button">
		</div>
	</form>


</body>
<script src="/health_management/js/ShortChecklist.js">
</script>

</html>