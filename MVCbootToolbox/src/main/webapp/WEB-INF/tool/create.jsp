<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Add Wrench </title>
</head>
<body>
	<form action="create.do" method="POST">

		<label for="type">Type: </label> <input type="text" name="type">
		<br> <label for="brand">Brand: </label> <input type="text"
			name="brand"> <br> <label for="size">Size: </label> <input
			type="text" name="size"> <br> <input type="submit"
			value="Submit">

	</form>
	<!-- <a href="homePage.do"> Main Page </a> -->
	<form action="homePage.do" method="GET">
		<input type="submit" value="Main Page">
	</form>

</body>
</html>