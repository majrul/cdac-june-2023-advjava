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
	String userAgent = request.getHeader("user-agent");
%>
<h2>You are using : <%= userAgent %></h2>

<%
	String lang = request.getHeader("accept-language");
%>
<h2>Your language preference is : <%= lang %></h2>
<%
	Date d = new Date();
%>
<h2>Today's Date is : <%= d %></h2>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
</body>
</html>