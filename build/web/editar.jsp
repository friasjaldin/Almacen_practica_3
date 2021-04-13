<%-- 
    Document   : editar
    Created on : 11-04-2021, 04:34:15 PM
    Author     : CristhianFriasJaldin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Practica 3- Emergentes 2</title>
    </head>
    <body>
        <h1>
            <c:if test="${requestScope.op=='nuevo'}" var="res" scope="request">
                Registro de
            </c:if>
            <c:if test="${requestScope.op=='modificar'}" var="res" scope="request">
                Modificar
            </c:if>
            Productos
        </h1>
        <jsp:useBean id="almacena" scope="request" class="com.emergentes.modelo.Productos" />
        <form action="Principal" method="post">
            <table>
                <tr>
                    <td>Id</td>
                    <td><input type="text" name="id"
                            value="<jsp:getProperty name="almacena" property="id" />" />
                    </td>
                </tr>
                <tr>
                    <td>Productos</td>
                    <td><input type="text" name="producto"
                            value="<jsp:getProperty name="almacena" property="producto" />" />
                    </td>
                </tr>
                <tr>
                    <td>Precio</td>
                    <td><input type="text" name="precio"
                            value="<jsp:getProperty name="almacena" property="precio" />" />
                    </td>
                </tr>
                <tr>
                    <td>Cantidad</td>
                    <td><input type="text" name="cantidad"
                            value="<jsp:getProperty name="almacena" property="cantidad" />" />  
                    </td>  
                </tr>
                <tr>
                    <td>
                        <input type="hidden" name="opg" value="${requestScope.op}"/>
                        <input type="hidden" name="op" value="grabar"/>
                    </td>
                    <td><input type="submit" value="Enviar" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>
