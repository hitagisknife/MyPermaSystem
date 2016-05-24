<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/user/register.do"
		method="post">
		<table>
			<tr>
				<th colspan="2">注册新用户</th>
			</tr>
			<tr>
				<td>userName:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>password:</td>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<td>再次输入密码:</td>
				<td><input type="text" name="password2"></td>
			</tr>
			<tr>
				<td>role:</td>
				<td><input type="text" name="role"></td>
			</tr>
			<tr>
				<td><input type="submit" value="register" /></td>
			</tr>
			<tr>
				<td><font color="red">${errorMsg}</font></td>
			</tr>
		</table>
	</form>
</body>
</html>