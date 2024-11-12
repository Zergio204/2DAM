<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Alta de Incidencias</h2>
    <form action="ServletIncidencia" method="post">
        <label for="tema">Tema:</label>
        <input type="text" id="tema" name="tema" required><br><br>
        <label for="descripcion">Descripción:</label>
        <input type="text" id="descripcion" name="descripcion" required><br><br>
        <input type="submit" value="Confirmar">
        <input type="button" value="Consultar">
    </form>
    <%
        String mensajeError = (String) request.getAttribute("mensajeError");
        if (mensajeError != null) {
            out.println("<p style='color:red;'>" + mensajeError + "</p>");
        }
    %>
</body>
</html>