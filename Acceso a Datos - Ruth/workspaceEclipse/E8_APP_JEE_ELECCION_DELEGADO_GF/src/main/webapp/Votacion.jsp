<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Elección de Delegado</title>
</head>
<body>
	<h1>ELECCION DE DELEGADO</h1>
    <form action="ServletVotacion" method="post">
        <p>Los delegados que se presentan a miembros del Consejo Escolar son...</p>
        <input type="checkbox" name="candidato" value="Ruth Fernandez"> Ruth Fernandez<br>
        <input type="checkbox" name="candidato" value="Victor Vergel"> Victor Vergel<br>
        <input type="submit" value="Enviar">
    </form>	
</body>
</html>