<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Headers Example</title>
</head>
<body>
<%
	//response.setHeader("refresh", "1");
	response.setHeader("refresh", "5; url=http://www.google.com");
%>
<h2>Today's Date is <%= new Date() %></h2>
</body>
</html>