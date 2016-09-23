<%-- 
    Document   : index
    Created on : 20/09/2016, 01:19:09 PM
    Author     : tacho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:forward 
            page="/PagoController?action=otro"></jsp:forward>
            
            <jsp:forward 
            page="/EstudianteController?action=otro"></jsp:forward>
    </body>
</html>
