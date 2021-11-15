<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html style="background-color: aliceblue;">
<head>
<meta charset="UTF-8">
<title>Admin</title>
<style type="text/css">

.bd{
	border: 1px solid;
    background-color: white;
    margin: 100px 400px;
    border-radius: 5px;
}

h1 {
	text-align: center;
	margin: 100px;
}

h2{
	text-align: center;
    margin-top: -70px;
    margin-bottom: 50px;
    color: red;
}


form {
	margin-left: 190px;
    margin-top: -30px;
    font-size: 18px;
    margin-bottom: 90px;
}

.ip {
	width: 214px;
	height: 27px;
}
</style>
</head>
<body>
	<div class="bd">
		<h1>Welcome to Poco - Admin</h1>
		<h2>${message}</h2>

		<form action="<c:url value='loginAction'/>" method="post">
			<table>
				<tr>
					<td>User Name</td>
					<td><input class="ip" type="text" name="username" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input class="ip" type="password" name="password" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" name="Login" value="Login" style="font-size: 16px;margin-top: 25px;
					margin-left: 110px;background-color: snow;border: none;border-radius: 10px;padding: 15px 20px;cursor: pointer;"></td>
				</tr>
			</table>
			<input type="hidden" name="${_csrf.parameterName }"
				value="${_csrf.token }">
		</form>
	</div>
</body>
</html>