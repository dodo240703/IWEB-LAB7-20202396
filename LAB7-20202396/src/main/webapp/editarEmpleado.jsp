<%--
  Created by IntelliJ IDEA.
  User: doria
  Date: 5/06/2024
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="employee" type="com.example.practicandocrud.Beans.Employee" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Editar un empleado</title>
</head>
<body>
    <div class='container'>
        <h1 class='mb-3'>Editar un empleado</h1>
        <form method="post" action="<%=request.getContextPath()%>/EmployeeServlet?action=edit">
            <%
                String fullName = employee.getFullNameEmployee().trim();
                String[] names = fullName.split(" ");
                String firstName = names[0];
                String lastName = names[1] ;
            %>
            <div class="mb-3">
                <input type="hidden" class="form-control" name="employeId" value="<%=employee.getEmployeeId()%>">
            </div>
            <div class="mb-3">
                <label  class="form-label">Nombre</label>
                <input type="text" class="form-control" name="firstName" value="<%=firstName%>">
            </div>
            <div class="mb-3">
                <label  class="form-label">Apellido</label>
                <input type="text" class="form-control" name="lastName" value="<%=lastName%>">
            </div>
            <div class="mb-3">
                <label  class="form-label">Email</label>
                <input type="email" class="form-control" name="email" value="<%=employee.getEmailEmployee()%>">
            </div>
            <div class="mb-3">
                <label class="form-label">Número de teléfono</label>
                <input type="text" class="form-control" name="phoneNumber"  value="<%=employee.getPhoneEmployee()%>">
            </div>
            <div class="mb-3">
                <label  class="form-label">Hire date</label>
                <input type="date" class="form-control" name="hireDate" value="<%=employee.getHireDateEmployee()%>">
            </div>
            <div class="mb-3">
                <label  class="form-label">Job ID</label>
                <input type="text" class="form-control" name="jobId"  value="<%=employee.getJob_id()%>">
            </div>
            <div class="mb-3">
                <label  class="form-label">Salario</label>
                <input type="number" class="form-control" name="salary"  value="<%=employee.getSalaryEmployee()%>">
            </div>
            <div class="mb-3">
                <label  class="form-label">Comisión PCT</label>
                <input type="text" class="form-control" name="commissionPct"  value="<%=employee.getCommissionPctEmployee()%>">
            </div>
            <div class="mb-3">
                <label  class="form-label">Jefe ID</label>
                <input type="number" class="form-control" name="managerId"  value="<%=employee.getManangerId()%>">
            </div>
            <div class="mb-3">
                <label  class="form-label">Department ID</label>
                <input type="number" class="form-control" name="departmentId" value="<%=employee.getDepartmentId()%>">
            </div>
            <a href="<%=request.getContextPath()%>/EmployeeServlet" class="btn btn-danger">Regresar</a>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
            crossorigin="anonymous"></script>

</body>
</html>
