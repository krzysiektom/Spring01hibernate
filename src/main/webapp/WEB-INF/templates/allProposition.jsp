<%--
  Created by IntelliJ IDEA.
  User: krzysztof
  Date: 17.04.19
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>allProposition</title>
</head>
<body>
<a href="/proposition/add">Add Proposition</a><br>
<c:forEach items="${allBooks}" var="book">
    ${book.title} <a href="edit/${book.id}">Edit</a> <a href="confirmDelete/${book.id}">Delete</a> <br>
</c:forEach>
</body>
</html>
