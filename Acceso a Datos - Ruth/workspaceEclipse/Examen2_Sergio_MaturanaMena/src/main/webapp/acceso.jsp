<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ServletController" method="post">
    <fieldset>
        <legend>
            <h1 style="color: green">MERCHANDISHING GF</h1>
        </legend>
        <table>
            <tr>
                <td><label>Nombre:</label></td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td><label>Password:</label></td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td><label>Perfil:</label></td>
                <td><select name="profile">
                    <option>Administrador</option>
                </select></td>
            </tr>
            <tr>
                <td><input type="submit" name="action" value="Acceso"></td>
                <td><input type="submit" name="action" value="Salir"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>