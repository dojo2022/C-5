<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>卒業おめでとう!
</title>
<link rel="stylesheet" type="text/css"
	href="/health_management/css/graduate.css">

</head>
<header>
<h1>日日減るすチェック</h1>
</header>
<body>
	<hr>
	<h2>Congratulations!!!!!</h2>


	<!-- アバター表示用タブ---------------------------------- -->
	<div class="avater_photo">

		<!--初日と現在のアバター比較コンテンツ-->
		<div class="photo-group">
			<div class="photo avater-first is-show-avater">初日</div>
			<div class="photo avater-ideal">
				<img class="idealface"
					src="/health_management/images/${firstFaceImage.face_image}"
					alt="顔"> <img class="idealbody"
					src="/health_management/images/body4_8.png" alt="体">
			</div>
			<div class="score">
				初日の体重<br>BMI
			</div>
		</div>
		<div class="photo-group2">
			<div class="photo avater-first is-show-avater">現在</div>
			<div class="photo avater-ideal">
				<img class="idealface2"
					src="/health_management/images/${lastFaceImage.face_image}" alt="顔">
				<img class="idealbody2" src="/health_management/images/body1_0.png"
					alt="体">
			</div>
			<img src="/health_management/images/矢印.png" alt="矢印">
			<div class="score2">
				現在の体重<br>BMI
			</div>
		</div>

		<div class="text">
			<div class="mokuhyou">
				<p>
					<strong>${requestScope.user_id}さんが今まで達成した長期目標：</strong>
					定期的に野菜をとろう！<br>
					　　　　　　　　　　　　　　　　　　　塩分摂取量を減らそう！<br>
					　　　　　　　　　　　　　　　　　　　油物の摂取量を減らそう！<br>
					　　　　　　　　　　　　　　　　　　　一日のカロリー摂取量を減らそう！<br>
					　　　　　　　　　　　　　　　　　　　よく眠れる工夫をしよう！<br>
					　　　　　　　　　　　　　　　　　　　飲酒量を減らそう！<br>
					　　　　　　　　　　　　　　　　　　　煙草の量を減らそう！<br>
					　　　　　　　　　　　　　　　　　　　運動習慣を身に着けよう！<br>
				</p>
			</div>

			<div class="message">
				<p>
					<strong>卒業おめでとう！</strong><br>
					これまでの試練を乗り越えたあなたの体は明らかに見違えた、まるで別人のようだ<br>
					しかし、習慣を続けることに終わりはない…！<br> 引き続き頑張っていこう!!!
				</p>
			</div>
			<a href="/health_management/AnimationServlet" class="next"> <span>今までの体重推移を見る</span>
			</a>
		</div>
	</div>

</body>
<script src="/health_management/js/graduate.js"></script>
</html>