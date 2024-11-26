<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ServletPersona" method="post">
        DNI/NIF: <input type="text" name="dni"><br>
        Nombre: <input type="text" name="nombre"><br>
        Apellidos: <input type="text" name="apellidos"><br>
        Dirección: <input type="text" name="direccion"><br>
        Teléfono: <input type="text" name="telefono"><br>
        Correo: <input type="email" name="correo"><br>
        <input type="submit" value="Enviar">
    </form>
</body>
</html>