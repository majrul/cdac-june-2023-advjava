<%@page import="com.cdac.model.Option"%>
<%@page import="com.cdac.model.Question"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="CalculateScoreServlet">
<%
	Question question = (Question) session.getAttribute("q");
%>

<h1><%= question.getQuestion() %></h1>
<%
	int opNo=0;
	for(Option option: question.getOptions()) {
%>
		<div>
			<input type="radio" name="op" value="<%= opNo++ %>" />
			<%= option.getOption() %>
		</div>
<%
	}
%>
<!-- <a href="QuestionLoaderServlet">Next Question</a> -->
<button type="submit">Next Question</button>
</form>
</body>
</html>







