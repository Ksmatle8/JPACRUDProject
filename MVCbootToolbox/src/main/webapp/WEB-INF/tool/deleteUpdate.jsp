<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete</title>
</head>
<body>
	<h2>Update or Delete Tool</h2>
	<br>
	<h4>Wrench ID: ${wrench.id}</h4>
	<form action="update.do" method= "POST">
		<label for="brand">Brand: </label>
		<input type="text" name="brand" value="${wrench.brand}">
		<br>
		<label for="size">Size: </label>
		<input type="text" name="size" value="${wrench.size}">
		<br>
		<label for="weightLbs">Weight in Pounds: </label>
		<input type="text" name="weightLbs" value="${wrench.weightLbs}">
		<br>
		<label for="drawerNumber">Drawer Number: </label>
		<input type="number" name="drawerNumber" value="${wrench.drawerNumber}">
		<br>
		<label for="cost">Price: </label>
		<input type="text" name="cost" value="${wrench.price}">
		<br>
		<label for="partNumber">Part Number: </label>
		<input type="text" name="partNumber" value="${wrench.partNumber}">
		<br>
		<label for="picture">Picture: </label>
		<input type="text" name="picture" value="${wrench.picture}">
		<br> 
		<br>
		<input type="hidden" value="${wrench.id}" name="id"> <input
			type="submit" value="Update">
	</form>
	
	<form action="addNewTypeToWrench.do" method="POST">
	
	<h3><strong>Update Type of Wrench</strong></h3>
	
		<label for="typeWrench">Type of Tool: </label>
		<input type="text" name="typeWrench">
		<br>
		
		<%-- <label for="typeWrench.description">Description: </label>
		<input type="text" name="typeWrench.description" value="${wrench.typeWrench.get(0).description}" size="75">
		<br>  --%>
		
		<input type="hidden" value="${wrench.id}" name="id"> <input
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























