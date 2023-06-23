<%@page import="java.time.LocalTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String str = "Hello Everyone!";
%>
<h1><%= str %></h1>
<%
	LocalTime time = LocalTime.now();
	if(time.getHour() >= 4 && time.getHour() < 12) {
%>
		<h2>Good Morning!</h2>
<%
	}
	else if(time.getHour() >= 12 && time.getHour() < 16) {
%>
		<h2>Good Afternoon!</h2>
<%
	}
	else if(time.getHour() >= 16 && time.getHour() < 21) {
%>
		<h2>Good Evening!</h2>
<%
	}
	else {
%>
		<h2>Good Night!</h2>
<%
	}
%>
</body>
</html>