/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.jet.login;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import mx.jet.dao.CuentaDao;
import mx.jet.domain.Cuenta;

/**
 * FXML Controller class
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class FXMLRegistrarseController implements Initializable {
    
    private String idCuenta;
    private String nombre; 
    private String apellidos;
    private String correo;
    private String contrasena;
    private String contrasenaR;
    private String fechaNac;
    Cuenta usuario = new Cuenta();
    
    @FXML 
    private TextField txtNombre;
    
    @FXML
    private TextField txtApellidos;
    
    @FXML
    private TextField txtCorreo;
    
    @FXML
    private TextField txtIdCuenta;
    
    @FXML
    private DatePicker Date;
    
    @FXML
    private PasswordField txtPassword;
    
    @FXML
    private PasswordField txtPasswordR;
    
    @FXML
    private void RegistrarseButton(ActionEvent event) {
        
        idCuenta = txtIdCuenta.getText();
        nombre = txtNombre.getText();
        apellidos = txtApellidos.getText();
        correo = txtCorreo.getText();
        
        
        try {
        LocalDate result = Date.getValue();
        fechaNac = result.toString();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        
        contrasena = txtPassword.getText();
        contrasenaR = txtPassword.getText();
        
        if("".equals(idCuenta) || "".equals(nombre) || "".equals(apellidos) || "".equals(correo) || "".equals(fechaNac) || "".equals(contrasena) || "".equals(contrasenaR)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informacion");
            alert.setHeaderText("Datos faltantes");
            alert.setContentText("Ingrese los datos correspondientes que se piden");

            alert.showAndWait();
        } else {
        
            if(!contrasena.equals(contrasenaR)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informacion");
            alert.setHeaderText("contraseña invalida");
            alert.setContentText("Las contraseñas ingresadas no son validas");

            alert.showAndWait();
            } else {
                usuario.setIdCuenta(idCuenta);
                usuario.setNombre(nombre);
                usuario.setApellidos(apellidos);
                usuario.setCorreo(correo);
                usuario.setFechaNac(fechaNac);
                usuario.setContraseña(contrasena);
                
                CuentaDao cuentaDao = new CuentaDao();
                
                cuentaDao.registrarcuenta(usuario);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Informacion");
                alert.setHeaderText("Registrado");
                alert.setContentText("La cuenta se ha guardado correctamente, ya puede iniciar sesion");

                alert.showAndWait();
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
