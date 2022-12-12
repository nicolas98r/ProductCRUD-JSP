<%-- 
    Document   : add_user
    Created on : 09-dic-2022, 12:38:43
    Author     : nico9
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BankProducts</title>
    </head>
    <body>
        <h1>Añadir cliente</h1>
         <form action="ClientController" method="POST">
            ID: <input type="text" name="id"><br>
            Nombre: <input type="text" name="firstName"><br>
            Apellido: <input type="text" name="lastName"><br>
            Email: <input type="text" name="email"><br>
            Username: <input type="text" name="username"><br>
            Password: <input type="password" name="password"><br>
            <input type="submit" name="action" value="Crear"/>
        </form>
    </body>
</html>
