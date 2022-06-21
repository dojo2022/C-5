<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<canvas id="myChart" class="box"></canvas>
				</div>
 <a href="/health_management/FirstChecktestServlet">
  <button type="button">二週目へ</button>
</a>

</body>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.bundle.js"></script>
<script src="/health_management/js/animation.js"></script>


</html>