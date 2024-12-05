<%@page import="Clases.Producto"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Gestión de Productos</title>
</head>
<body>
    <h1>Gestión de Productos</h1>
    <form action="ServletController" method="post">
        <table border="1">
            <thead>
            <tr>
                <th>Referencia</th>
                <th>Descripción</th>
                <th>Precio</th>
            </tr>
            </thead>
            <tbody>
            <% 
               List<Producto> productos = (List<Producto>) application.getAttribute("productos");
               if (productos != null) {
                   for (Producto producto : productos) {
            %>
                <tr>
                    <td><%= producto.getRef() %></td>
                    <td><input type="text" name="descripcion-<%= producto.getRef() %>" value="<%= producto.getDescripcion() %>"></td>
                    <td><input type="text" name="precio-<%= producto.getRef() %>" value="<%= producto.getPrecio() %>"></td>
                </tr>
            <% 
                   } 
               }
            %>
            </tbody>
        </table>
        <button type="submit" name="action" value="updateProducts">Actualizar</button>
    </form>
    <a href="index.jsp">Salir</a>
</body>
</html>