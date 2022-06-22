<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>健康アプリ</title>
<link rel = "stylesheet" href = "/health_management/css/checklist.css">
<link rel = "stylesheet" href = "/health_management/css/common.css">
</head>
<body>
<h1>
	<img src="" alt="健康アプリ">
	</h1>
長期目標設定

<form method = "POST" action = "/health_management/LongChecklistServlet">

<c:forEach var="long" items="${longList}">
		<table>
			<tr>
				<th>${long.id}</th>
				<td>${long.long_goal}</td>
				<!-- <td><input type="checkbox" name="first_ans"
					value="${long.id}"></td>  -->
			</tr>
		</table>
	</c:forEach>
<input type = "submit" name = "" value = "戻る">
</form>

<form method = "GET" action = "/health_management/ShortChecklistServlet">
<input type = "submit" name = "" value = "次へ進む">
</form>
</body>

<script src = "/health_management/js/checklist.js">
</script>
</html>