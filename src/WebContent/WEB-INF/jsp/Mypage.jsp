<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

	<!-- アバター表示用タブ---------------------------------- -->
	<div class="avater_photo">
		<!--タブ-->

		<ul class="avater-group">
			<li class="avater avater-now is-active-avater">現在</li>
			<li class="avater avater-ideal">理想(BMI:22)</li>
		</ul>

		<!--タブを切り替えて表示するコンテンツ-->
		<div class="photo-group">
			<div class="photo avater-now is-show-avater">
				<form method="POST" action="/health_management/PersonalServlet" enctype="multipart/form-data">
					<input type="file" name="newface" accept="/health_management/images">
					<input type="submit" name="submit" value="更新">
				</form>
				<img class="idealface"
					src="/health_management/images/${lastFaceImage.face_image}">
				<img class="idealbody"
					src="/health_management/images/body${bmi_id}_${color_id}.png" alt="体">
			</div>
			<div class="photo avater-ideal">
				<img class="idealface" src="/health_management/images/kao.png"
					alt="顔"> <img class="idealbody"
					src="/health_management/images/body1_0.png" alt="体">
			</div>
		</div>
	</div>


	<!-- 目標達成報告フォーム -------------------------------------------- -->

	<form method="POST" action="/health_management/MypageServlet" id="report">
		<!-- <form method="POST" action="/health_management/ResultServlet" id="report"> -->
		<ul class=first>
			<li>本日の長期目標 :${mp_lg_item.long_goal}</li>
			<li>本日の短期目標 :${mp_st_item.short_goal}</li>
			<c:choose>
				<c:when test="${mp_st_item_tomorrw == null}">
					<li>体重入力→<input type="text" name="weight" value="">kg
					</li>
					<li>
						実施チェック→
						<input type="submit" name="ok" value="達成した！！！">
						<input type="submit" name="ng" value="達成してない。。。">
					</li>
				</c:when>
				<c:otherwise>
					<li>本日の体重 :${mypage.day_weight}</li>
					<li>本日のBMI :${mypage.bmi}</li>
					<li>明日の短期目標 :${mp_st_item_tomorrw.short_goal}</li>
				</c:otherwise>
			</c:choose>
		</ul>
		<input type="hidden" name="type" value="${mp_lg_item.type}">
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
							<c:choose>
								<c:when test="${stamp1 == true}">
									<img src="/health_management/images/taihennyokuganbarimasita.png"
										alt="大変よく頑張りました！" class="stamp_image">
								</c:when>
								<c:otherwise>
									<div class="stamp_image"></div>
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<c:choose>
								<c:when test="${stamp2 == true}">
									<img src="/health_management/images/taihennyokuganbarimasita.png"
										alt="大変よく頑張りました！" class="stamp_image">
								</c:when>
								<c:otherwise>
									<div class="stamp_image"></div>
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<c:choose>
								<c:when test="${stamp3 == true}">
									<img src="/health_management/images/taihennyokuganbarimasita.png"
										alt="大変よく頑張りました！" class="stamp_image">
								</c:when>
								<c:otherwise>
									<div class="stamp_image"></div>
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<c:choose>
								<c:when test="${stamp4 == true}">
									<img src="/health_management/images/taihennyokuganbarimasita.png"
										alt="大変よく頑張りました！" class="stamp_image">
								</c:when>
								<c:otherwise>
									<div class="stamp_image"></div>
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<c:choose>
								<c:when test="${stamp5 == true}">
									<img src="/health_management/images/taihennyokuganbarimasita.png"
										alt="大変よく頑張りました！" class="stamp_image">
								</c:when>
								<c:otherwise>
									<div class="stamp_image"></div>
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<c:choose>
								<c:when test="${stamp6 == true}">
									<img src="/health_management/images/taihennyokuganbarimasita.png"
										alt="大変よく頑張りました！" class="stamp_image">
								</c:when>
								<c:otherwise>
									<div class="stamp_image"></div>
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<c:choose>
								<c:when test="${stamp7 == true}">
									<img src="/health_management/images/taihennyokuganbarimasita.png"
										alt="大変よく頑張りました！" class="stamp_image">
								</c:when>
								<c:otherwise>
									<div class="stamp_image"></div>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td>
							<c:choose>
								<c:when test="${stamp8 == true}">
									<img src="/health_management/images/taihennyokuganbarimasita.png"
										alt="大変よく頑張りました！" class="stamp_image">
								</c:when>
								<c:otherwise>
									<div class="stamp_image"></div>
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<c:choose>
								<c:when test="${stamp9 == true}">
									<img src="/health_management/images/taihennyokuganbarimasita.png"
										alt="大変よく頑張りました！" class="stamp_image">
								</c:when>
								<c:otherwise>
									<div class="stamp_image"></div>
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<c:choose>
								<c:when test="${stamp10 == true}">
									<img src="/health_management/images/taihennyokuganbarimasita.png"
										alt="大変よく頑張りました！" class="stamp_image">
								</c:when>
								<c:otherwise>
									<div class="stamp_image"></div>
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<c:choose>
								<c:when test="${stamp11 == true}">
									<img src="/health_management/images/taihennyokuganbarimasita.png"
										alt="大変よく頑張りました！" class="stamp_image">
								</c:when>
								<c:otherwise>
									<div class="stamp_image"></div>
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<c:choose>
								<c:when test="${stamp12 == true}">
									<img src="/health_management/images/taihennyokuganbarimasita.png"
										alt="大変よく頑張りました！" class="stamp_image">
								</c:when>
								<c:otherwise>
									<div class="stamp_image"></div>
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<c:choose>
								<c:when test="${stamp13 == true}">
									<img src="/health_management/images/taihennyokuganbarimasita.png"
										alt="大変よく頑張りました！" class="stamp_image">
								</c:when>
								<c:otherwise>
									<div class="stamp_image"></div>
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<c:choose>
								<c:when test="${stamp14 == true}">
									<img src="/health_management/images/taihennyokuganbarimasita.png"
										alt="大変よく頑張りました！" class="stamp_image">
								</c:when>
								<c:otherwise>
									<div class="stamp_image"></div>
								</c:otherwise>
							</c:choose>
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