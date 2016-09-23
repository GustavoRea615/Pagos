/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utng.pagos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mx.edu.utng.pagos.model.Pago;
import mx.edu.utng.pagos.util.UtilDB;

/**
 *
 * @author tacho
 */
public class PagoDAOimp implements PagoDAO{

    private Connection connection;
    
    public PagoDAOimp(){
        connection = UtilDB.getConnection();
    }
    
    @Override
    public void agregarPago(Pago pago) {
        try {
          String query = "INSERT INTO pagos (subtotal, propina, "
                  + " impuesto) VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareCall(query);
            ps.setDouble(1, pago.getSubtotal());
            ps.setDouble(2, pago.getPropina());
            ps.setDouble(3, pago.getImpuesto());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrarPago(int idPago) {
        try {
             String query = "DELETE FROM pagos WHERE id_pago = ?";
             PreparedStatement ps = connection.prepareCall(query);
             ps.setInt(1, idPago);
             ps.executeUpdate();
             ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarPago(Pago pago) {
    try {
          String query = "UPDATE pagos SET subtotal= ?, "
                  + " propina=?, impuesto=? WHERE "
                  + " id_pago = ?";
            PreparedStatement ps = connection.prepareCall(query);
            ps.setDouble(1, pago.getSubtotal());
            ps.setDouble(2, pago.getPropina());
            ps.setDouble(3, pago.getImpuesto());
            ps.setInt(4, pago.getIdPago());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Pago> desplegarPagos() {
        List<Pago> pagos = new ArrayList<Pago>();
        try{
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(
                "SELECT * FROM pagos");
            while (resultSet.next()) {
              Pago pago = new Pago(
              resultSet.getInt("id_pago"),
              resultSet.getDouble("subtotal"),
              resultSet.getDouble("propina"),
              resultSet.getDouble("impuesto"));
              pagos.add(pago);
            }
            resultSet.close();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return pagos;
    }

    @Override
    public Pago elegirPago(int idPago) {
       Pago pago = new Pago();
        try{
        PreparedStatement statement = 
                connection.prepareStatement(
                        "SELECT * FROM pagos WHERE "
                                + " id_pago = ?");
        statement.setInt(1, idPago);
        ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
              pago.setIdPago(
                      resultSet.getInt("id_pago"));
              pago.setSubtotal(
                      resultSet.getDouble("subtotal"));
              pago.setPropina(
                      resultSet.getDouble("propina"));
              pago.setImpuesto(
                      resultSet.getDouble("impuesto"));
            }
            resultSet.close();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return pago;
    }     
}


