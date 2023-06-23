<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="text-align:center">
<%
for(int i=1; i<=6; i++) {
%>
	<font size="<%= i %>">Hi All!</font><br />
<%
}
%>
</div>

<%
for(int i=1; i<=10; i++) {
%>
	<p>2 * <%= i %> = <%= 2*i %></p>
<%
}
%>
</body>
</html>