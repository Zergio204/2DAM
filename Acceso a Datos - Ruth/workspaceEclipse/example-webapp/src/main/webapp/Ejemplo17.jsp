<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>

<%Integer accesos = (Integer) session.getAttribute("accesos");
if(accesos==null){
    accesos=0;
}
accesos = accesos.intValue() + 1;
session.setAttribute("accesos", accesos);
if(request.getParameter("invalidaSesion")!=null){
	session.invalidate();
	accesos = accesos - 1;
}

%>

<html>
<head>
<meta charset="UTF-8">
<title>EJEMPLO 17</title>
</head>
<body>
	<form>
		<input type="submit" name="invalidaSesion" value="Invalida Sesion"/>
		<input type="submit" name="recargarPage" value="Recarga Página"/>
	</form>
	<br>
	<p>Numero de accesos: <%=accesos %></p>
</body>
</html>