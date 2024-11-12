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
        <label><input type="checkbox" name="candidato" value="Ruth Fernández"> Ruth Fernández</label><br>
        <label><input type="checkbox" name="candidato" value="Víctor Vergel"> Víctor Vergel</label><br>
        <button type="submit">Enviar</button>
    </form>
</body>
</html>