/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.jet.login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mx.jet.dao.CuentaDao;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class FXMLLoginController implements Initializable {
    
    CuentaDao us = new CuentaDao();
    private String usuario;
    private String contrasena;
      
    @FXML
    private TextField txtUsuario;
    
    @FXML
    private PasswordField txtContrasena;
    
    @FXML
    private void closeButtonAction(){  
        Stage stage = (Stage) txtContrasena.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void loginButton(ActionEvent event) {
       
        usuario= txtUsuario.getText();
        contrasena = txtContrasena.getText();
        
        if(us.sesionIniciada(usuario, contrasena) == true ) {
            System.out.println("cuenta iniciada");
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Informacion");
            alert.setHeaderText("No hay una cuenta relacionada con el sistema");
            alert.setContentText("Puede registrarse en el sistema");

            alert.showAndWait();
        }    
    }
    
     @FXML
    public void RegistrarVentana() {
         Stage stage = new Stage();
         try {
             Parent root = FXMLLoader.load(getClass().getResource("FXMLRegistrarse.fxml"));
             Scene scene = new Scene(root);
   
     
             stage.setScene(scene);
             stage.show();
             
             closeButtonAction();
             
         } catch (IOException ex) { 
            Logger.getLogger(FXMLRegistrarseController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // Bloque de longitud de text field
        txtUsuario.setOnKeyTyped(event ->{
            int maxCaracteres = 14;
            if(txtUsuario.getText().length() > maxCaracteres) event.consume();
        });
        
        txtContrasena.setOnKeyTyped(event ->{
            int maxCaracteres = 14;
            if(txtContrasena.getText().length() > maxCaracteres) event.consume();
        });
        
        //Bloque de teclas de datos
        txtUsuario.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue)-> {
            if(!newValue.matches("[a-z A-Z 0-9]")) {
                txtUsuario.setText(newValue.replaceAll("[^a-z A-Z 0-9]", ""));
            }
        });
        
        
    }    
}    


