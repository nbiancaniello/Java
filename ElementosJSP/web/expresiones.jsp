<%-- 
    Document   : expresiones
    Created on : 06-feb-2018, 18:51:56
    Author     : VMNico
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP de Expresiones</title>
    </head>
    <body>
        <h1>JSP de Expresiones</h1>
        Concatenacion: <%="Saludos"+"JSP"%>
        <br>
        Operacion Matematica: <%= 2*3/2%>
        <br>
        Sesion id: <%=session.getId()%>
        <br>
        <br>
        <a href="index.html">Regregas al Inicio</a>
    </body>
</html>
