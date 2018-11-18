/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.jet.dao;

import mx.jet.domain.Cuenta;

/**
 *
 * @author Jethran Gomez
 */
public interface ICuentaDao {
    boolean sesionIniciada(String idCuenta, String contrasena);
    boolean registrarcuenta(Cuenta usuario);
    
}
