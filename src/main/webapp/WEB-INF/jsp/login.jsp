<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User</title>
</head>
<body>
<h1>User Data</h1>
<form:form action="login" method="POST" commandName="user">
	<table>
		<tr>
			<td>User name(Email)</td>
			<td><form:input path="username" /></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><form:input path="password" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" name="action" value="Login" />
				<input type="submit" name="action" value="Signup" />
			</td>
		</tr>
	</table>
</form:form>
<br>
</body>
</html>
