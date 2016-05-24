<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/user/login.do"
		method="post">
		<table>
			<tr>
				<th colspan="2">用户登录</th>
			</tr>
			<tr>
				<td>userName:</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>password:</td>
				<td><input type="text" name="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="login" /></td>
			</tr>
			<tr>
				<td><font color="red">${errorMsg}</font></td>
			</tr>
		</table>
	</form>
</body>
</html>