<%--
  Created by IntelliJ IDEA.
  User: doria
  Date: 5/06/2024
  Time: 01:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Crear un nuevo empleado</title>
</head>
<body>
    <div class="container">
        <h1 class="mb-3">Crear un nuevo empleado</h1>
        <form method="POST" action="<%=request.getContextPath()%>/EmployeeServlet?action=crear">
            <div class="mb-3">
                <label for="firstName" class="form-label">Nombre</label>
                <input type="text" class="form-control" name="firstName" id="firstName">
            </div>
            <div class="mb-3">
                <label for="lastName" class="form-label">Apellido</label>
                <input type="text" class="form-control" name="lastName" id="lastName">
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" name="email" id="email">
            </div>
            <div class="mb-3">
                <label for="phoneNumber" class="form-label">Número de teléfono</label>
                <input type="text" class="form-control" name="phoneNumber" id="phoneNumber">
            </div>
            <div class="mb-3">
                <label for="hireDate" class="form-label">Hire date</label>
                <input type="date" class="form-control" name="hireDate" id="hireDate">
            </div>
            <div class="mb-3">
                <label for="jobId" class="form-label">Job ID</label>
                <input type="text" class="form-control" name="jobId" id="jobId">
            </div>
            <div class="mb-3">
                <label for="salary" class="form-label">Salario</label>
                <input type="number" class="form-control" name="salary" id="salary">
            </div>
            <div class="mb-3">
                <label for="commissionPct" class="form-label">Comisión PCT</label>
                <input type="text" class="form-control" name="commissionPct" id="commissionPct">
            </div>
            <div class="mb-3">
                <label for="managerId" class="form-label">Jefe ID</label>
                <input type="number" class="form-control" name="managerId" id="managerId">
            </div>
            <div class="mb-3">
                <label for="departmentId" class="form-label">Department ID</label>
                <input type="number" class="form-control" name="departmentId" id="departmentId">
            </div>


            <a href="<%=request.getContextPath()%>/EmployeeServlet" class="btn btn-danger">Regresar</a>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>

    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"></script>

</body>
</html>
