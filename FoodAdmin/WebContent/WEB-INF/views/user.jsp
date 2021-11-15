<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Page</title>
</head>
<body>
	<h1>User Page</h1>
	<h2>Welcome: ${pageContext.request.userPrincipal.name}</h2>
	<a href="<c:url value="/admin" />">Admin Page</a>
	<br />
	<form action="<c:url value="/logoutAction" />"
		method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" /> 
		<input type="submit" value="Logout" />
	</form>

</body>
</html>