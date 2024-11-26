<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
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
				<td>Categoría Profesional</td>
				<td>
					<input type="radio" name="categoria" value="C1" checked="checked">I
					<input type="radio" name="categoria" value="C2">II
					<input type="radio" name="categoria" value="C3">III
				</td>
			</tr>
			<tr>
				<td><input type="submit" name="boton" value="Registro"></td>
			</tr>
		</table>
	
    </form>
    
    <%if (request.getAttribute("sinDatos")!=null){%>
		<h4 style="color: red">(*) El nombre de ususario y contraseña no pueden estar vacios.</h4>
	<%
	}
	%>
	
</body>
</html>