/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.jet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.jet.dataaccess.DataBase;
import mx.jet.domain.Cuenta;

/**
 * 
 * @author jethran gomez
 */
public class CuentaDao implements ICuentaDao {

    private String query;
    private Connection connection;
    
    @Override
    public boolean sesionIniciada(String idCuenta, String contrasena) {
        boolean iniciado = false;
        query = "Select * from cuenta where idCuenta = ? and Contrasena = ?";
        connection = DataBase.getDataBaseConnection();
        
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,idCuenta);
            statement.setString(2,contrasena);
            
            ResultSet result = statement.executeQuery();
            
            if(result.next()) {
                iniciado = true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CuentaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DataBase.closeConnection();
        }
        
        return iniciado;
    }

    @Override
    public boolean registrarcuenta(Cuenta usuario) {
        
        boolean registrado = false;
        query = "insert into cuenta value (?,?,?,?,?,?)";
        connection = DataBase.getDataBaseConnection();
        
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            
            statement.setString(1, usuario.getIdCuenta());
            statement.setString(2, usuario.getNombre());
            statement.setString(3, usuario.getApellidos());
            statement.setString(4, usuario.getCorreo());
            statement.setString(5, usuario.getFechaNac());
            statement.setString(6, usuario.getContraseña());
            
            statement.execute();
            registrado = true;
            
        } catch (SQLException ex) { 
            Logger.getLogger(CuentaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return registrado;
    }

}
