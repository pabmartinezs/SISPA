<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Sistema pañol</title>
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
                        <div class="col-lg-4">
                            <h3 style="color: #084B8A"><b>Realizar Solicitud Online</b></h3>
                            <h3 style="color: #084B8A"><b>Pedido</b></h3>
                        </div>
                    </div>
                </div> 
                <div class="form-group">    
                <section class="container">
                    <div class="col-lg-3"></div>
                    <div class="col-lg-1">
                        <form name="frm2" method="post" action="./" role="form" class="col-lg-4">
                            <div class="form-group">
                                <div class="container">
                                    <div class="col-lg-3">
                                        <input class="form-group" id="ConfirmarSolicitudONline" value="Ir a Confirma Solicitud" type="submit"/>
                                    </div>
                                    <div class="col-lg-1"></div>
                                </div>
                            </div> 
                            <div class="form-group">
                                <div class="container">
                                    <div class="col-lg-1">
                                    <jsp:include flush="true" page="./productoCargarListaServlet"></jsp:include>
                                    <c:if test="${sessionScope.ListaProductos != null}">
                                    <table class="table table-hover" style="color: #084B8A">
                                        <thead>
                                            <tr>
                                                <th><div class="col-lg-2"></div>Nombre</th>
                                                <th><div class="col-lg-2"></div>Cantidad</th>
                                                <th><div class="col-lg-2"></div>Imagen</th>
                                                <th><div class="col-lg-2"></div>Cantidad</th>
                                                <th><div class="col-lg-2"></div>Agregar carro</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${sessionScope.ListaProductos}" var="LProductos">
                                                <tr>
                                                    <td><c:out value="${LProductos.objproducto.descripcionProducto}"></c:out></td>
                                                    <td><c:out value="${LProductos.objproducto.stockProducto}"></c:out></td>
                                                    <td><c:out value="${LProductos.objproducto.imagenProducto}"></c:out></td>
                                                    <td><input class="form-group" id="ADDMaterial" name="txtMaterialCantCar" type="number"/></td>
                                                    <td>
                                                        <c:url value="./fghffghfgh" var="URLADDCAR">
                                                            <c:param name="ID_COMUNA" value="${LProductos.objproducto.idProducto}"></c:param>
                                                        </c:url>
                                                        <button value="Actualizar" onclick="window.location.href = '<c:out value="${URLADDCAR}"></c:out>'">
                                                            <span class="glyphicon glyphicon-shopping-cart"></span> Agregar al carro 
                                                        </button>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                    </c:if>
                                    </div>
                                </div>
                                </div> 
                        </form>
                    </div>
                    <div class="col-lg-6"></div>
                </section>
                </div>
                    
                
                <%--Fin Contenido--%>
            </c:otherwise>
        </c:choose>

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