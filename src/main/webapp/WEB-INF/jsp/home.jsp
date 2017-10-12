<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
</head>
<body>
	<h1>Hello World</h1>
	
	<c:forEach items="${questions}" var="question">
		<c:url var="questionUrl" value="/vote">
   			<c:param name="questionId" value="${question.id}"/>
		</c:url>
		<p><a href="vote/${question.id}">${question.questionText}</a></p>
	</c:forEach>
</body>
</html>