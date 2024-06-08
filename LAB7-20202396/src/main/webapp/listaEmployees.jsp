<%@ page import="com.example.practicandocrud.Beans.Employee" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: doria
  Date: 5/06/2024
  Time: 01:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    ArrayList<Employee> listaEmployees = (ArrayList<Employee>) request.getAttribute("lista");
%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Lista de Empleados</title>
</head>
<body>
    <div class='container '>
        <h1 class='mb-3'>Lista de empleados en hr</h1>
        <a class="mb-3 btn btn-primary" href="<%=request.getContextPath()%>/EmployeeServlet?action=formCrear">Crear Employee</a>
        <br>
        <a class="mb-3" href="${pageContext.request.contextPath}/JobServlet">Ir a la lista de trabajos</a>
        <table class="table table-responsive table-bordered ">
            <tr class="table-primary">
                <th>Employee ID</th>
                <th>Empleado</th>
                <th>Email</th>
                <th>Número de teléfono</th>
                <th>Hire date</th>
                <th>Job ID</th>
                <th>Salario</th>
                <th>Comisión PCT</th>
                <th>Mananger ID</th>
                <th>Department ID</th>
                <th></th>
                <th></th>
            </tr>
            <% for (Employee employee : listaEmployees) { %>
            <tr>
                <td><%=employee.getEmployeeId()%></td>
                <td><%=employee.getFullNameEmployee()%></td>
                <td><%=employee.getEmailEmployee()%></td>
                <td><%=employee.getPhoneEmployee()%></td>
                <td><%=employee.getHireDateEmployee()%></td>
                <td><%=employee.getJob_id()%></td>
                <td><%=employee.getSalaryEmployee()%></td>
                <td><%=employee.getCommissionPctEmployee()%></td>
                <td><%=employee.getManangerId()%></td>
                <td><%=employee.getDepartmentId()%></td>
                <td><a href="<%=request.getContextPath()%>/EmployeeServlet?action=editar&id=<%=employee.getEmployeeId()%>" class="btn btn-primary btn-sm">Editar</a></td>
                <td><a href="<%=request.getContextPath()%>/EmployeeServlet?action=borrar&id=<%=employee.getEmployeeId()%>" class="btn btn-danger btn-sm">Borrar</a> </td>
            </tr>
            <%  }  %>
        </table>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>

</body>
</html>
