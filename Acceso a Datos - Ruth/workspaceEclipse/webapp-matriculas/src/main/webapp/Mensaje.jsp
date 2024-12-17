<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mensaje del Sistema</title>
</head>
<body>
    <h2>Resultado de la Operación</h2>
    <p><%= request.getAttribute("mensaje") != null ? request.getAttribute("mensaje") : "No hay mensaje" %></p>
    <br>
    <form action="ServletAlumno" method="get">
        <input type="submit" name="boton" value="Menu" />
    </form>
</body>
</html>