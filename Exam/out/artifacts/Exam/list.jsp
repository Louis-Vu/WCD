<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 5/22/2024
  Time: 9:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.example.entity.employee" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee List</title>
</head>
<body>
<h2>Employee List</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Full Name</th>
        <th>Birthday</th>
        <th>Address</th>
        <th>Position</th>
        <th>Department</th>
    </tr>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.fullName}</td>
            <td>${employee.birthday}</td>
            <td>${employee.address}</td>
            <td>${employee.position}</td>
            <td>${employee.department}</td>
        </tr>
    </c:forEach>
</table>
<a href="employee.jsp">Add New Employee</a>
</body>
</html>
