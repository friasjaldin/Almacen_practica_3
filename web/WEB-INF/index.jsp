<%-- 
    Document   : index
    Created on : 11-04-2021, 04:32:52 PM
    Author     : CristhianFriasJaldin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.emergentes.modelo.Productos"%>
<%@page import="com.emergentes.modelo.GestorProductos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
if(session.getAttribute("agenda")==null){
    GestorProductos objeto1=new GestorProductos();
    session.setAttribute("agenda", objeto1);
}
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Practica 3- Emergentes 2</title>
    </head>
    <body>
        <h2>Univ.Cristhian jaime Frias Jaldin</h2>
        <h1 style="color:red">PRODUCTOS</h1>
        <a href="Principal?op=nuevo">Nuevo Producto</a>
        <table border="3" >
            <tr style="color:green">
                <th>Id</th>
                <th>Producto</th>
                <th>Precio</th>
                <th>Cantidad</th>
                <th>Modificar</th>
                <th>Eliminar</th>
            </tr>
            <c:forEach var="item" items="${sessionScope.agenda.getLista()}">
                <tr style="color:green">
                    <td>${item.id}</td>
                    <td>${item.producto}</td>
                    <td>${item.precio}</td>
                    <td>${item.cantidad}</td>
                    <td><a href="Principal?op=modificar&id=${item.id}">Modificar</a></td>
                    <td><a href="Principal?op=eliminar&id=${item.id}">Eliminar</a></td>
                </tr> 
            </c:forEach>
        </table>
    </body>
</html>

