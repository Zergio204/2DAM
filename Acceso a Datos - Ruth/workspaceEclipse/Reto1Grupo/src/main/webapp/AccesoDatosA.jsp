<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="/Error.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Datos</title>
	</head>
	
	<body>
	
	<%List<String[]> data = (List<String[]>) request.getAttribute("data");%>
	
		<h1>DATOS</h1>
		
		<table border = "1">
			<%for(String[] dato : data){ %>
			
			<tr>
				<td>DATO 1</td>
			</tr>
			<tr>
				<td>Dato 1</td>
			</tr>
			
			
			<%} %>
			
		</table>
	</body>
</html>