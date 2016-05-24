<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>登录</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
</head>
<body>
	你好${currentUser.name }，现在时间是<%=new Date()%><br />
	<a href="user/alluser.do">查看所有用户</a>
	<br />
	<a href="member/allmember.do">编辑名单</a>
	<br />
	<a href="task/alltask.do">编辑工作</a>
	<br />
	<font color="red">${errorMsg }</font>
</body>
</html>