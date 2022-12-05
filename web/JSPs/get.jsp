<%-- 
    Document   : create_product
    Created on : 15-nov-2022, 1:29:01
    Author     : nico9
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.Iterator"%>
<%@page import="co.edu.udistrital.bankproducts.DAOs.ProductDAO"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.udistrital.bankproducts.model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <table border="1">
                <thead>
                    <th>NÚMERO</th>
                    <th>TIPO</th>
                    <th>CATEGORÍA</th>
                    <th>INTERES</th>
                </thead>
                <% 
                    List<Account> list = (List<Account>)request.getAttribute("accounts");
                    Iterator<Account> iter = list.iterator();
                    Account acco= null;
                    while (iter.hasNext()) {
                        acco = iter.next();
                    
                %>
                <tbody>
                    <tr>
                        <td><%= acco.getId() %></td>
                        <td><%= acco.getType() %></td>
                        <td><%= acco.getCategory() %></td>
                        <td><%= acco.getName() %></td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </body>
</html>
