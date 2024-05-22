package com.example.controller;


import com.example.da.EmployeeDAO;
import com.example.entity.employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {
    private EmployeeDAO employeeDAO;

    public void init() {
        employeeDAO = new EmployeeDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("submit")) {
            insertEmployee(request, response);
        } else if (action.equals("reset")) {
            response.sendRedirect("employee.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        listEmployees(request, response);
    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String fullName = request.getParameter("fullName");
        String birthday = request.getParameter("birthday");
        String address = request.getParameter("address");
        String position = request.getParameter("position");
        String department = request.getParameter("department");

        employee newEmployee = new employee();
        newEmployee.setFullName(fullName);
        newEmployee.setBirthday(birthday);
        newEmployee.setAddress(address);
        newEmployee.setPosition(position);
        newEmployee.setDepartment(department);

        try {
            employeeDAO.insertEmployee(newEmployee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("list.jsp");
    }

    private void listEmployees(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<employee> employees = employeeDAO.selectAllEmployees();
        request.setAttribute("employees", employees);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }
}
