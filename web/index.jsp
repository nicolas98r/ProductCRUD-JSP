<%-- 
    Document   : index
    Created on : 21/10/2022, 2:46:02 p. m.
    Author     : nixod
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BankProducts</title>
    </head>
    <body>
        <h1>Busqueda de Clientes:</h1>
        <form action="ProductController" method="GET">    
            Busqueda por id: <input type="text" name="id"><br>
            Busqueda por nombre y apellido <input type="text" name="name"><br>
            <input type="submit" name="action" value="Buscar"/>
            
        </form>
        
    </body>
</html>
