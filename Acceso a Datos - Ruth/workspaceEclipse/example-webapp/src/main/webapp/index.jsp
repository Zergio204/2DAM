<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Página Principal</title>
</head>
	<body>
		<h1>Página Principal</h1>
		<p>Número: <%= Integer.parseInt(request.getParameter("name")) %></p>
	</body>
</html>