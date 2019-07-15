<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Wrench Added</title>
</head>
<body>

	<div>
	
	<h3>Everything marked with a * needs to be filled in</h3>
		<h4>Id: ${wrench.id}</h4>

		<c:forEach var="type" items="${wrench.typeWrench}">
			<p>Type: ${type.name}</p>
		</c:forEach>

		<h4>*Brand: ${wrench.brand}</h4>
		<h4>*Size: ${wrench.size}</h4>
		<h4>Weight: ${wrench.weightLbs}</h4>
		<h4>*Drawer Number: ${wrench.drawerNumber}</h4>
		<h4>Price: ${wrench.price}</h4>
		<h4>*Part Number: ${wrench.partNumber}</h4>
		<h4>Picture: ${wrench.picture}</h4>
	</div>
	<!-- <a href="homePage.do"> Main Page </a> -->
<form action="homePage.do" method="GET">
		<input type="submit" value="Main Page">
	</form>

</body>
</html>