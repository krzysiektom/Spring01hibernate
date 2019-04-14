<%--
  Created by IntelliJ IDEA.
  User: krzysztof
  Date: 13.04.19
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <title>Book</title>
</head>
<body>
<form:form method="post" modelAttribute="book">

    <form:errors path="title"/><br>
    <form:input path="title"/><br>
    <form:errors path="description"/><br>
    <form:input path="description"/><br>
    <form:errors path="pages"/><br>
    <form:input path="pages"/><br>
    <form:errors path="publisher" items="${allPublishers}" itemLabel="name" itemValue="id"/><br>
    <form:select path="publisher" items="${allPublishers}" itemLabel="name" itemValue="id"/><br>
    <form:errors path="authors" items="${allAuthors}" itemLabel="fullName"
                 itemValue="id" multiple="true"/><br>
    <form:select path="authors" items="${allAuthors}" itemLabel="fullName"
                 itemValue="id" multiple="true"/><br>
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>
