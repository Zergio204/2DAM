<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="paquete.Votacion" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resultados de la Votación</title>
</head>
<body>
	<h1>Resultados</h1>
    <table border="1">
        <tr>
            <th>Nombre</th>
            <th>Número de Votos</th>
        </tr>
        <%
            Map<String, Votacion> resultados = (Map<String, Votacion>) request.getAttribute("resultados");
            for (Map.Entry<String, Votacion> entry : resultados.entrySet()) {
                String nombre = entry.getKey();
                int votos = entry.getValue().getVotos();
        %>
        <tr>
            <td><%= nombre %></td>
            <td><%= votos %></td>
        </tr>
        <%
            }
        %>
    </table>
    <form action="Votacion.jsp">
        <button type="submit">Volver</button>
    </form>
</body>
</html>