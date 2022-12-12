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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    </head>
    <body>
        <div class="d-flex">
            <div class="card">
                <h2>Añadir productos</h2>
                <div class="card-body">
                    <form action="ProductController" method="POST">
                        <div class="form-group">
                            <label>ID</label>
                            <input type="text" name="id" class ="form-control">
                        </div>
                        <div class="form-group">
                            <label>Tipo</label>
                            <select name="type" class="form-select">
                                <option value="1" selected>Cuenta Corriente</option>
                                <option value="2">Seguro Automotriz</option>
                                <option value="3">Cuenta Ahorros</option>
                                <option value="4">Crédito Consumo</option>
                                <option value="5">Crédito Hipotecario</option>
                                <option value="6">Tarjeta Gold</option>
                                <option value="7">Tarjeta Platinum</option>
                                <option value="8">Tarjeta Infinite</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Balance</label>
                            <input type="text" name="balance" class ="form-control">
                        </div>
                        <div class="form-group">
                            <label>Interes</label>
                            <input type="text" name="interest" class ="form-control">
                        </div>
                        <div class="form-group">
                            <label>Fecha de creación</label>
                            <input type="date" id="creation" name="creation"
                                   value="2019-11-22"
                                   min="2016-01-01" max="2024-12-31">
                        </div>
                        <div class="form-group">
                            <label>Fecha de expiración</label>
                            <input type="date" id="creation" name="expiration"
                                   value="2019-11-22"
                                   min="2016-01-01" max="2024-12-31">
                        </div>
                        <input class="btn btn-primary" type="submit" name="action" value="Crear"/>
                    </form>
                </div>

            </div>
        </div>
    </form>
    <!-- Scripts Bootstrap -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
</body>
</html>
