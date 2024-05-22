<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 5/22/2024
  Time: 9:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Employee</title>
</head>
<body>
<h2>Add Employee</h2>
<form action="employee" method="post">
    Full Name: <input type="text" name="fullName" required><br>
    Birthday: <input type="date" name="birthday" required><br>
    Address: <input type="text" name="address" required><br>
    Position: <input type="text" name="position" required><br>
    Department: <input type="text" name="department" required><br>
    <button type="submit" name="action" value="submit">Submit</button>
    <button type="reset" name="action" value="reset">Reset</button>
</form>
<a href="list.jsp">View Employee List</a>
</body>
</html>
