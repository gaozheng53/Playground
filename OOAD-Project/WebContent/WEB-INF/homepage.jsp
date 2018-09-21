<%@ page language="java" contentType="text/html; charset=UTF-8"

pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Homepage</title>

</head>

<body>

<h1>登录成功</h1>

欢迎${requestScope.username}!
<br>


<c:forEach items="${couseList}" var="course">
		
        <tr>
            <td>${course.id}</td>
            <td>${course.name}</td>
            <td>${course.number}</td>
            <td>${course.description}</td>
            <td>${course.track}</td>
        </tr>
        <br>
</c:forEach>

</body>

</html>

