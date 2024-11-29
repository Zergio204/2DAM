<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ServletAlumno" method="post">
		<table border="2">
			<tr>
				<td>GESTIÓN MATRÍCULAS</td>
			</tr>
			<tr>
				<td>
					<p align="left">Nombre: <input type="text" name="nombre" required/> </p>
					<p align="left">Apellidos: <input type="text" name="apellidos" required/> </p>
					<p align="left">Ciclo: <input type="text" name="ciclo" required/> </p>
					<p align="left">Curso: <input type="text" name="curso" required/> </p>
				</td>
			</tr>
			<tr>
				<td><input type="submit" name="boton" value="Alta"/></td>
			</tr>
		</table>
	
	</form>
</body>
</html>