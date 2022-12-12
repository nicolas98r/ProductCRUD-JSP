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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    </head>
    <body>
        <div class="container mt-4 col-lg-4">
            <div class="card col-sm-10">
                <div class="card-body">
                    <form action="ClientController" method="POST" class="form-sign">
                        <div class ="form-group text-center">
                            <h3>Iniciar Sesión</h3> 
                        </div>
                        <div class ="form-group">
                            <label>Usuario:</label>
                            <input type="text" name="username" class="form-control">
                        </div>
                        <div class ="form-group">
                            <label>Contraseña:</label>
                            <input type="password" name="password" class="form-control">
                        </div>
                        <input type="submit" name="action" value ="Ingresar" class="btn btn-primary">
                    </form>
                </div>
            </div>
        </div>

        <!-- Scripts Bootstrap -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
    </body>
</html>
