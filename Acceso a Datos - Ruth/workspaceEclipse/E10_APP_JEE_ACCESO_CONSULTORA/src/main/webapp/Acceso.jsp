<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.HashMap" %>
<%@page import="java.util.Map" %>
<%@page import="clases.Usuario" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%
Map<String,String> mapaCategoria = (HashMap<String,String>)application.getAttribute("mapaCategoria");
Usuario user = (Usuario)request.getAttribute("usuario");

%>

<body>
	<form action="ServletUsuario" method="post">
    	<h1>Datos registro desarrollo de Software</h1>
	    <table>
	    	<tr>
	    	    <td>Nombre</td>
	    	    <td><input type="text" name="nombre"/></td>
	    	</tr>
			<tr>
				<td>Contraseña</td>
				<td><input type="password" name="contrasena" /></td>
			</tr>
			<tr>
				<td>Elegir Perfil</td>
				<td>
					<%
					for (String key : mapaCategoria.keySet()) {
						if(key.contains(user.getCategoria())){%> 
							<option value=<%=key %>><%=mapaCategoria.get(key) %></option>
					<%	}
					}
					%>
				</td>
			</tr>
			<tr>
				<td><input type="submit" name="boton" value="Registro"></td>
			</tr>
			<tr>
				<td><%=session.getAttribute("datosSesion") %></td>
			</tr>
		</table>
	
    </form>
</body>
</html>