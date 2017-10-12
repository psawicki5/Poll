<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Question no ${question.id}</title>
</head>
<body>
	<form action="/polltwo/vote/${question.id}" method="POST">
		<c:forEach items="${choices}" var="choice">	
			<input type="radio" value="${choice.id}" name="choiceId">${choice.choiceText}<br>
		</c:forEach>
		<input type="submit"/>
	</form>
	

</body>
</html>