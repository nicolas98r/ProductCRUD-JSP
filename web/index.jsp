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
        <h1>LOGIN</h1>
        <form action="ProductController" method="GET">    
            User: <input type="text" name="user">
            Password <input type="password" name="password">
            <input type="submit" name="action" value="Ingresar" />
            
        </form>
        
    </body>
</html>
