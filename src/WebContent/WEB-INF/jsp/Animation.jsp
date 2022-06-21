<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" type="text/css" href="/health_management/css/common.css">
 <link rel="stylesheet" type="text/css" href="/health_management/css/animation.css">
</head>
<header>
 <h1><!--<a href="/health_management/MypageServlet">健康アプリ</a>-->健康アプリ</h1>
</header>
<body>
<hr>
 体重推移アニメーション
 ｛ユーザーネーム｝さんの軌跡<br>
 <div class="image-horizontal-scroll">
				<canvas id="myChart" class="box" width ="1030" height="330"></canvas>
				</div>
<c:forEach var="e" end=14  items="${cardList}" >
	<div class=first>
	<c:out value="${e.date}"></c:out><br>
	<c:out value="${e.day_weight}"></c:out><br></div>
</c:forEach>
 <a href="/health_management/FirstChecktestServlet">
  <button type="button">二週目へ</button>
</a>

</body>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="/health_management/js/animation.js"></script>


</html>