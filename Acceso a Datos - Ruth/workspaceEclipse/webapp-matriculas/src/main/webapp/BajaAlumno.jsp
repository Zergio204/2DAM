<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Baja de Alumno</title>
</head>
<body>
    <form action="ServletAlumno" method="post">
        <table border="2" align="center">
            <tr>
                <td align="center">BAJA DE ALUMNO</td>
            </tr>
            <tr>
                <td>
                    <p align="left">Nombre: <input type="text" name="nombre" required /></p>
                    <p align="left">Apellidos: <input type="text" name="apellidos" required /></p>
                    <p align="left">Ciclo: <input type="text" name="ciclo" required /></p>
                    <p align="left">Curso: <input type="text" name="curso" required /></p>
                </td>
            </tr>
            <tr>
                <td align="center"><input type="submit" name="boton" value="Baja" /></td>
            </tr>
        </table>
    </form>
    <br>
    <div align="center">
        <a href="index.jsp">Volver al inicio</a>
    </div>
</body>
</html>