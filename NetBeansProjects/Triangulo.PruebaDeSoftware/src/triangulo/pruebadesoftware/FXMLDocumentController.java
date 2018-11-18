/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triangulo.pruebadesoftware;

import static java.lang.Integer.parseInt;
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
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField txtA;
    
    @FXML
    private TextField txtB;
    
    @FXML
    private TextField txtC;
    
    @FXML
    private TextField txtTriangulo;
    
    
    @FXML
    private void tipoTriangulo(ActionEvent event) {
       int a, b, c;
       
       
        if(txtA.getText().equals("") || txtB.getText().equals("") || txtC.getText().equals(" ")){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Informacion");
                alert.setHeaderText("Ingrese un numero");
                alert.setContentText("No se encuentra ningun numero ingresado");
                

                alert.showAndWait();
        } else {
            a = parseInt(txtA.getText());
            b = parseInt(txtB.getText());
            c = parseInt(txtC.getText());
            
            if(((a < 0) || (a > 200)) || ((b < 0) || (b > 200)) || ((c < 0) || (c > 200))) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Informacion");
                alert.setHeaderText("Numero invalido");
                alert.setContentText("Ingrese un numero entre 1 y 200\n");

                alert.showAndWait();
            
            } else {
       
                if( a==b) {
                    if(c==b) {
                        txtTriangulo.setText("Es equilatero");
                        }else {
                            if(c <= ((a + b) - 1)) {
                            txtTriangulo.setText("Es isósceles");
                            } else {
                            txtTriangulo.setText("No es un triangulo");
                            }
                        }
                }else{
                    if(b==c) {
                        if(a <= ((c + b) - 1)) {
                            txtTriangulo.setText("Es isósceles");
                        } else {
                            txtTriangulo.setText("No es un triangulo");
                        }
                    }else{
                        if(a==c) {
                            if(b <= ((c + a) - 1)) {
                                txtTriangulo.setText("Es isósceles");
                            }else{
                                txtTriangulo.setText("No es un triangulo");
                            }
                        }else{
                            mayor(a,b,c); 
                        }
                    }
                } 
            }
        }
    }
    
    @FXML
    private void Borrar (ActionEvent event ) {
        txtA.setText("");
        txtB.setText("");
        txtC.setText("");
        txtTriangulo.setText("");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        txtA.setOnKeyTyped(event ->{
            int maxCaracteres = 2;
            if(txtA.getText().length() > maxCaracteres) event.consume();
        });
        
        txtB.setOnKeyTyped(event ->{
            int maxCaracteres = 2;
            if(txtB.getText().length() > maxCaracteres) event.consume();
        });
        
        txtC.setOnKeyTyped(event ->{
            int maxCaracteres = 2;
            if(txtC.getText().length() > maxCaracteres) event.consume();
        });
        
        txtA.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, 
                String newValue)-> {

            if(!newValue.matches("[0-9]")) {
                txtA.setText(newValue.replaceAll("[^0-9]",""));
            }
          
        });
        
        txtB.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, 
                String newValue)-> {

            if(!newValue.matches("[0-9]")) {
                txtB.setText(newValue.replaceAll("[^0-9]",""));
            }
          
        });
        
        txtC.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, 
                String newValue)-> {

            if(!newValue.matches("[0-9]")) {
                txtC.setText(newValue.replaceAll("[^0-9]",""));
            }
          
        });
          
        txtTriangulo.setDisable(true);
    }

    public void mayor (int a, int b, int c) {
        
        int mayor;
        
        if(a > b) {
            if(a > c) {
                
                if(a<=((b + c) - 1)) {
                    txtTriangulo.setText("Es escaleno");
                }else {
                    txtTriangulo.setText("No es un triangulo");
                }
            } else {
                
                if(c<=((a + b) - 1)) {
                    txtTriangulo.setText("Es escaleno");
                }else {
                    txtTriangulo.setText("No es un triangulo");
                }
            }
        }else{
            if( b > c) {
                
                if(b<=((a + c) - 1)) {
                    txtTriangulo.setText("Es escaleno");
                }else {
                    txtTriangulo.setText("No es un triangulo");
                }
            }else {
               if(c<=((a + b) - 1)) {
                    txtTriangulo.setText("Es escaleno");
                }else {
                    txtTriangulo.setText("No es un triangulo");
                }
            }
        }
    }
}
