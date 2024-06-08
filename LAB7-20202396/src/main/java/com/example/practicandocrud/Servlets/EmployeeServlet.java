package com.example.practicandocrud.Servlets;

import com.example.practicandocrud.Beans.Employee;
import com.example.practicandocrud.Daos.EmployeeDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

@WebServlet(name = "EmployeeServlet",value = {"/EmployeeServlet","/home"})
public class EmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");
        EmployeeDao employeeDao = new EmployeeDao();
        RequestDispatcher view;

        switch (action) {
            case "lista":
                ArrayList<Employee> listaEmployees = employeeDao.obtenerListaEmployee();
                request.setAttribute("lista", listaEmployees);

                view = request.getRequestDispatcher("listaEmployees.jsp");
                view.forward(request, response);
                break;
            case "formCrear":
                view = request.getRequestDispatcher("nuevoEmployee.jsp");
                view.forward(request, response);
                break;
            case "editar":
                String employeeId = request.getParameter("id");
                Employee employee = employeeDao.obtenerEmployee(employeeId);
                if(employee == null){
                    response.sendRedirect(request.getContextPath() + "/EmployeeServlet");
                }else{
                    request.setAttribute("employee",employee);
                    view = request.getRequestDispatcher("editarEmpleado.jsp");
                    view.forward(request, response);
                }
                break;

            case "borrar":
                String idd = request.getParameter("id");
                if(employeeDao.obtenerEmployee(idd) != null){
                    employeeDao.borrarEmployee(idd);
                }
                response.sendRedirect(request.getContextPath() + "/EmployeeServlet");
                break;
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");
        EmployeeDao employeeDao = new EmployeeDao();
        RequestDispatcher view;

        switch(action) {
            case "crear":
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String email = request.getParameter("email");
                String phoneNumber = request.getParameter("phoneNumber");
                Date hireDate = Date.valueOf(request.getParameter("hireDate"));
                String jobId = request.getParameter("jobId");
                double salary = Double.parseDouble(request.getParameter("salary"));
                double commissionPct = Double.parseDouble(request.getParameter("commissionPct"));
                int managerId = Integer.parseInt(request.getParameter("managerId"));
                int departmentId = Integer.parseInt(request.getParameter("departmentId"));

                Employee newEmployee = new Employee();
                newEmployee.setFullNameEmployee(firstName + " " + lastName);
                newEmployee.setEmailEmployee(email);
                newEmployee.setPhoneEmployee(phoneNumber);
                newEmployee.setHireDateEmployee(hireDate);
                newEmployee.setJob_id(jobId);
                newEmployee.setSalaryEmployee(salary);
                newEmployee.setCommissionPctEmployee(commissionPct);
                newEmployee.setManangerId(managerId);
                newEmployee.setDepartmentId(departmentId);

                employeeDao.crearEmployee(newEmployee);

                response.sendRedirect(request.getContextPath() + "/EmployeeServlet");

                break;
            case "edit":
                String employeeId2 = request.getParameter("employeId");
                String firstName2 = request.getParameter("firstName");
                String lastName2 = request.getParameter("lastName");
                String email2 = request.getParameter("email");
                String phoneNumber2 = request.getParameter("phoneNumber");
                Date hireDate2 = Date.valueOf(request.getParameter("hireDate"));
                String jobId2 = request.getParameter("jobId");
                String salary2 = request.getParameter("salary");
                String commissionPct2 = request.getParameter("commissionPct");
                String managerId2 = request.getParameter("managerId");
                String departmentId2 = request.getParameter("departmentId");

                Employee employee2 = new Employee();

                employee2.setEmployeeId(Integer.parseInt(employeeId2));
                employee2.setFullNameEmployee(firstName2 + " " + lastName2);
                employee2.setEmailEmployee(email2);
                employee2.setPhoneEmployee(phoneNumber2);
                employee2.setHireDateEmployee(hireDate2);
                employee2.setJob_id(jobId2);
                employee2.setSalaryEmployee(Double.parseDouble(salary2));
                employee2.setCommissionPctEmployee(Double.parseDouble(commissionPct2));
                employee2.setManangerId(Integer.parseInt(managerId2));
                employee2.setDepartmentId(Integer.parseInt(departmentId2));



                employeeDao.actualizarEmployee(employee2);
                response.sendRedirect(request.getContextPath() + "/EmployeeServlet");

                break;


        }
    }

}
