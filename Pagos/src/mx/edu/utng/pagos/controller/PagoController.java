package mx.edu.utng.pagos.controller;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.edu.utng.pagos.dao.PagoDAO;
import mx.edu.utng.pagos.dao.PagoDAOimp;
import mx.edu.utng.pagos.model.Pago;
public class PagoController extends HttpServlet {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
private static final String
           LISTA_PAGOS = "/lista_pagos.jsp";
   private static final String 
           AGREGAR_O_CAMBIAR = "pago.jsp";
   private PagoDAO dao;
   
   public PagoController(){
       dao = new PagoDAOimp();
   }
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if(action.equalsIgnoreCase("borrar")){
            forward = LISTA_PAGOS;
            int idPago = Integer.parseInt(
                request.getParameter("idPago"));
            dao.borrarPago(idPago);
            request.setAttribute("pagos",
                    dao.desplegarPagos());
         }else if(action.equalsIgnoreCase("cambiar")){
             forward = AGREGAR_O_CAMBIAR;
             int idPago = Integer.parseInt(
                request.getParameter("idPago"));
             Pago pago = 
                     dao.elegirPago(idPago);
             request.setAttribute("pago", pago);
         } else if(action.equalsIgnoreCase("agregar")){
             forward = AGREGAR_O_CAMBIAR;
         } else{
             forward = LISTA_PAGOS;
             request.setAttribute("pagos", 
                     dao.desplegarPagos());
         }
        
        RequestDispatcher view = 
                request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Pago pago = new Pago();
        pago.setSubtotal(Double.parseDouble(request.getParameter("subtotal")));
        pago.setPropina(Double.parseDouble(request.getParameter("propina")));
        pago.setImpuesto(Double.parseDouble(request.getParameter("impuesto")));

        String idPago = request.getParameter("idPago");
        
        if(idPago==null|| idPago.isEmpty()||idPago.trim().equals("")){
            dao.agregarPago(pago);
        }else{
            pago.setIdPago(
                    Integer.parseInt(idPago));
            dao.cambiarPago(pago);
        }
        RequestDispatcher view = 
                request.getRequestDispatcher(LISTA_PAGOS);
        request.setAttribute("pagos", 
                dao.desplegarPagos());
        view.forward(request, response);
    }
}

