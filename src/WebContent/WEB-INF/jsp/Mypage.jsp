<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mypage</title>
<link rel="stylesheet" href="/health_management/css/common.css">
<link rel="stylesheet" href="/health_management/css/mypage.css">
</head>
<body>
<!--  <div class="hamburger">
  <span></span>
  <span></span>
  <span></span>
</div>-->

<nav class="globalMenuSp">
    <ul>
        <li><a href="/health_management/PersonalServlet">パーソナルページ</a></li>
        <li><a href="/health_management/BacklogServlet">過去データ</a></li>
        <li><a href="/health_management/LogoutServlet">ログアウト</a></li>
    </ul>
</nav>
<h1  >
	<a href="/health_management/MypageServlet">
	<img src="" alt="健康アプリ">
	</a>
	</h1>
<hr>
<form method="POST" action="health_management/ShortChecklistServlet" id="report">
<div class=first>
		長期目標　○○　<br>
		短期目標　○○　　<input type="checkbox" name="short" value="check"><br><br></div>
		体重<input type="text" name="height" value="">kg　
<input type="submit" name="report" value="報告"><br><br>
</form>
マイページなのです
</body>
<script src="/health_management/js/mypage.js"></script>
</html>