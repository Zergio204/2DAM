<%@page import="Clases.Producto"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tienda Merchandising GF</title>
</head>
<body>
    <form action="ServletController" method="post">
        <fieldset>
            <legend>
                <h1 style="color: green">MERCHANDISHING GF</h1>
                <input type="submit" name="action" value="Login">
            </legend>
            <h2>Bienvenido/a a la tienda del Gregorio Fernández.</h2>
            <h3>En el día de hoy se han realizado: <%= getServletContext().getAttribute("dailyPurchases") %> compra/s.</h3>
            <p>Seleccione los artículos que desee comprar. Recuerde que solo se permite una única unidad por artículo para cada miembro de la comunidad.</p>
            <table border="1">
                <tr>
                    <td>Ref.</td>
                    <td>Descripción</td>
                    <td>Precio</td>
                </tr>
                <% 
                   List<Producto> productos = (List<Producto>) getServletContext().getAttribute("productos");
                   if (productos != null) {
                       for (Producto producto : productos) {
                %>
                <tr>
                    <td><input type="checkbox" name="productRef" value="<%= producto.getRef() %>"/></td>
                    <td><%= producto.getDescripcion() %></td>
                    <td><%= producto.getPrecio() %> €</td>
                </tr>
                <%   }
                   }
                %>
                <tr>
                    <td colspan="3" align="center"><input type="submit" name="action" value="Ver Cesta"></td>
                </tr>
            </table>
        </fieldset>
    </form>
</body>
</html>