<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resultados de la Votación</title>
</head>
<body>
	<h1>RESULTADOS DE LA VOTACIÓN</h1>
	<p>Los resultados de la votación son...</p>
	<p>
		El candidato elegido es:
		<%=request.getAttribute("candidato")%></p>
	<p>
		El número de votos recibidos es:
		<%=request.getAttribute("votos")%></p>
	<p>Gracias por participar en la votación</p>
</body>
</html>