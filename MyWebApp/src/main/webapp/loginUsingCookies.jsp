<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
<form action="LoginServlet" method="post">
Enter username : <input type="text" name="uname" /> <br />
Enter password : <input type="password" name="pwd" /> <br />
Remember Me : <input type="checkbox" name="rememberMe" value="yes" /> <br />
<button type="submit">Submit</button> 
</form>
</body>
</html>