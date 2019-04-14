<%--
  Created by IntelliJ IDEA.
  User: krzysztof
  Date: 14.04.19
  Time: 00:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>formAuthor</title>
</head>
<body>
<form:form method="post" modelAttribute="author">

    <form:errors path="firstName"/><br>
    firstName: <form:input path="firstName"/><br>
    <form:errors path="lastName"/><br>
    lastName: <form:input path="lastName"/><br>
    <form:errors path="PESEL"/><br>
    PESEL: <form:input path="PESEL"/><br>
    <form:errors path="email"/><br>
    email: <form:input path="email"/><br>
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>
