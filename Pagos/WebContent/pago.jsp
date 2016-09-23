<%-- 
    Document   : estudiante
    Created on : 20/09/2016, 12:24:45 PM
    Author     : tacho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pago</title>
    </head>
    <body>
        <form action="PagoController" method="post">
            <fieldset>
                <legend>Formulario de registro</legend>
                
                <div>
                <label for="idPago">Id Pago:</label>
                <input type="text" name="idPago"
                       value="${pago.idPago}"
                       readonly="readonly" 
                       placeholder="Id de pago"/>
                </div>
                
                <div>
                <label for="subtotal">Subtotal:</label>
                <input type="text" name="subtotal"
                       value="${pago.subtotal}"
                       placeholder="Subtotal del pago"/>
                </div>
                 
                <div>
                <label for="propina">Propina:</label>
                <input type="text" name="propina"
                       value="${pago.propina}"
                       placeholder="Propina del pago"/>
                </div>
                
                <div>
                <label for="impuesto">Impuesto:</label>
                <input type="text" name="impuesto"
                       value="${pago.impuesto}"
                       placeholder="Impuesto"/>
                </div>
                
                 <div>
                     <input type="submit" 
                       value="Guardar" />
                </div>
            </fieldset>
            
        </form>
    </body>
</html>
