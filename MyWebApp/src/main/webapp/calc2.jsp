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
	if(request.getParameter("no1") != null && request.getParameter("no2") != null) {
		int no1 = Integer.parseInt(request.getParameter("no1"));
		int no2 = Integer.parseInt(request.getParameter("no2"));
		int sum = no1 + no2;
%>
		<h1>The sum of <%= no1 %> and <%= no2 %> is <%= sum %></h1>
<%
	}
	else {
%>
		<form>
		Enter no1 : <input type="number" name="no1" /> <br />
		Enter no2 : <input type="number" name="no2" /> <br />
		<button type="submit">Add</button>
		</form>
<%
	}
%>
</body>
</html>