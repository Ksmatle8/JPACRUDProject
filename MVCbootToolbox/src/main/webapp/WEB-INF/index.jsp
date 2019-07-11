<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ToolBox</title>
</head>
<body>

	<h1> TooLBoX</h1>
	<br>
	<a href="createPage.do"> Add New Wrench</a>
	<br>
	<br>
	
	<form action="getWrench.do" method="GET">
		Wrench ID: <input type="number" name="fid" />
		<input type="submit" value="Show Wrench" />
		</form>
		<br>
	<!-- <form action="deleteTool.do" method="GET">
		Tool ID: <input type="number" name="id" />
		<input type="submit" value="Find Tool">
		</form> -->
		
		<br>
	<form action="showAll.do"	method="GET">
		<input type="submit" value="Show All Wrenches">
	</form>
		<br>

</body>
</html>