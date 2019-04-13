<%--
  Created by IntelliJ IDEA.
  User: krzysztof
  Date: 14.04.19
  Time: 01:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>allPublishers</title>
</head>
<body>
<a href="/publishers/addPublisher">Add Publisher</a><br>
<c:forEach items="${allPublishers}" var="publisher">
    ${publisher.name} <a href="edit/${publisher.id}">Edit</a> <a href="delete/${publisher.id}">Delete</a> <br>
</c:forEach>
</body>
</html>
