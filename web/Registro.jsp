<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Registro</title>
        <link href="Recursos/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="Recursos/css/bootstrap.css" rel="stylesheet" media="screen">  
        <link href="Recursos/css/bootstrap-grid.min.css" rel="stylesheet" media="screen">        

    </head>
    <body style="background: #000\9">
        <%--Header--%>
        <div class="container">
            <div class="text-center">
                <img src="Recursos/imagen/banner-home-2.jpg">
            </div>
        </div> 
        <%--Fín Header--%>
        
        <br/>
        <div class="container">
            <div class="col-lg-4"></div>
            <div class="text-center">
                <div class="col-lg-4">
                    <h4 style="color: #0074d9"><b>Formulario de registro de cuenta nueva</b></h4>
                </div>
            </div>
        </div> 
        <br/>
        
        <section class="container">
            <div class="col-lg-4"></div>
            <form name="frm" method="post" action="./clienteRegistrarCuentaServlet" role="form" class="col-lg-4 pure-form">
                <div class="form-group">                   
                    <input type="text" class="form-control"  placeholder="Ingrese Nombre" name="txtNombre" required/>
                </div>                                             
                <div class="form-group">                   
                    <input type="text" class="form-control"  placeholder="Ingrese Apellido" name="txtApellido" required/>
                </div>
                <div class="form-group">                    
                    <input type="text" class="form-control" name="txtRUN" oninput="checkRut(this)" placeholder="Ingrese R.U.N." required/>
                    <script src="Recursos/js/ValidaRUN.js"></script> 
                </div>   
                <div class="form-group">                   
                    <input type="text" class="form-control" placeholder="Ingrese Dirección" name="txtDomicilio" required/>
                </div>
                <div class="form-group">                   
                    <input type="number" class="form-control" placeholder="Ingrese Teléfono" name="txtTeléfono" required/>
                </div>
                
                <div class="form-group">                   
                    <input type="text" class="form-control" placeholder="Ingrese Correo electronico" name="txtMail" required/>
                </div>  
                <div class="form-group">                   
                    <input type="text" class="form-control" placeholder="Ingrese nombre de Usuario" name="txtUsername" required/>
                </div>  
                <div class="form-group">
                    <select class="form-control" id="sel1" name="txtEscuela" required>
                        <option value="">Seleccione Escuela</option>
                        <jsp:include flush="true" page="./escuelaCargarListaServlet"></jsp:include>
                        <jsp:useBean id="school" class="sispa.dto.escuelaDTO" scope="page"></jsp:useBean>
                        <c:forEach items="${sessionScope.ListaEscuela}" var="school">
                            <option value="<c:out value="${school.id_escuela}"/>"><c:out value="${school.nombre_escuela}"/></option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">                    
                    <input type="password" class="form-control" onchange="this.form.password.value = MD5(this.form.password.value)" placeholder="Ingrese Password" name="password" required/>
                </div>                                             
                <div class="form-group">                   
                    <input type="password" class="form-control" onchange="this.form.confirmpassword.value = MD5(this.form.confirmpassword.value)" placeholder="Confirmar Password" name="confirmpassword" required/>  
                </div>                                        
                <div class="form-group">
                    <!--<input class="form-group" id="enviar" value="Ingresar" type="submit" onclick="return val();"/>-->
                </div> 
                <div class="form-group">   
                    <div class="container">
                        <div class="col-lg-6">
                            <button class="form-group" onclick="window.window.location.href = 'Login.jsp'">
                                <span class="glyphicon glyphicon-arrow-left"></span> Volver Login
                            </button>
                        </div>
                        <div class="col-lg-2"></div>
                        <div class="col-lg-6">
                            <button class="form-group" type="submit">
                            <span class="glyphicon glyphicon-ok"></span> Ingresar
                            </button>
                        </div>
                    </div>
                </div> 
            </form>
   
        </section>
        <br/><br/>
        
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
        <script src="Recursos/js/ConfirmarPass.js"></script>
        <script src="Recursos/js/bootstrap.js"></script>
        <script src="https://code.jquery.com/jquery.js"></script>
        <script src="Recursos/js/bootstrap.min.js"></script>
        <script src="Recursos/js/jquery-3.1.0.min.js"></script>
    </body>
</html>
