<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete</title>
</head>
<body>
	<c:choose>
		<c:when test="${!empty wrench}">
		<h3>Tool Deleted</h3>
		</c:when>
		<c:otherwise> Can NOT Delete Tool</c:otherwise>
	</c:choose>
	<br><br>
	<form action="homePage.do" method="GET">
		<input type="submit" value="Main Page">
	</form>
</body>
</html>