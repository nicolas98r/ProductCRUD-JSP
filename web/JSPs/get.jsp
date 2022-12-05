<%-- 
    Document   : get
    Created on : 15-nov-2022, 1:29:01
    Author     : nico9
--%>


<%@page import="co.edu.udistrital.bankproducts.model.ProductDTO"%>
<%@page import="java.util.Iterator"%>
<%@page import="co.edu.udistrital.bankproducts.DAOs.ProductDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BankProducts</title>
    </head>
    <body>
        <div>
            <a href="ProductController?action=add"><h1>Añadir producto</h1></a>
            <table border="1">
                <thead>
                    <th>NÚMERO</th>
                    <th>TIPO</th>
                    <th>BALANCE</th>
                    <th>INTERES</th>
                    <th>FECHA CREACIÓN</th>
                    <th>FECHA EXPIRACIÓN</th>
                </thead>
                <% 
                    List<ProductDTO> list = (List<ProductDTO>)request.getAttribute("products");
                    Iterator<ProductDTO> iter = list.iterator();
                    ProductDTO product = null;
                    while (iter.hasNext()) {
                        product = iter.next();
                    
                %>
                <tbody>
                    <tr>
                       <td><%= product.getId() %></td>
                       <td><%= product.getType() %></td>
                       <td><%= product.getBalance() %></td>
                       <td><%= product.getInterest() %></td>
                       <td><%= product.getCreation() %></td>
                       <td><%= product.getExpiration() %></td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </body>
</html>
