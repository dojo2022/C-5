<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>最終報告アニメーション</title>
 <link rel="stylesheet" type="text/css" href="/health_management/css/common.css">
 <link rel="stylesheet" type="text/css" href="/health_management/css/animation.css">
</head>
<header>
 <h1><!--<a href="/health_management/MypageServlet">健康アプリ</a>-->健康アプリ</h1>
</header>
<body>
<hr>
 体重推移アニメーション
 <c:out value="${e.user_id}"></c:out>さんの軌跡<br>
 <div class="image-horizontal-scroll">
				<canvas id="myChart" class="box" width ="1030" height="330"></canvas>
				</div>
 <a href="/health_management/FirstChecktestServlet">
  <button type="button">二週目へ</button>
</a>

</body>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<!--<script src="/health_management/js/animation.js"></script>-->

<script type="text/javascript">
const labels = [

	<c:forEach var="e" items="${animationList}">
		${e.date}
	</c:forEach>

  ];
const weight =  [
	 <c:forEach var="e" items="${animationList}">
	    	  ${e.day_weight}
	    	  </c:forEach>
	      ];
const data = {
	    labels: labels,
	    datasets: [{
	      label: '体重推移',
	      backgroundColor: 'rgb(255, 99, 132)',
	      borderColor: 'rgb(255, 99, 132)',
	      data: weight
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