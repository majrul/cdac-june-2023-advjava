<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Sorry, you need to come later. <br />
This website provides services between <%= application.getInitParameter("startTime") %> to <%= application.getInitParameter("endTime") %> IST
</body>
</html>