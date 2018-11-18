package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class ControladorVisualizar implements Initializable {

  @FXML
  private TableView<Producto> tbvisualizar;
  private BufferedReader br;
  
  public void leerArchivo() {
    List<Producto> lista = new ArrayList<>();
    String[] arreglo = new String[5];
    try {
      FileReader file = new FileReader("C:\\Users\\jethr\\eclipse-workspace\\Archivo\\archivo.txt");
      br = new BufferedReader(file);
      String cadena = null;
      String str = null;
      int i=0;
      StringTokenizer st;
      
      while ((cadena=br.readLine())!=null) {
        
          if (!cadena.equals("---------")) {
            arreglo[i] = str;
            i++;
          }
        i = 0;
        lista.add(new Producto(arreglo[0],arreglo[1],arreglo[2],arreglo[3],arreglo[4]));
      }
      
      ObservableList<Producto> listaObservable = FXCollections.observableArrayList(lista);
      
      tbvisualizar.setItems(listaObservable);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @FXML
  private void salir() {
    Stage stage = new Stage();
    try {
        Parent root = FXMLLoader.load(getClass().getResource("Principal.fxml"));
        Scene scene = new Scene(root);


        stage.setScene(scene);
        stage.show();
        cerrarPrincipal();
        
    } catch (IOException ex) { 
       Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
   } 
  }
  
  private void cerrarPrincipal() {
    
    Stage stage = (Stage) tbvisualizar.getScene().getWindow();
    stage.close();
    
  }
  
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    // TODO Auto-generated method stub
    leerArchivo();
    tbvisualizar.setDisable(false);
  }

}
