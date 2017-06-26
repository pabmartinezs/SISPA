<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Home</title>
        <link href="Recursos/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="Recursos/css/bootstrap.css" rel="stylesheet" media="screen"> 
    </head>
    <body>
        <%--Header--%>
        <div class="navbar navbar-inverse navbar-fixed-top" style="background: #154360">
            <div class="text-left">
                <img src="Recursos/imagen/bannerSispa.png">
            </div>
        </div> 
        <%--Fín Header--%>
        <br/><br/><br/><br/>
        <c:choose>
            <c:when test="${sessionScope.UsuarioConectado==null}">
                <jsp:forward page="Login.jsp"></jsp:forward>
            </c:when>
            <c:otherwise>
                <jsp:useBean id="useCon" class="sispa.dto.usuarioescuelaperfilDTO" scope="session"></jsp:useBean>
                <jsp:useBean id="listarPerfilMenuPadre" class="sispa.dto.menuperfilDTO" scope="page"></jsp:useBean>
                <jsp:useBean id="listarPerfilMenuHijo" class="sispa.dto.menuperfilDTO" scope="page"></jsp:useBean>
                <jsp:include page="./cargarMenuServlet" flush="true"></jsp:include>
                <%--Menú--%>
                <nav class="navbar navbar-default" role="navigation" >

                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                            <span class="sr-only">Desplegar navegación</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" style="color: #084B8A">SISPA</a>
                    </div>
                    <div class="collapse navbar-collapse navbar-ex1-collapse">                            
                        <ul class="nav navbar-nav">  
                            <li><a href="Home.jsp"><span class="glyphicon glyphicon-home" style="color: #084B8A"></span> <label style="color: #084B8A">Home</label></a></li>
                                <c:if test="${sessionScope.listaMenu != null}">
                                    <c:forEach items="${sessionScope.listaMenu}" var="listarPerfilMenuPadre">                                    
                                    <li class="dropdown">     
                                        <c:if test="${listarPerfilMenuPadre.objmenu.padreMenu==0}">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" style="color: #084B8A">
                                                <c:out value="${listarPerfilMenuPadre.objmenu.nombreMenu}"></c:out>
                                                    <b class="caret"></b>
                                                </a>                              
                                        </c:if>                                   
                                        <ul class="dropdown-menu">                            
                                            <c:forEach items="${sessionScope.listaMenu}" var="listarPerfilMenuHijo"> 
                                                <c:if test="${listarPerfilMenuPadre.objmenu.idMenu == listarPerfilMenuHijo.objmenu.padreMenu}">
                                                    <li><a href="${listarPerfilMenuHijo.objmenu.destinoMenu}" style="color: #084B8A"><c:out value="${listarPerfilMenuHijo.objmenu.nombreMenu}"></c:out></a></li>
                                                    </c:if>                                       
                                                </c:forEach>                                       
                                        </ul>                          
                                    </li>                                
                                </c:forEach>
                            </c:if>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" style="color: #084B8A"><span class="glyphicon glyphicon-user" style="color: #084B8A"></span>
                                    <c:set value="${sessionScope.UsuarioConectado}" var="useCon"></c:set>
                                    <c:out value="${useCon.objusuario.nombreUsuario} "></c:out>
                                    <c:out value="${useCon.objusuario.apellidoUsuario} "></c:out>
                                        <b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="./cerrarSesionServlet" style="color: #084B8A">Cerrar Sesión</a></li>                                          
                                    </ul>
                                </li>
                            </ul>
                        </div>                        
                    </nav>
                <%--Fin Menú--%>
                
                <%--Contenido--%>
                <div class="container">
                    <div class="col-lg-4"></div>
                    <div class="text-center">
                        <div class="col-lg-12">
                            <h3 style="color: #084B8A"><b>Agregar Categoria</b></h3>
                            <section class="container">
                                <div class="col-lg-4"></div>
                                <form name="frm" method="post" action="./categoriaUPServlet" role="form" class="col-lg-4 pure-form"> 
                                    <div class="form-group">                   
                                        <input type="text" class="form-control"  placeholder="Ingrese Nombre Categoria" name="txtNomrbeCategoriaUP" required/>
                                    </div>  
                                    <div class="form-group">                   
                                        <select class="form-control" id="sel1" name="txtEstadoCategoriaup" required>
                                            <option value="0"> Desactivada </option>
                                            <option value="1"> Activada </option>
                                        </select>
                                    </div> 
                                    <div class="form-group">
                                        <button class="form-group" id="enviar" value="Modificar" type="submit" style="color: #084B8A">
                                            <span class="glyphicon glyphicon-pencil"></span> Modificar
                                        </button>
                                    </div> 
                                </form>
                            </section>
                            <br/><br/>
                        </div>
                    </div>
                </div> 
                <%--Fin Contenido--%>
            </c:otherwise>
        </c:choose>
        <br/><br/><br/><br/><br/><br/><br/>
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
        <script src="https://code.jquery.com/jquery.js"></script>
        <script src="Recursos/js/jquery-3.1.0.min.js"></script>
        <script src="Recursos/js/bootstrap.min.js"></script>
    </body>
</html>
