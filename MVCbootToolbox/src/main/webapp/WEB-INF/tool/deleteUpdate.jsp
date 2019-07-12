<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete</title>
</head>
<body>
	<h2>Update or Delete Tool</h2>
	<br>
	<br>
	<h4>${wrench.id}</h4>
	<form action="update.do" method= "POST">
		<label for="type">Type of Tool: </label>
		<input type="text" name="type" value="${wrench.type}">
		<br>
		<label for="brand">Brand: </label>
		<input type="text" name="brand" value="${wrench.brand}">
		<br>
		<label for="size">Size: </label>
		<input type="text" name="size" value="${wrench.size}">
		<br>
		<label for="weightLbs">Weight in Pounds: </label>
		<input type="number" name="weightLbs" value="${wrench.weightLbs}">
		<br>
		<label for="drawerNumber">Drawer Number: </label>
		<input type="number" name="drawerNumber" value="${wrench.drawerNumber}">
		<br>
		<label for="cost">Price: </label>
		<input type="number" name="cost" value="${wrench.price}">
		<br>
		<label for="partNumber">Part Number: </label>
		<input type="number" name="partNumber" value="${wrench.partNumber}">
		<br>
		<label for="picture">Picture: </label>
		<input type="text" name="picture" value="${wrench.picture}">
		<br> <br><input type="hidden" value="${wrench.id}" name="id"> <input
			type="submit" value="Update">
	
	</form>

	
	<form action="deleted.do" method="POST">
		<input type="hidden" value="${wrench.id}" name="id"> <input
			type="submit" value="Delete">
	</form>
	<form action="homePage.do" method="GET">
		<input type="submit" value="Main Page">
	</form>
</body>
</html>