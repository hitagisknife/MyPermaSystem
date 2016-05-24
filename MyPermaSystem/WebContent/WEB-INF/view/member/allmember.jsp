<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>班值</th>
		</tr>
		<c:forEach var="member" items="${memberlist }">
			<tr>
				<td>${member.id }</td>
				<td>${member.name }</td>
				<td>${member.score }</td>
				<td><a href="updatepage.do?id=${member.id }">修改</a></td>
				<td><a href="delete.do?id=${member.id }">删除</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td><a href="addpage.do">添加新成员</a></td>
		</tr>
	</table>
</body>
</html>