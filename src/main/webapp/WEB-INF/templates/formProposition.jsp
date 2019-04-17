<%--
  Created by IntelliJ IDEA.
  User: krzysztof
  Date: 17.04.19
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>formProposition</title>
</head>
<body>
<form:form method="post" modelAttribute="book">

    <form:errors path="title"/><br>
    title: <form:input path="title"/><br>
    <form:errors path="description"/><br>
    description: <form:input path="description"/><br>
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>
