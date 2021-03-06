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
                            <h3 style="color: #084B8A"><b>Modificar Categorias en el sistema</b></h3>
                            <jsp:include flush="true" page="./categoriaLSTServlet"></jsp:include>
                            <c:if test="${sessionScope.LSTCategoria != null}">
                                <table class="table table-hover" style="color: #084B8A">
                                    <thead>
                                        <tr>
                                            <th><div class="col-lg-3"></div>ID Categoria</th>
                                            <th><div class="col-lg-3"></div>Nombre Categoria</th>
                                            <th><div class="col-lg-3"></div>Estado Categoria</th>
                                            <th><div class="col-lg-3"></div>Desactivar Categoria</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${sessionScope.LSTCategoria}" var="LCategoria">
                                            <tr>
                                                <c:if test="${useCon.objusuario.idPerfil.idPerfil == 1}">
                                                    <td><c:out value="${LCategoria.idCategoria}"></c:out></td>
                                                    <td><c:out value="${LCategoria.nombreCategoria}"></c:out></td>
                                                    <td><c:if test="${LCategoria.estadoCategoria == '1'}">
                                                            <label>Activada</label>
                                                        </c:if>
                                                        <c:if test="${LCategoria.estadoCategoria != '1'}">
                                                            <label>Desactivada</label>
                                                        </c:if>
                                                    </td>
                                                    <td>
                                                        <c:url value="./categoriaUPServlet" var="URLUP">
                                                            <c:param name="IDCAT" value="${LCategoria.idCategoria}"></c:param>
                                                        </c:url>
                                                        <button onclick="if(confirm('¿Seguro que desea modificar la Categoria?')) window.location.href = '<c:out value="${URLUP}"></c:out>'">
                                                            <span class="glyphicon glyphicon-pencil"></span> Modificar
                                                        </button>
                                                    </td>
                                                </c:if>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </c:if>
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
