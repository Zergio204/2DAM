<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
	<%@ page import="paqueteServlet.Incidencia" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Listado de Incidencias</h2>

    <%
        List<Incidencia> incidencias = (List<Incidencia>) getServletContext().getAttribute("incidencias");
        if (incidencias == null || incidencias.isEmpty()) {
    %>
    <p>No hay incidencias registradas.</p>
    <%
        } else {
    %>
    <table border="1">
        <tr>
            <th>Código</th>
            <th>Tema</th>
            <th>Descripción</th>
        </tr>
        <%
            for (Incidencia incidencia : incidencias) {
        %>
        <tr>
            <td><%= incidencia.getCodigo() %></td>
            <td><%= incidencia.getTema() %></td>
            <td><%= incidencia.getDescripcion() %></td>
        </tr>
        <%
            }
        %>
    </table>
    <%
        }
    %>

    <form action="AltaIncidencia.jsp" method="get">
        <button type="submit">Volver</button>
    </form>
</body>
</html>