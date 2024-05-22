<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 5/22/2024
  Time: 9:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Employee</title>
</head>
<body>
<h2>Add Employee</h2>
<form action="EmployeeServlet" method="post">
    <label for="fullName">Full Name:</label>
    <input type="text" id="fullName" name="fullName" required><br><br>

    <label for="birthday">Birthday:</label>
    <input type="date" id="birthday" name="birthday" required><br><br>

    <label for="address">Address:</label>
    <input type="text" id="address" name="address" required><br><br>

    <label for="position">Position:</label>
    <input type="text" id="position" name="position" required><br><br>

    <label for="department">Department:</label>
    <input type="text" id="department" name="department" required><br><br>

    <button type="submit">Submit</button>
    <button type="reset">Reset</button>
</form>
</body>
</html>

