package com.example.practicandocrud.Daos;

import com.example.practicandocrud.Beans.Employee;
import com.example.practicandocrud.Beans.Job;


import java.sql.*;
import java.util.ArrayList;

public class EmployeeDao {

    public ArrayList<Employee> obtenerListaEmployee(){
        ArrayList<Employee> listaEmployees = new ArrayList<>();

        try {
            String user = "root";
            String pass = "root";
            String url = "jdbc:mysql://127.0.0.1:3306/hr";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT employee_id, concat(first_name,' ',last_name) as employee, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id FROM employees;");

            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(rs.getInt(1));
                employee.setFullNameEmployee(rs.getString(2));
                employee.setEmailEmployee(rs.getString(3));
                employee.setPhoneEmployee(rs.getString(4));
                employee.setHireDateEmployee(rs.getDate(5));
                employee.setJob_id(rs.getString(6));
                employee.setSalaryEmployee(rs.getDouble(7));
                employee.setCommissionPctEmployee(rs.getDouble(8));
                employee.setManangerId(rs.getInt(9));
                employee.setDepartmentId(rs.getInt(10));

                listaEmployees.add(employee);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return listaEmployees;

    }

    public void crearEmployee(Employee employee){
        try {
            String user = "root";
            String pass = "root";
            String url = "jdbc:mysql://127.0.0.1:3306/hr";

            Class.forName("com.mysql.cj.jdbc.Driver");
            try(Connection conn = DriverManager.getConnection(url, user, pass);){
                String sql = "INSERT INTO employees (first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                String fullName = employee.getFullNameEmployee().trim();
                String[] names = fullName.split(" ");
                String firstName = names[0];
                String lastName = names[1];
                try(PreparedStatement pstmt = conn.prepareStatement(sql)){
                    pstmt.setString(1, firstName);
                    pstmt.setString(2, lastName);
                    pstmt.setString(3, employee.getEmailEmployee());
                    pstmt.setString(4, employee.getPhoneEmployee());
                    pstmt.setDate(5, employee.getHireDateEmployee());
                    pstmt.setString(6, employee.getJob_id());
                    pstmt.setDouble(7, employee.getSalaryEmployee());
                    pstmt.setDouble(8, employee.getCommissionPctEmployee());
                    pstmt.setInt(9, employee.getManangerId());
                    pstmt.setInt(10, employee.getDepartmentId());

                    pstmt.executeUpdate();
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Employee obtenerEmployee(String employeeID){
        Employee employee = null;
        try{
            String user = "root";
            String pass = "root";
            String url = "jdbc:mysql://127.0.0.1:3306/hr";

            Class.forName("com.mysql.cj.jdbc.Driver");
            try(Connection conn = DriverManager.getConnection(url, user, pass);
                PreparedStatement pstmt = conn.prepareStatement("SELECT employee_id, concat(first_name,' ',last_name) as employee, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id FROM employees WHERE employee_id=?;");) {

                pstmt.setString(1, employeeID);

                try(ResultSet rs = pstmt.executeQuery()){
                    if(rs.next()){
                        employee = new Employee();
                        employee.setEmployeeId(rs.getInt(1));
                        employee.setFullNameEmployee(rs.getString(2));
                        employee.setEmailEmployee(rs.getString(3));
                        employee.setPhoneEmployee(rs.getString(4));
                        employee.setHireDateEmployee(rs.getDate(5));
                        employee.setJob_id(rs.getString(6));
                        employee.setSalaryEmployee(rs.getDouble(7));
                        employee.setCommissionPctEmployee(rs.getDouble(8));
                        employee.setManangerId(rs.getInt(9));
                        employee.setDepartmentId(rs.getInt(10));
                    }
                }
            }
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return employee;
    }

    public void actualizarEmployee(Employee employee) {
        try {
            String user = "root";
            String pass = "root";
            String url = "jdbc:mysql://127.0.0.1:3306/hr";

            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, user, pass);) {
                String sql = "UPDATE employees SET first_name = ?, last_name = ?, email = ?, phone_number = ?, \n" +
                        "             hire_date = ?, job_id = ?, salary = ?, commission_pct = ?, manager_id = ?, department_id = ? \n" +
                        "             WHERE employee_id = ?";


                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

                    String fullName = employee.getFullNameEmployee().trim();
                    String[] names = fullName.split(" ");
                    String firstName = names[0];
                    String lastName = names[1];
                    pstmt.setString(1, firstName);
                    pstmt.setString(2, lastName);
                    pstmt.setString(3, employee.getEmailEmployee());
                    pstmt.setString(4, employee.getPhoneEmployee());
                    pstmt.setDate(5, employee.getHireDateEmployee());
                    pstmt.setString(6, employee.getJob_id());
                    pstmt.setDouble(7, employee.getSalaryEmployee());
                    pstmt.setDouble(8, employee.getCommissionPctEmployee());
                    pstmt.setInt(9, employee.getManangerId());
                    pstmt.setInt(10, employee.getDepartmentId());
                    pstmt.setInt(11, employee.getEmployeeId());
                    pstmt.executeUpdate();
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void borrarEmployee(String employeeId) {
        try {
            String user = "root";
            String pass = "root";
            String url = "jdbc:mysql://127.0.0.1:3306/hr";

            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, user, pass);) {
                String sql = "DELETE FROM employees WHERE employee_id = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, employeeId);
                    pstmt.executeUpdate();
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
