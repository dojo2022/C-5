<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--  <link rel="stylesheet" href="/health_management/css/common.css">-->
<link rel="stylesheet" href="/health_management/css/backlog.css">
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

過去データ閲覧

<input type="submit" name="REGIST" value="前へ">
<input type="submit" name="REGIST" value="次へ">

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
				<canvas id="myChart" width="1030" height="330"></canvas>
			</div>
		</div>
	</div>

<a href="/health_management/MypageServlet">マイページへ</a>

</body>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src = "/health_management/js/mypage.js"></script>
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