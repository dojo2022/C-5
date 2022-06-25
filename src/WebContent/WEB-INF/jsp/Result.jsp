<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="/health_management/css/result.css">
</head>
<body>
	<h1>
		日日減るすチェック
	</h1>
	<hr>
	<div class="result_title">
		<h2>

			<!--長期目標達成おめでとう!!! or 残念、次回は頑張ろう！ -->

			<c:out value="${result.title}" />
		</h2>
	</div>
		<a href="/health_management/LongChecklistServlet" class="next"> <span>次の長期目標選択へ</span>
	</a>

	<div class="avater_photo">


		<div class="text">
			<div class="result_message">
				<p>
				<c:out value="${message.message}" >
					<!-- この二週間よく頑張りました！ あなたはまた1歩健康へと近づいた!
					けれどもっともっとできるはずだ…
					習慣を続けることに終わりはない! 引き続き頑張っていこう!!!-->
					<!-- or今回は失敗しちゃったけど、諦めちゃだめだよ！
					また明日から頑張ろう！ -->
				</c:out>
					<!--<c:out value="${result.title}" />-->
				</p>

			</div>
			<div class="label">
			<p>今回の達成状況と体重推移</p>
			</div>
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
								<td><c:if test="${stamp1 == true}">
										<img
											src="/health_management/images/taihennyokuganbarimasita.png"
											alt="大変よく頑張りました！" class="stamp_image">
									</c:if></td>
								<td><c:if test="${stamp2 == true}">
										<img
											src="/health_management/images/taihennyokuganbarimasita.png"
											alt="大変よく頑張りました！" class="stamp_image">
									</c:if></td>
								<td><c:if test="${stamp3 == true}">
										<img
											src="/health_management/images/taihennyokuganbarimasita.png"
											alt="大変よく頑張りました！" class="stamp_image">
									</c:if></td>
								<td><c:if test="${stamp4 == true}">
										<img
											src="/health_management/images/taihennyokuganbarimasita.png"
											alt="大変よく頑張りました！" class="stamp_image">
									</c:if></td>
								<td><c:if test="${stamp5 == true}">
										<img
											src="/health_management/images/taihennyokuganbarimasita.png"
											alt="大変よく頑張りました！" class="stamp_image">
									</c:if></td>
								<td><c:if test="${stamp6 == true}">
										<img
											src="/health_management/images/taihennyokuganbarimasita.png"
											alt="大変よく頑張りました！" class="stamp_image">
									</c:if></td>
								<td><c:if test="${stamp7 == true}">
										<img
											src="/health_management/images/taihennyokuganbarimasita.png"
											alt="大変よく頑張りました！" class="stamp_image">
									</c:if></td>
							</tr>
							<tr>
								<td><c:if test="${stamp8 == true}">
										<img
											src="/health_management/images/taihennyokuganbarimasita.png"
											alt="大変よく頑張りました！" class="stamp_image">
									</c:if></td>
								<td><c:if test="${stamp9 == true}">
										<img
											src="/health_management/images/taihennyokuganbarimasita.png"
											alt="大変よく頑張りました！" class="stamp_image">
									</c:if></td>
								<td><c:if test="${stamp10 == true}">
										<img
											src="/health_management/images/taihennyokuganbarimasita.png"
											alt="大変よく頑張りました！" class="stamp_image">
									</c:if></td>
								<td><c:if test="${stamp11 == true}">
										<img
											src="/health_management/images/taihennyokuganbarimasita.png"
											alt="大変よく頑張りました！" class="stamp_image">
									</c:if></td>
								<td><c:if test="${stamp12 == true}">
										<img
											src="/health_management/images/taihennyokuganbarimasita.png"
											alt="大変よく頑張りました！" class="stamp_image">
									</c:if></td>
								<td><c:if test="${stamp13 == true}">
										<img
											src="/health_management/images/taihennyokuganbarimasita.png"
											alt="大変よく頑張りました！" class="stamp_image">
									</c:if></td>
								<td><c:if test="${stamp14 == true}">
										<img
											src="/health_management/images/taihennyokuganbarimasita.png"
											alt="大変よく頑張りました！" class="stamp_image">
									</c:if></td>
							</tr>
						</table>

					</div>
					<div class="panel tab-B">
						<canvas id="myChart" width="750" height="380"></canvas>
					</div>
				</div>
			</div>
		</div>

		<!--次回のアバター表示コンテンツ-->
		<div class="photo-group">
			<div class="score">
				<p>
					<strong>次回のアバター</strong><br>
					残りの長期目標${body.count}個
					<!-- 残りの長期目標数〇個 -->
				</p>
			</div>
			<div class="photo avater-first is-show-avater"></div>
			<div class="photo avater-ideal">
				<img class="idealface" src="/health_management/images/kao.png"
					alt="顔"> <img class="idealbody"
					src="/health_management/images/body4_8.png" alt="体">
				<!--images/body${body.bmi_id}_${body.color_id}.png-->

			</div>
		</div>
	</div>



</body>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="/health_management/js/result.js"></script>
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