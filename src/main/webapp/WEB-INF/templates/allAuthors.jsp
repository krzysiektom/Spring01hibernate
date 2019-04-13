<%--
  Created by IntelliJ IDEA.
  User: krzysztof
  Date: 14.04.19
  Time: 00:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>allAuthors</title>
</head>
<body>
<a href="/authors/addAuthor">Add Author</a><br>
<c:forEach items="${allAuthors}" var="author">
    ${author.firstName} ${author.lastName} <a href="edit/${author.id}">Edit</a> <a href="delete/${author.id}">Delete</a> <br>
</c:forEach>
</body>
</html>
