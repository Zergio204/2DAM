<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Alta de Incidencia</h2>
    <form action="ServletIncidencia" method="post">
        <label>Tema:</label><br>
        <input type="text" name="tema"><br><br>

        <label>Descripción:</label><br>
        <input type="text" name="descripcion"><br><br>

        <input type="submit" value="Confirmar"/>
    </form>

    <form action="ConsultaIncidencia.jsp" method="get">
        <input type="submit" value="Consultar"/>
    </form>

    <%
        String error = (String) request.getAttribute("error");
        if (error != null) {
    %>
    <p style="color:red;"><%= error %></p>
    <%
        }
    %>
</body>
</html>