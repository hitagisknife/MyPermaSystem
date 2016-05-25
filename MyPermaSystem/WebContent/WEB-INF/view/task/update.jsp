<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/task/update.do"
		method="post">
		<table>
			<tr>
				<th colspan="2">修改信息</th>
			</tr>
			<tr>
				<td>工作名称:</td>
				<td><input type="text" name="name" value="${task.name}" /></td>
			</tr>
			<tr>
				<td>工作分值:</td>
				<td><input type="text" name="score" value="${task.score}" /></td>
			</tr>
			<tr>
				<td><input type="hidden" name="num" value="${num }" />
				<input type="hidden" name="id" value=${task.id } />
				<input type="submit" value="update" /></td>
				<td><font color="red">${errorMsg}</font></td>
			</tr>
		</table>
	</form>
</body>
</html>