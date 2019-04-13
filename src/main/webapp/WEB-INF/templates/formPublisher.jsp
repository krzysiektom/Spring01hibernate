<%--
  Created by IntelliJ IDEA.
  User: krzysztof
  Date: 14.04.19
  Time: 01:14
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
<form:form method="post" modelAttribute="publisher">
    firstName: <form:input path="name"/><br>
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>
