<%@page import="com.cdac.model.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
<table class="styled-table">
<thead>
<tr>
<th>Id</th><th>Name</th><th>Email</th>
</tr>
</thead>
<tbody>
<%
List<Customer> list = (List<Customer>) session.getAttribute("5c");
for(Customer customer : list) {
%>
<tr>
	<td><%= customer.getId() %></td>
	<td><%= customer.getName() %></td>
	<td><%= customer.getEmail() %></td>
</tr>
<%
}
%>
</tbody>
</table>
<a href="CustomerPaginationServlet?page=prev">Previous</a> | 
<a href="CustomerPaginationServlet?page=next">Next</a>
</body>
</html>