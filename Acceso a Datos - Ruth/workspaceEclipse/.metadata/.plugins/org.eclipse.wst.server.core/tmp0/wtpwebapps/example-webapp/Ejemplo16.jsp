<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- EJEMPLO 16 VISTO -->
<%--EJEMPLO 16 NO VISTO DESDE EL CLIENTE --%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!int numero=0; %>
	<%!public String fecha(){
		return new Date().toString();
		}%>
		<h1>TABLA CONTADOR</h1>
		<table border="1">
			<%for(int i=numero; i<numero+10;i++){ %>
		<tr>
			<td>Numero</td>
			<td><%=i %></td>
			<%} %>
	    </tr>
	</table>
	<p>La fecha actual es: <%=fecha() %></p>
</body>
</html>