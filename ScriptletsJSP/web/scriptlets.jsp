<%-- 
    Document   : scriptlets
    Created on : 06-feb-2018, 19:35:36
    Author     : VMNico
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP SCRIPTLETS</title>
    </head>
    <body>
        <h1>JSP Scriptlets</h1>
        <br>
        <% out.println("Saludos desde un scriplet");%>
        <br>
        <% String nombreAplicacion = request.getContextPath();
            out.println("NombreAPlicacion:"+nombreAplicacion);
        %>
        <br>
        <% if (session != null && session.isNew()){
        %>
        la sesion SI es nueva
        <% } else if (session != null){
        %>
        la sesion NO es nueva
        <% }
        %>
    </body>
</html>
