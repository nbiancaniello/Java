<%-- 
    Document   : index
    Created on : 06-feb-2018, 10:23:38
    Author     : VMNico
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Excercise Hello World!</h1>
        <ul>
            <li> Hola Mundo con HTML
            <li><%out.print("Hola Mundo con Scriptlets");%>
            <li>${"Hola Mundo con Expression Language (EL)"}
            <li><c:out value="Hola Mundo con JSTL" />
        </ul>
        <ul>
            <li>Hola: <%= new java.util.Date()%>
            <li>Nombre del contexto de la app <%= request.getContextPath()%>
            <li>Valor del parametro x: <%= request.getParameter("x")%>
        </ul>
    </body>
</html>
