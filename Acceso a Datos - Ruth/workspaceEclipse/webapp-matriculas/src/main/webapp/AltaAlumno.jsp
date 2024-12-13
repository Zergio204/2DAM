<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Alta de Alumno</title>
</head>
<body>
    <form action="ServletAlumno" method="post">
        <table border="2" align="center">
            <tr>
                <td align="center">ALTA DE ALUMNO</td>
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
                <td align="center"><input type="submit" name="boton" value="Alta" /></td>
            </tr>
        </table>
    </form>
    <br>
    <div align="center">
        <form action="ServletAlumno" method="post">
            <input type="submit" name="boton" value="Volver" />
        </form>
    </div>
</body>
</html>