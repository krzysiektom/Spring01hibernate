<%--
  Created by IntelliJ IDEA.
  User: krzysztof
  Date: 13.04.19
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>allbooks</title>
</head>
<body>
<c:forEach items="${allBooks}" var="book">
    ${book.title} <br>
</c:forEach>
</body>
</html>
