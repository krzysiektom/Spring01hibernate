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

<form:form method="post" modelAttribute="personDetails">
    login: <form:input path="person.login"/><br>
    password: <form:input path="person.password"/><br>
    email: <form:input path="person.email"/><br>
    firstName: <form:input path="firstName"/><br>
    lastName: <form:input path="lastName"/><br>
    Male: <form:radiobutton path="sex" value="M"/>
    Female: <form:radiobutton path="sex" value="F"/><br>
    country: <form:select path="country">
    <form:option value="-" label="--Wybierz państwo--"/>
    <form:options items="${countries}"/>
</form:select><br>
    <form:textarea path="notes" rows="3" cols="20"/><br>
    mailingList: <form:checkbox path="mailingList"/><br>
    <form:select path="programmingSkills" items="${programmingSkills}" multiple="true"/><br>
    Hobby: <form:checkboxes path="hobbies" items="${hobbies}"/><br>
    <input type="submit" value="Save">
</form:form>

</body>
</html>
