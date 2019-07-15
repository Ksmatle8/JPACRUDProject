<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Tools</title>
</head>
<body>
	<h3>All Your Wrenches</h3>
	<c:choose>
		<c:when test="${! empty allWrenches}">
			<ul>
				<c:forEach items="${allWrenches}" var="wrench">
					<a href="getWrench.do?fid=${wrench.id}">${wrench.brand}</a>
					<ul>
						<c:forEach var="type" items="${wrench.typeWrench}">
							<li>${type.name}</li>
						</c:forEach>
					</ul>

					<form action="sendToUpdateDeleteForm.do">
						<input type="hidden" value="${wrench.id}" name="wrenchId">
						<input type="submit" value="Update / Delete">
					</form>
				</c:forEach>
			</ul>
		</c:when>
		<c:otherwise>
			<p>There are not more wrenches in your ToolBox</p>
		</c:otherwise>
	</c:choose>

</body>
</html>