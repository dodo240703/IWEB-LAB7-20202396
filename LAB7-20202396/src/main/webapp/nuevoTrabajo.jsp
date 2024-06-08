<%--
  Created by IntelliJ IDEA.
  User: doria
  Date: 2/06/2024
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Crear un nuevo trabajo</title>
</head>
<body>
    <div class="container">
        <h1 class="mb-3">Crear un nuevo trabajo</h1>
        <form method="POST" action="<%=request.getContextPath()%>/JobServlet?action=crear">
            <div class="mb-3">
                <label for="jobId" class="form-label">Job ID</label>
                <input type="text" class="form-control" name="jobId" id="jobId">
            </div>
            <div class="mb-3">
                <label for="jobTitle" class="form-label">Job Title</label>
                <input type="text" class="form-control" name="jobTitle" id="jobTitle">
            </div>
            <div class="mb-3">
                <label for="minSalary" class="form-label">Min Salarye</label>
                <input type="text" class="form-control" name="minSalary" id="minSalary">
            </div>
            <div class="mb-3">
                <label for="maxSalary" class="form-label">Max Salarye</label>
                <input type="text" class="form-control" name="maxSalary" id="maxSalary">
            </div>
            <a href="<%=request.getContextPath()%>/JobServlet" class="btn btn-danger">Regresar</a>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>

    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"></script>
</body>
</html>
