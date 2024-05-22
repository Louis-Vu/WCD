package com.example.da;

import com.example.entity.employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/EmployeeDB";
    private String jdbcUsername = "root";
    private String jdbcPassword = "password";

    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO Employee (fullName, birthday, address, position, department) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_EMPLOYEES = "SELECT * FROM Employee";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertEmployee(employee employee) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {
            preparedStatement.setString(1, employee.getFullName());
            preparedStatement.setString(2, employee.getBirthday());
            preparedStatement.setString(3, employee.getAddress());
            preparedStatement.setString(4, employee.getPosition());
            preparedStatement.setString(5, employee.getDepartment());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<employee> selectAllEmployees() {
        List<employee> employees = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String fullName = rs.getString("fullName");
                String birthday = rs.getString("birthday");
                String address = rs.getString("address");
                String position = rs.getString("position");
                String department = rs.getString("department");
                employees.add(new employee(id, fullName, birthday, address, position, department));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
