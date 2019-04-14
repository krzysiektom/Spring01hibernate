<%--
  Created by IntelliJ IDEA.
  User: krzysztof
  Date: 14.04.19
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Nazwa pola : nazwa błędu</p>
<c:forEach items="${violations}" var="violation">
    <p>${violation}</p>
</c:forEach>
</body>
</html>
