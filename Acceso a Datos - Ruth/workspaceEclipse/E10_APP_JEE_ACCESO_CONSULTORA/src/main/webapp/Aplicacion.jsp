<%@page import="clases.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String userName = request.getParameter("nombre");
Integer numAccesos = (Integer) application.getAttribute("numAccesos");
List<Usuario> usuariosRegistrados = (ArrayList<Usuario>) application.getAttribute("usersList");

%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Datos Registro Desarrollo de Software</h1>
    <p><%=userName %> has accedido correctamente</p>
    <p>Nº de veces que se accede a la página de registro desde la aplicacion: <%=numAccesos %></p>
    <table border="1">
    	<tr>
    		<td>Usuarios Registrados</td>
    	</tr>
    	<%for (Usuario u:usuariosRegistrados){ %>
    	<tr>
			<td><%=u.getNombre() %></td> 
		</tr>
		<%}%>
    </table>
	<form action="Acceso.jsp">
		<input type="submit" name="boton" value="Acceso">
	</form>
</body>
</html>