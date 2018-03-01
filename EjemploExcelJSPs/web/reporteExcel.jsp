<%-- 
    Document   : reportExcel
    Created on : 10-feb-2018, 20:45:52
    Author     : VMNico
--%>

<%@page import="utilerias.Conversiones, java.util.Date" %>
<%@page contentType="application/vnd.ms-excel" %>
<%
    String nombreArchivo="reporte.xls";
    response.setHeader("Content-Disposition","inline; filename=" + nombreArchivo);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reporte de Excel</title>
    </head>
    <body>
        <h1>Reporte de Excel</h1>
        <br>
        <table border="1">
            <tr>
                <th>Curso</th>
                <th>Decripcion</th>
                <th>Fecha de Inicio</th>
            </tr>
            <tr>
                <td>1. Fundamentos de Java</td>
                <td>Aprenderemos la sintaxis basica de Java</td>
                <td><%= Conversiones.format(new Date())%></td>
            </tr>
            <tr>
                <td>1. Programacion con Java</td>
                <td>Pondremos en practica conceptos de POO</td>
                <td><%= Conversiones.format(new Date())%></td>
            </tr>
        </table>
    </body>
</html>
