<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="servlets.Persona"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%Persona p = (Persona) request.getAttribute("persona"); %>
	
    DNI/NIF: <input type="text" value="<%=p.getDni() %>" disabled><br>
    Nombre: <input type="text" value="<%=p.getNombre()%>" disabled><br>
    Apellidos: <input type="text" value="<%=p.getApellidos() %>" disabled><br>
    Dirección: <input type="text" value="<%=p.getDireccion() %>" disabled><br>
    Teléfono: <input type="text" value="<%=p.getTelefono() %>" disabled><br>
    Correo: <input type="text" value="<%=p.getCorreo() %>" disabled><br>
    <form action="RecogidaPersona.jsp">
        <input type="submit" value="Volver">
    </form>
</body>
</html>