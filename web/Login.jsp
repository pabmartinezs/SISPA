<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Login</title>
        <link href="Recursos/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="Recursos/css/bootstrap.css" rel="stylesheet" media="screen"> 
    </head>
    <body>
        <%--Header--%>
        <div class="container">
            <div class="text-center">
                <img src="Recursos/imagen/banner-home-2.jpg">
            </div>
        </div> 
        <%--Fín Header--%>
        
        <div class="container">
            <div class="col-lg-4"></div>
            <div class="text-center">
                <div class="col-lg-4">
                    <h3><b>Login</b></h3>
                </div>
            </div>
        </div> 
        
        <section class="container">
            <div class="col-lg-4"></div>
            <form name="formLogin" method="post" action="./validarUsuarioServlet" role="form" class="col-lg-4">
                <div class="form-group">
                    <label>Username:</label>                    
                    <input type="text" class="form-control" name="txtUsername" required/>
                </div>                  
                <div class="form-group">  
                    <label>Password:</label>                    
                    <input type="password" class="form-control" name="txtPass" required/>
                </div>                                             
                <div class="form-group">              
                    <a href="Registro.jsp">No tienes una cuenta? registrate aquí</a>
                </div>                                             
                <div class="form-group">
                    <input class="form-group" id="enviar" value="Ingresar" type="submit" onclick="this.form.txtPass.value = MD5(this.form.txtPass.value)"/>
                </div>                    

            </form>
            
        </section>

        <div class="text-center">
            <div class="col-lg-4"></div>
            <div class="col-lg-4" style="color: red">
                <c:if test="${sessionScope.MsgError!=null}">
                    <c:out value="${MsgError}"></c:out>
                    <c:remove var="MsgError"></c:remove>
                        <a href=""></a>
                </c:if>
            </div>
        </div>
        
        <%--Footer--%>
        <div class="navbar navbar-inverse navbar-fixed-bottom" style="background: #154360" role="navigation">
            <div class="container">
                <div class="text-center" >
                    <br/>
                    <p style="color: white">© Copyright DuocUC 2017 <img src="Recursos/imagen/logo-footer.png"></p>
                </div>                
            </div>
        </div>
        <%--Fín Footer--%>
        <script type="text/javascript" src="Recursos/js/MD5.js"></script>
        <script src="Recursos/js/jquery-3.1.0.min.js"></script>
        <script src="Recursos/js/bootstrap.min.js"></script>
        <script src="Recursos/js/bootstrap.js"></script>
    </body>
</html>
