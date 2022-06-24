<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="/health_management/css/graduate.css">
<link rel="stylesheet" type="text/css"
	href="/health_management/css/common.css">

</head>
<body>
	<h1>日日減るすチェック</h1>
	<h2>Congratulations!!!!!</h2>


	<!-- アバター表示用タブ---------------------------------- -->
	<div class="avater_photo">

		<!--初日と現在のアバター比較コンテンツ-->
		<div class="photo-group">
			<div class="photo avater-first is-show-avater">初日</div>
			<div class="photo avater-ideal">
			<img class="idealface" src="/health_management/images/kao.png" alt="顔">
				<img class="idealbody" src="/health_management/images/body4_8.png"
					alt="体">
			</div>
			<div class="score">
			初日の体重<br>BMI
			</div>
		</div>
		<div class="photo-group2">
			<div class="photo avater-first is-show-avater">現在</div>
			<div class="photo avater-ideal">
			<img class="idealface2" src="/health_management/images/kao.png" alt="顔">
				<img class="idealbody2" src="/health_management/images/body1_0.png"
					alt="体">
			</div>
			<div class="score2">
			現在の体重<br>BMI
			</div>
		</div>
		<div class="text">
			<div class="mokuhyou">
			<p>
			<strong>達成長期目標</strong>

			</p>
			</div>

			<div class="message">
				<p><strong>卒業おめでとう！</strong><br>
				これまでの試練を乗り越えたあなたの体は明らかに見違えた、まるで別人のようだ<br>
				だがしかし、習慣を続けることに終わりはない…！<br> 引き続き頑張っていこう!!!</p>
			</div>
		</div>

	</div>
	<a href="/health_management/AnimationServlet" class="next">
		<span>体重推移アニメーションへ</span>
	</a>
</body>
<script src="/health_management/js/graduate.js"></script>
</html>