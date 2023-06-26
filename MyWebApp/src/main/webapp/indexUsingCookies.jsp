<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home page</title>
</head>
<body>
<%
	String url = "loginUsingCookies.jsp";
	Cookie[] cookies = request.getCookies();
	if(cookies != null) {
		String username = "", password = "";
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("uname"))
				username = cookie.getValue();
			if(cookie.getName().equals("pwd"))
				password = cookie.getValue();
			
		}
		if(username.equals("majrul") && password.equals("123"))
			url = "welcome.jsp";
	}
%>

<a href="<%= url %>">Click here</a> to continue

</body>
</html>