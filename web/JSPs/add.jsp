<%-- 
    Document   : add
    Created on : 04-dic-2022, 19:24:08
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
        <h1>Añadir productos</h1>
         <form action="ProductController" method="POST">
            ID: <input type="number" name="id"><br>
            Tipo: <select name="type">
                    <option value="1" selected>Cuenta Corriente</option>
                    <option value="2">Seguro Automotriz</option>
                    <option value="3">Cuenta Ahorros</option>
                    <option value="4">Crédito Consumo</option>
                    <option value="5">Crédito Hipotecario</option>
                    <option value="6">Tarjeta Gold</option>
                    <option value="7">Tarjeta Platinum</option>
                    <option value="8">Tarjeta Infinite</option>
                </select><br>
            Balance: <input type="number" name="balance"><br>
            Interes <input type="number" name="interest"><br>
            Fecha de Creación: <input type="date" id="creation" name="creation"
        value="2019-11-22"
       min="2016-01-01" max="2024-12-31"><br>
            Fecha de Expiración <input type="date" id="expiration" name="expiration"
        value="2019-11-22"
       min="2016-01-01" max="2024-12-31"><br>
            <input type="submit" name="action" value="submit" />
        </form>
    </body>
</html>
