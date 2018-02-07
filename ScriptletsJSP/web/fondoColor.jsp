<%-- 
    Document   : fondoColor
    Created on : 06-feb-2018, 19:35:10
    Author     : VMNico
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% String fondo = request.getParameter("colorFondo");
    if (fondo == null || fondo.trim().equals("")) {
        fondo = "white";
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Color Change</title>
    </head>
    <body bgcolor="<%=fondo%>">
    <body>
        <h1>Fondo de color aplicado: <%=fondo%></h1>
        <br>
        <a href="index.html">Regresar</a>
    </body>
</html>
