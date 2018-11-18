/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.p2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;


/**
 *
 * @author Jethran Gomez 
 */
public class FXMLInicioBancoController implements Initializable {
    
    @FXML
    private TextField txtAntiguedad;
    
    @FXML
    private TextField txtMovimientos;
    
    @FXML
    private TextField txtPrestamo;
    
    @FXML
    private TextField txtPagos;
    
    @FXML
    private void verificarPrestamo(ActionEvent event) {
        
      if (!txtAntiguedad.getText().equals("") || !txtMovimientos.getText().equals("") || 
              !txtPrestamo.getText().equals("") || !txtPagos.getText().equals("")) {
          
        int antiguedad = Integer.parseInt(txtAntiguedad.getText());
        int promedio = Integer.parseInt(txtMovimientos.getText());
        int prestamo = Integer.parseInt(txtPrestamo.getText());
        int pagos = Integer.parseInt(txtPagos.getText());
        
          if (antiguedad >= 2 ) {
              if (promedio >= 60000) {
                  if (prestamo > 100000) {
                      Alert alert = new Alert(Alert.AlertType.INFORMATION);
                      alert.setTitle("Credito excedido");
                      alert.setHeaderText("Ingrese otro credito");
                      alert.setContentText("El credito ingresado supera los limites");
                      
                      alert.showAndWait();
                  } else if (prestamo <= 100000) {
                      Alert alert = new Alert(Alert.AlertType.INFORMATION);
                      alert.setTitle("Posible");
                      alert.setHeaderText("El credito ha sido acetado");
                      alert.setContentText("La liquidez a realizar es de: " + (prestamo / pagos) +
                              "\nNumero de pagos: " + pagos);
                      
                      alert.showAndWait();
                  }
              } else if (promedio >= 40000 && promedio < 60000) {
                  if (prestamo > 70000) {
                      Alert alert = new Alert(Alert.AlertType.INFORMATION);
                      alert.setTitle("Credito excedido");
                      alert.setHeaderText("Ingrese otro credito");
                      alert.setContentText("El credito ingresado supera los limites del promedio de " +
                              "moviemientos que tiene que es 70,000.00");
                      
                      alert.showAndWait();
                  } else if (prestamo <= 70000) {
                      Alert alert = new Alert(Alert.AlertType.INFORMATION);
                      alert.setTitle("Posible");
                      alert.setHeaderText("El credito ha sido acetado");
                      alert.setContentText("La liquidez a realizar es de: " + (prestamo / pagos) +
                              "\nNumero de pagos: " + pagos);
                      
                      alert.showAndWait();
                  }
              } else if (promedio >= 25000 && promedio < 40000) {
                  if (prestamo > 50000) {
                      Alert alert = new Alert(Alert.AlertType.INFORMATION);
                      alert.setTitle("Credito excedido");
                      alert.setHeaderText("Ingrese otro credito");
                      alert.setContentText("El credito ingresado supera los limites del promedio de " +
                              "moviemientos que tiene que es 50,000.00");
                      
                      alert.showAndWait();
                  } else if (prestamo <= 50000) {
                      Alert alert = new Alert(Alert.AlertType.INFORMATION);
                      alert.setTitle("Posible");
                      alert.setHeaderText("El credito ha sido acetado");
                      alert.setContentText("La liquidez a realizar es de: " + (prestamo / pagos) +
                              "\nNumero de pagos: " + pagos);
                      
                      alert.showAndWait();
                  }
              }
          } else {
              if (promedio >= 60000) {
                  if (prestamo > 100000) {
                      Alert alert = new Alert(Alert.AlertType.INFORMATION);
                      alert.setTitle("Credito excedido");
                      alert.setHeaderText("Ingrese otro credito");
                      alert.setContentText("El credito ingresado supera los limites");
                      
                      alert.showAndWait();
                  } else {
                      if (pagos < 10 || pagos > 10) {
                          Alert alert = new Alert(Alert.AlertType.INFORMATION);
                          alert.setTitle("Pagos");
                          alert.setHeaderText("Numero de pagos negado");
                          alert.setContentText("El numero de pagos para el cliente solo puede ser de 10");
                          
                          alert.showAndWait();
                      } else if (pagos == 10) {
                          Alert alert = new Alert(Alert.AlertType.INFORMATION);
                          alert.setTitle("Posible");
                          alert.setHeaderText("El credito ha sido acetado");
                          alert.setContentText("La liquidez a realizar es de: " +
                                  ((prestamo + (prestamo * 0.30)) / pagos)  + "\nNumero de pagos: " + pagos);
                          
                          alert.showAndWait();
                      }
                  }
              } else if (promedio >= 40000 && promedio < 60000) {
                  if (prestamo > 70000) {
                      Alert alert = new Alert(Alert.AlertType.INFORMATION);
                      alert.setTitle("Credito excedido");
                      alert.setHeaderText("Ingrese otro credito");
                      alert.setContentText("El credito ingresado supera los limites del promedio de " +
                              "moviemientos que tiene que es 70,000.00");
                      
                      alert.showAndWait();
                  } else {
                      if (pagos == 0|| pagos > 10) {
                          Alert alert = new Alert(Alert.AlertType.INFORMATION);
                          alert.setTitle("Pagos");
                          alert.setHeaderText("Numero de pagos negado");
                          alert.setContentText("El numero de pagos maximo para el cliente solo puede " + 
                                  "ser de 10");
                          
                          alert.showAndWait();
                      } else if (pagos <= 10) {
                          Alert alert = new Alert(Alert.AlertType.INFORMATION);
                          alert.setTitle("Posible");
                          alert.setHeaderText("El credito ha sido acetado");
                          alert.setContentText("La liquidez a realizar es de: " +
                                  ((prestamo + (prestamo * 0.30)) / pagos) + "\nNumero de pagos: " + pagos);
                          
                          alert.showAndWait();
                      }
                  }
              } else if (promedio >= 25000 && promedio < 40000) {
                  if (prestamo > 50000) {
                      Alert alert = new Alert(Alert.AlertType.INFORMATION);
                      alert.setTitle("Credito excedido");
                      alert.setHeaderText("Ingrese otro credito");
                      alert.setContentText("El credito ingresado supera los limites del promedio de " +
                              "moviemientos que tiene que es 50,000.00");
                      
                      alert.showAndWait();
                  } else {
                      if (pagos > 6 || pagos == 0) {
                          Alert alert = new Alert(Alert.AlertType.INFORMATION);
                          alert.setTitle("Pagos");
                          alert.setHeaderText("Numero de pagos negado");
                          alert.setContentText("El numero de pagos maixmo para el cliente solo puede ser de 6");
                          
                          alert.showAndWait();
                      } else if (pagos <= 6) {
                          Alert alert = new Alert(Alert.AlertType.INFORMATION);
                          alert.setTitle("Posible");
                          alert.setHeaderText("El credito ha sido acetado");
                          alert.setContentText("La liquidez a realizar es de: " +
                                  ((prestamo + (prestamo * 0.30)) / pagos) + "\nNumero de pagos: " + pagos);
                          
                          alert.showAndWait();
                      }
                  }
              }
          }
          if (promedio < 25000) {
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setTitle("Denegado");
              alert.setHeaderText("Promedio bajo");
              alert.setContentText("El promedio ingresado no cumple con ninguno de los parametros" +
                      "\nEl maximo es de 25,000.00 ");
              
              alert.showAndWait();
          }
      } else {
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setTitle("Error");
              alert.setHeaderText("Campos vacios");
              alert.setContentText("Ingrese valor en los campos");
              
              alert.showAndWait();
      }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtAntiguedad.setOnKeyTyped(event ->{
            int maxCaracteres = 1;
            if(txtAntiguedad.getText().length() > maxCaracteres) event.consume();
        });
        
        txtMovimientos.setOnKeyTyped(event ->{
            int maxCaracteres = 7;
            if(txtMovimientos.getText().length() > maxCaracteres) event.consume();
        });
        
        txtPrestamo.setOnKeyTyped(event ->{
            int maxCaracteres = 5;
            if(txtPrestamo.getText().length() > maxCaracteres) event.consume();
        });
        
        txtPagos.setOnKeyTyped(event ->{
            int maxCaracteres = 1;
            if(txtPagos.getText().length() > maxCaracteres) event.consume();
        });
        
        txtAntiguedad.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, 
                String newValue)-> {

            if (!newValue.matches("[0-9]")) {
                txtAntiguedad.setText(newValue.replaceAll("[^0-9]",""));
            }
        });
        
        txtMovimientos.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, 
                String newValue)-> {

            if (!newValue.matches("[0-9]")) {
                txtMovimientos.setText(newValue.replaceAll("[^0-9]",""));
            }
        });
        
        txtPrestamo.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, 
                String newValue)-> {

            if (!newValue.matches("[0-9]")) {
                txtPrestamo.setText(newValue.replaceAll("[^0-9]",""));
            }
        });
        
        txtPagos.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, 
                String newValue)-> {

            if(!newValue.matches("[0-9]")) {
                txtPagos.setText(newValue.replaceAll("[^0-9]",""));
            }
        });
        
    }    
    
}
