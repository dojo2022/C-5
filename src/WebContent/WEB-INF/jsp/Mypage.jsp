<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<span class="ham_line ham_line1"></span> <span
				class="ham_line ham_line2"></span> <span class="ham_line ham_line3"></span>
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
		<a href="/health_management/MypageServlet"> <img src=""
			alt="日日減るすチェック">
		</a>
	</h1>

</header>
<body>
	<hr>
    ${stampCard.type}

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
				<img class="idealface" src="/health_management/images/kao.png"
					alt="顔"> <img class="idealbody"
					src="/health_management/images/body1_0.png" alt="体">
			</div>
		</div>
	</div>


	<!-- 目標達成報告フォーム -------------------------------------------- -->

	<form method="POST" action="/health_management/ShortChecklistServlet"
		id="report">
		<!-- <form method="POST" action="/health_management/ResultServlet" id="report"> -->
		<ul class=first>
			<li>長期目標 :${mp_lg_item.long_goal}</li>
			<li>${datentime}</li>
			<li>短期目標:<input type="checkbox" name="shortbox" value="check"></li>

			<li>体重<input type="text" name="weight" value="">kg <input
				type="submit" name="report" value="報告"></li>
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
					<!-- スタンプ押す処理は、報告完了ボタンができるまでは14個手動（タグライブラリ）-->
						<td>
						  <c:if test="${stamp1 == true}">
							  <img
								src="/health_management/images/taihennyokuganbarimasita.png"
								alt="大変よく頑張りました！" class="stamp_image">
							</c:if>
						</td>
						<td>
              <c:if test="${stamp2 == true}">
                <img
                src="/health_management/images/taihennyokuganbarimasita.png"
                alt="大変よく頑張りました！" class="stamp_image">
              </c:if>
            </td>
						<td>
              <c:if test="${stamp3 == true}">
                <img
                src="/health_management/images/taihennyokuganbarimasita.png"
                alt="大変よく頑張りました！" class="stamp_image">
              </c:if>
            </td>
						<td>
              <c:if test="${stamp4 == true}">
                <img
                src="/health_management/images/taihennyokuganbarimasita.png"
                alt="大変よく頑張りました！" class="stamp_image">
              </c:if>
            </td>
						<td>
              <c:if test="${stamp5 == true}">
                <img
                src="/health_management/images/taihennyokuganbarimasita.png"
                alt="大変よく頑張りました！" class="stamp_image">
              </c:if>
            </td>
						<td>
              <c:if test="${stamp6 == true}">
                <img
                src="/health_management/images/taihennyokuganbarimasita.png"
                alt="大変よく頑張りました！" class="stamp_image">
              </c:if>
            </td>
						<td>
              <c:if test="${stamp7 == true}">
                <img
                src="/health_management/images/taihennyokuganbarimasita.png"
                alt="大変よく頑張りました！" class="stamp_image">
              </c:if>
            </td>
					</tr>
					<tr>
						<td>
              <c:if test="${stamp8 == true}">
                <img
                src="/health_management/images/taihennyokuganbarimasita.png"
                alt="大変よく頑張りました！" class="stamp_image">
              </c:if>
            </td>
						<td>
              <c:if test="${stamp9 == true}">
                <img
                src="/health_management/images/taihennyokuganbarimasita.png"
                alt="大変よく頑張りました！" class="stamp_image">
              </c:if>
            </td>
						<td>
              <c:if test="${stamp10 == true}">
                <img
                src="/health_management/images/taihennyokuganbarimasita.png"
                alt="大変よく頑張りました！" class="stamp_image">
              </c:if>
            </td>
						<td>
              <c:if test="${stamp11 == true}">
                <img
                src="/health_management/images/taihennyokuganbarimasita.png"
                alt="大変よく頑張りました！" class="stamp_image">
              </c:if>
            </td>
						<td>
              <c:if test="${stamp12 == true}">
                <img
                src="/health_management/images/taihennyokuganbarimasita.png"
                alt="大変よく頑張りました！" class="stamp_image">
              </c:if>
            </td>
						<td>
              <c:if test="${stamp13 == true}">
                <img
                src="/health_management/images/taihennyokuganbarimasita.png"
                alt="大変よく頑張りました！" class="stamp_image">
              </c:if>
            </td>
						<td>
              <c:if test="${stamp14 == true}">
                <img
                src="/health_management/images/taihennyokuganbarimasita.png"
                alt="大変よく頑張りました！" class="stamp_image">
              </c:if>
            </td>
					</tr>
				</table>

			</div>
			<div class="panel tab-B">
				<canvas id="myChart" width="830" height="330"></canvas>
			</div>
		</div>
	</div>
	<!-- ---------------------------------------------- -->

	<!-- -------------------------------------------- -->
</body>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="/health_management/js/backlog.js"></script>

<script type="text/javascript">
const labels = [

	<c:forEach var="e" end='13' items="${animationList}">
		'${e.date}',
	</c:forEach>

  ];
const data = {
	    labels: labels,
	    datasets: [{
	      label: '体重推移',
	      backgroundColor: 'rgb(255, 99, 132)',
	      borderColor: 'rgb(255, 99, 132)',
		data: [
	 <c:forEach var="e" end='13' items="${animationList}">
	    ${e.day_weight},
	 </c:forEach>
	      ]
	    }]
	  };

	  const config = {
	    type: 'line',
	    data: data,
	    options: {}
	  };
	  const myChart = new Chart(
	    document.getElementById('myChart'),
	    config
	  );

</script>


</html>