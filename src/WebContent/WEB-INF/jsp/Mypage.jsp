<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mypage</title>
<!--  <link rel="stylesheet" href="/health_management/css/common.css">-->
<link rel="stylesheet" href="/health_management/css/mypage.css">
</head>
<header class="globalMenuSp">
<nav >
    <ul>
        <li><a href="/health_management/PersonalServlet">パーソナルページ</a></li>
        <li><a href="/health_management/BacklogServlet">過去データ</a></li>
        <li><a href="/health_management/LogoutServlet">ログアウト</a></li>
    </ul>
</nav>
<h1>
	<a href="/health_management/MypageServlet">
	<img src="" alt="健康アプリ">
	</a>
	</h1>

</header>
<body>
<!--  <div class="hamburger">
  <span></span>
  <span></span>
  <span></span>
</div>-->
<hr>
<form method="POST" action="/health_management/ShortChecklistServlet" id="report">
<!-- <form method="POST" action="/health_management/ResultServlet" id="report"> -->
<div class=first>
		長期目標　○○　<br>
		短期目標　○○　　<input type="checkbox" name="short" value="check"><br><br></div>
		体重<input type="text" name="height" value="">kg　
<input type="submit" name="report" value="報告"><br><br>
</form>
<div class="illustration">
		<ul id="switch1">
		<li id="stamp_s">短期目標達成状況</li>
		<li id="weight_s">体重推移</li>
		</ul>

		<div id="stamp_i">aaaaa</div>
		<div id="stamp_i">vvvvv</div>
		<div class="avater">
		<ul id="switch2">
			<li id="avater_n">現在</li>
			<li id="avater_i">理想</li>
		</ul>


		</div>
</div>
マイページなのです
</body>
<script src="/health_management/js/mypage.js"></script>
</html>