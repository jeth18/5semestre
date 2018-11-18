/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2.pruebadesoftware;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;


public class FXMLFechaController implements Initializable {
    
    @FXML
    private TextField txtDia;
    
    @FXML
    private TextField txtMes;
    
    @FXML
    private TextField txtAnio;
    
    @FXML
    private TextField txtDiaS;
    
    @FXML
    private TextField txtMesS;
    
    @FXML
    private TextField txtAnioS;
    
    public boolean comprobarFecha(int dia, int mes, int anio) {
        boolean error = false;  
        
        if ((dia < 1 || dia > 31) && (mes < 1 || mes > 12) && (anio < 1812 || anio > 2020)) {
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setTitle("Error");
              alert.setHeaderText("Fecha incorrecta");
              alert.setContentText("Los numeros ingresados en los campos no cumplen los rangos");
              
              error = true;
              
              alert.showAndWait();   
        } else {
            
            if ((dia < 1 || dia > 31) && (mes < 1 || mes > 12)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                 alert.setTitle("Error");
                 alert.setHeaderText("Dia y mes incorrecto");
                 alert.setContentText("Los numeros ingresados en los campos no cumplen los rangos" + 
                         "del mes y dia");
                 
                 error = true;
                 
                alert.showAndWait();
                
            } else if ((mes < 1 || mes > 12) && (anio < 1812 || anio > 2020)) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                      alert.setTitle("Error");
                      alert.setHeaderText("Mes y año incorrecto");
                      alert.setContentText("Los numeros ingresados en los campos no cumplen los" +  
                              "rango de mes y año");
                      
                      error = true;
                      
                    alert.showAndWait();
                    
                    } else  if ((dia < 1 || dia > 31) && (anio < 1812 || anio > 2020)){
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                              alert.setTitle("Error");
                              alert.setHeaderText("Dia y año incorrecto");
                              alert.setContentText("Los numeros ingresados en los campos no cumplen" + 
                                    "los rangos de dia y año");
              
                               error = true;
                               
                            alert.showAndWait();
                        
                        } else {
     
                        if (anio < 1812 || anio > 2020) {
            
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                              alert.setTitle("Error");
                              alert.setHeaderText("Año incorrecto");
                              alert.setContentText("El año ingresado supera los rangos");
                              
                              error = true;
                              
                            alert.showAndWait();
                        }

                        if (mes < 1 || mes > 12) {
		
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                          alert.setTitle("Error");
                          alert.setHeaderText("Mes incorrecto");
                          alert.setContentText("El mes ingresado no cumple los rangos");
              
                          error = true;
                          
                        alert.showAndWait();
                        }

                        if (dia < 1 || dia > 31) {
		
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                          alert.setTitle("Informacion");
                          alert.setHeaderText("Dia incorrecto");
                          alert.setContentText("El dia ingresado no cumple los rangos");
              
                          error = true;
                          
                        alert.showAndWait();
                        }
                    }
                }
        return error;
    }
    
    @FXML
    private void siguienteDia(ActionEvent event) {
        
        int diaS = 0;
        int mesS = 0;
        int anioS = 0;
    
        if (txtDia.getText().equals("") || txtMes.getText().equals("") || 
                txtAnio.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setTitle("Informacion");
              alert.setHeaderText("Ingrese valores en los 3 primero campos");
              alert.setContentText("Falta un valor en algun campo");
              
              alert.showAndWait();
        } else {
        
            int dia = Integer.parseInt(txtDia.getText());
            int mes = Integer.parseInt(txtMes.getText());
            int anio = Integer.parseInt(txtAnio.getText());
        
        if(comprobarFecha(dia, mes, anio) == true) {
            System.out.println("Error");
        } else {      
            if ((mes == 02 && dia >= 29) && (anio == 1900 || (!(anio % 4 == 0)))) {
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Informacion");
                alert.setHeaderText("Esa fecha no existe");
                alert.setContentText("La fecha ingresada no existe por el año");
              
              alert.showAndWait();
            } else if ((mes == 02 && dia == 29)) {
                diaS = 01;
                mesS = mes + 1;
                anioS = anio;
            } else {
                if (dia == 31 && mes == 12) {
                    diaS = 01;
                    mesS = 01;
                    anioS = anio + 1;
                } else {
                if ((!(mes % 2 == 0)) && mes < 8) {
                    if (dia == 31) {
                      diaS = 01;
                      mesS = mes + 1;
                      anioS = anio;
                    } else {
                      diaS = dia + 1;
                      mesS = mes;
                      anioS = anio;
                    }
                } else if (mes < 8) {
                       if((mes == 02 && dia == 28) && (anio % 4 == 0)) {
                          mesS = mes;
                          diaS = dia + 1;
                          anioS = anio;
                       } else if (mes == 02 && dia == 28) {
                           mesS = mes + 1;
                           diaS = 1;
                           anioS = anio;
                       } else {
                        if (dia == 30) {
                          diaS = 01;
                          mesS = mes + 1;
                          anioS = anio;
                        } else if ( dia > 30) {
                          Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Informacion");
                            alert.setHeaderText("Esa fecha no existe");
                            alert.setContentText("La fecha ingresada no existe por el año");
                            
                            alert.showAndWait();
                        } else {
                            diaS = dia + 1;
                            mesS = mes;
                            anioS = anio;
                        }
                       }
                    } else if ((mes % 2 == 0) && mes >= 8) {
                        if (dia == 31) {
                        diaS = 01;
                        mesS = mes + 1;
                        anioS = anio;
                        } else {
                        diaS = dia + 1;
                        mesS = mes;
                        anioS = anio;
                        }
                    } else if (mes >= 8) {
                        if (dia == 30) {
                        diaS = 01;
                        mesS = mes + 1;
                        anioS = anio;
                        } else if (dia > 30) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Informacion");
                            alert.setHeaderText("Esa fecha no existe");
                            alert.setContentText("La fecha ingresada no existe por el año");
                            
                            alert.showAndWait();
                        } else {
                        diaS = dia + 1;
                        mesS = mes;
                        anioS = anio;   
                        }
                    }
                }
            }  
        }
      }
        txtDiaS.setText(Integer.toString(diaS));
        txtMesS.setText(Integer.toString(mesS));
        txtAnioS.setText(Integer.toString(anioS));
    }
    
    @FXML
    private void borrarFechas() {
        
        txtDia.setText("");
        txtMes.setText("");
        txtAnio.setText("");
        txtDiaS.setText("");
        txtMesS.setText("");
        txtAnioS.setText("");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        txtDia.setOnKeyTyped(event ->{
            int maxCaracteres = 1;
            if(txtDia.getText().length() > maxCaracteres) event.consume();
        });
        
        txtMes.setOnKeyTyped(event ->{
            int maxCaracteres = 1;
            if(txtMes.getText().length() > maxCaracteres) event.consume();
        });
        
        txtAnio.setOnKeyTyped(event ->{
            int maxCaracteres = 3;
            if(txtAnio.getText().length() > maxCaracteres) event.consume();
        });
        
        txtDia.textProperty().addListener((ObservableValue<? extends String> observable,
                String oldValue, String newValue)-> {

            if(!newValue.matches("[0-9]")) {
                txtDia.setText(newValue.replaceAll("[^0-9]",""));
            }
          
        });
        
        txtMes.textProperty().addListener((ObservableValue<? extends String> observable,
                String oldValue, String newValue)-> {

            if(!newValue.matches("[0-9]")) {
                txtMes.setText(newValue.replaceAll("[^0-9]",""));
            }
          
        });
        
        txtAnio.textProperty().addListener((ObservableValue<? extends String> observable, 
                String oldValue, String newValue)-> {

            if(!newValue.matches("[0-9]")) {
                txtAnio.setText(newValue.replaceAll("[^0-9]",""));
            }
          
        });
        
        txtDiaS.setDisable(true);
        txtMesS.setDisable(true);
        txtAnioS.setDisable(true);
    }    
    
}
