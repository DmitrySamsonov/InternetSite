<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page isELIgnored="false" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update person page</title>
</head>
<body>

<form action="updatePerson" method="post">
    <input type="text" name="personId" value="${updatePersonId}"/>
    <input type="text" name="personName" value="${updatePersonName}"/>
    <input type="number" name="personAge" value="${updatePersonAge}"/>
    <button type="submit"> Save </button>
</form>

<c:forEach items="${messageList}" var="message">
    ${message}
    </br>
</c:forEach>

<form action="user" method="post">
    <button type ="submit"> Cancel</button>
</form>



</body>
</html>