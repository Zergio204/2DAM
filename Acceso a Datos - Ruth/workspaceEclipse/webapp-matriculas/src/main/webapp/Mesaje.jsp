<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mensaje del Sistema</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f0f0f0;
        }
        .message-container {
            background-color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0,0,0,0.1);
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="message-container">
        <h2>Resultado de la Operación</h2>
        <p><%= request.getAttribute("mensaje") != null ? request.getAttribute("mensaje") : "No hay mensaje" %></p>
        <br>
        <form action="ServletAlumno" method="get">
            <input type="submit" name="boton" value="Menu" />
        </form>
    </div>
</body>
</html>