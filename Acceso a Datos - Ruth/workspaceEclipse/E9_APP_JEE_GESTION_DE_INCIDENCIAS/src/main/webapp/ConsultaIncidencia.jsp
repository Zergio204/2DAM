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
    <table border="1">
        <tr>
            <th>Código</th>
            <th>Tema</th>
            <th>Descripción</th>
        </tr>
        <%
            List<Incidencia> incidencias = (List<Incidencia>) request.getAttribute("incidencias");
            if (incidencias != null) {
                for (Incidencia incidencia : incidencias) {
                    out.println("<tr>");
                    out.println("<td>" + incidencia.getCodigo() + "</td>");
                    out.println("<td>" + incidencia.getTema() + "</td>");
                    out.println("<td>" + incidencia.getDescripcion() + "</td>");
                    out.println("</tr>");
                }
            }
        %>
    </table>
    <br>
    <input type="button" value="Volver" onclick="window.location.href='AltaIncidencia.jsp'">
</body>
</html>