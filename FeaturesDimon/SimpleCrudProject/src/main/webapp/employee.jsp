<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page isELIgnored="false" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Employee page</title>
</head>
<body>

<h1> Employee page </h1>



<table border="2" bgcolor="#F8F8CE">
    <tr>
        <th  width="150" height="40"> <h4> ID </h4> </th>
        <th  width="150" height="40"> <h4> NAME </h4> </th>
        <th  width="150" height="40"> <h4> AGE </h4> </th>
        <th  width="50" height="40"> <h4> EDIT </h4> </th>
        <th  width="50" height="40"> <h4> DELETE </h4> </th>
    </tr>

 <c:forEach items="${employeeList}" var="employee">
   <tr>
     <td>${employee.id}</td>
     <td>${employee.name}</td>
     <td>${employee.age}</td>
     <td align="center">
        <form action = "updateEmployee" method="get">
            <input type="hidden" name="updateEmployeeId" value="${employee.id}">
            <input type="hidden" name="updateEmployeeName" value="${employee.name}">
            <input type="hidden" name="updateEmployeeAge" value="${employee.age}">
            <button type="submit" style='width:100'> Edit </button>
        </form>
     </td>
     <td align="center">
        <form action = "api/employeeDelete" method="post">
            <input type="hidden" name="deleteEmployeeId" value="${employee.id}">
            <button type="submit" style='width:100'> Delete </button>
        </form>
     </td>

    </tr>
  </c:forEach>
  </table>

    <form action="addEmployee" method="get">
         <button type="submit"> Add new employee </button>
    </form>

    </br>

        <form action= "starting.html" method="get">
      <button type = "submit"> Cancel </button>
      </form>

</body>
</html>