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
	<a href="createPage.do"> Add New Wrench</a>
	
	
	<form action="getWrench.do" method="GET">
		Wrench ID: <input type="number" name="fid" />
		<input type="submit" value="Show Wrench" />
		</form>
	<!-- <a href="getWrench.do"> Look up Wrench by Id </a> -->
	
	
		
	</form>

</body>
</html>