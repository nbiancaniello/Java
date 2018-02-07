<%-- 
    Document   : procesaFormulario
    Created on : 06-feb-2018, 18:52:20
    Author     : VMNico
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Procesa Formulario</title>
    </head>
    <body>
        <h1>Resultado de Procesar Formulario</h1>
        Usuario: <%= request.getParameter("usuario")%>
        <br>
        Password: <%= request.getParameter("password")%>
        <br>
        <br>
        <a href="index.html">Regregas al Inicio</a>
    </body>
</html>
