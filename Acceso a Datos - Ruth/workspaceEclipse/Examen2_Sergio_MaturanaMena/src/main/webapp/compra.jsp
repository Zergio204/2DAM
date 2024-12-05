<%@page import="Clases.Producto"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Carrito</title>
</head>
<body>
    <h1>Carrito de Compras</h1>
    <% 
       List<Producto> carrito = (List<Producto>) session.getAttribute("carrito");
       if (carrito == null || carrito.isEmpty()) {
    %>
        <p>No hay artículos en el carrito.</p>
    <% 
       } else { 
           double total = 0;
    %>
        <ul>
            <% for (Producto producto : carrito) { 
                   total += producto.getPrecio(); 
            %>
                <li><%= producto.getDescripcion() %> - <%= producto.getPrecio() %> €</li>
            <% } %>
        </ul>
        <p>Total: <%= total %> €</p>
        <form action="ServletController" method="post">
            <button name="action" value="checkout">Finalizar Compra</button>
        </form>
    <% } %>
    <a href="index.jsp">Volver a la tienda</a>
</body>
</html>

