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
	<div class="hamburger">
		<div class="ham" id="ham">
			<span class="ham_line ham_line1"></span>
			<span class="ham_line ham_line2"></span>
			<span class="ham_line ham_line3"></span>
		</div>


		<div class="menu_wrapper" id="menu_wrapper">
			<div class="menu">
			    <ul>
			    	<li><a href="/health_management/MypageServlet">マイページ</a></li>
			        <li><a href="/health_management/PersonalServlet">パーソナルページ</a></li>
			        <li><a href="/health_management/BacklogServlet">過去データ</a></li>
			        <li><a href="/health_management/LogoutServlet">ログアウト</a></li>
			    </ul>
			</div>
		</div>
	</div>
	<h1>
		<a href="/health_management/MypageServlet">
		<img src="" alt="健康アプリ">
		</a>
	</h1>

</header>
<body>
	<hr>


	<!-- アバター表示用タブ---------------------------------- -->
	<div class="avater_photo">
		<!--タブ-->

		<ul class="avater-group">
			<li class="avater avater-now is-active-avater">現在</li>
			<li class="avater avater-ideal">理想(BMI:22)</li>
		</ul>

		<!--タブを切り替えて表示するコンテンツ-->
		<div class="photo-group">
			<div class="photo avater-now is-show-avater">現在</div>
			<div class="photo avater-ideal">
				<img class="idealface" src="/health_management/images/smile.png" alt="顔">
				</div>
			</div>
	</div>


	<!-- 目標達成報告フォーム -------------------------------------------- -->

	<form method="POST" action="/health_management/ShortChecklistServlet"
		id="report">
		<!-- <form method="POST" action="/health_management/ResultServlet" id="report"> -->
		<ul class=first>
			<li>長期目標 ○○ </li>
			<li>短期目標 ○○ <input type="checkbox" name="short"value="check"></li>

		<li>体重<input type="text" name="height" value="">kg
		<input type="submit" name="report" value="報告"></li>
		</ul>
	</form>


	<!-- 達成経過表示用タブ ---------------------------------------------- -->
	<div class="tab-panel">
		<!--タブ-->

		<ul class="tab-group">
			<li class="tab tab-A is-active">達成状況</li>
			<li class="tab tab-B">体重推移</li>

		</ul>

		<!--タブを切り替えて表示するコンテンツ-->
		<div class="panel-group">
			<div class="panel tab-A is-show">
			  <table border="1" class="stampcard">
         <tr>
          <td> <img src="/health_management/images/taihennyokuganbarimasita.png"
         alt="大変よく頑張りました！" class="stamp_image"></td>
          <td><img src="/health_management/images/taihennyokuganbarimasita.png"
         alt="大変よく頑張りました！" class="stamp_image"></td>
          <td><img src="/health_management/images/taihennyokuganbarimasita.png"
         alt="大変よく頑張りました！" class="stamp_image"></td>
          <td><img src="/health_management/images/taihennyokuganbarimasita.png"
         alt="大変よく頑張りました！" class="stamp_image"></td>
          <td><img src="/health_management/images/taihennyokuganbarimasita.png"
         alt="大変よく頑張りました！" class="stamp_image"></td>
          <td><img src="/health_management/images/taihennyokuganbarimasita.png"
         alt="大変よく頑張りました！" class="stamp_image"></td>
          <td><img src="/health_management/images/taihennyokuganbarimasita.png"
         alt="大変よく頑張りました！" class="stamp_image"></td>
         </tr>
         <tr>
          <td><img src="/health_management/images/taihennyokuganbarimasita.png"
         alt="大変よく頑張りました！" class="stamp_image"></td>
          <td><img src="/health_management/images/taihennyokuganbarimasita.png"
         alt="大変よく頑張りました！" class="stamp_image"></td>
          <td><img src="/health_management/images/taihennyokuganbarimasita.png"
         alt="大変よく頑張りました！" class="stamp_image"></td>
          <td><img src="/health_management/images/taihennyokuganbarimasita.png"
         alt="大変よく頑張りました！" class="stamp_image"></td>
          <td><img src="/health_management/images/taihennyokuganbarimasita.png"
         alt="大変よく頑張りました！" class="stamp_image"></td>
          <td><img src="/health_management/images/taihennyokuganbarimasita.png"
         alt="大変よく頑張りました！" class="stamp_image"></td>
          <td><img src="/health_management/images/taihennyokuganbarimasita.png"
         alt="大変よく頑張りました！" class="stamp_image"></td>
        </tr>
        </table>
			</div>
				<div class="panel tab-B">
				<canvas id="myChart" width ="830" height="330"></canvas>
				</div>
		</div>
	</div>
	<!-- ---------------------------------------------- -->

	<!-- -------------------------------------------- -->
</body>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="/health_management/js/mypage.js"></script>
<!-- <script>
'use strict';
const days = [
    'January',
    'February',
    'March',
    'April',
    'May',
    'June',
  ];

  const datas = {
    labels: labels,
    datasets: [{
      label: 'My First dataset',
      backgroundColor: 'rgb(255, 99, 132)',
      borderColor: 'rgb(255, 99, 132)',
      data: [0, 10, 5, 2, 20, 30, 45],
    }]
  };

  const config = {
    type: 'line',
    data: data,
    options: {}
  };
  </script> -->
 <script>
  const myChart = new Chart(
    document.getElementById('myChart'),
    config
  );
</script>


</html>