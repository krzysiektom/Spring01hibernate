<%--
  Created by IntelliJ IDEA.
  User: krzysztof
  Date: 13.04.19
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Person</title>
</head>
<body>

<form:form method="post" modelAttribute="person">
    <form:input path="login"/><br>
    <form:input path="password"/><br>
    <form:input path="email"/><br>
    <input type="submit" value="Save">
</form:form>

</body>
</html>
