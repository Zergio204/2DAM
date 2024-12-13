<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menú Principal</title>
</head>
<body>
    <form action="ServletAlumno" method="get">
        <table border="2" align="center">
            <tr>
                <td colspan="4" align="center">GESTIÓN MATRÍCULAS</td>
            </tr>
            <tr>
                <td><input type="submit" name="boton" value="Alta" /></td>
                <td><input type="submit" name="boton" value="Baja" /></td>
                <td><input type="submit" name="boton" value="Actualiza" /></td>
                <td><input type="submit" name="boton" value="Consulta" /></td>
            </tr>
        </table>
    </form>
</body>
</html>