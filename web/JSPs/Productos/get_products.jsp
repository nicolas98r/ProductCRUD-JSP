<%-- 
    Document   : get
    Created on : 15-nov-2022, 1:29:01
    Author     : nico9
--%>


<%@page import="co.edu.udistrital.bankproducts.model.ProductDTO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BankProducts</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    </head>
    <body>
        <div class="col-sm-10">
            <h2>Lista de Productos</h2>
            <a class="btn btn-success" href="ProductController?menu=Productos&action=add">Añadir producto</a>
            <table class="table table-hover">
                <thead>
                <th>NÚMERO</th>
                <th>TIPO</th>
                <th>BALANCE</th>
                <th>INTERES</th>
                <th>FECHA CREACIÓN</th>
                <th>FECHA EXPIRACIÓN</th>
                <th>OPCIONES</th>
                </thead>
                <% 
                    List<ProductDTO> list = (List<ProductDTO>) request.getAttribute("products");
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
                       <td>
                           <a class="btn btn-warning" href="ProductController?menu=Productos&action=add">Editar</a>
                           <a class="btn btn-danger" href="ProductController?menu=Productos&action=add">Borrar</a>
                       </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>

        </div>
    </body>
</html>
