package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControladorPrincipal implements Initializable {

  @FXML
  private Button bagregar;

  @FXML
  private Button bvisualizar;

  @FXML
  private void PaginaAgregar() {
    Stage stage = new Stage();
    try {
      Parent root = FXMLLoader.load(getClass().getResource("Agregar.fxml"));
      Scene scene = new Scene(root);


      stage.setScene(scene);
      stage.show();
      cerrarPrincipal();

    } catch (IOException ex) {
      Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  @FXML
  private void PaginaVisualizar() {
    Stage stage = new Stage();
    try {
      Parent root = FXMLLoader.load(getClass().getResource("Visualizar.fxml"));
      Scene scene = new Scene(root);

      stage.setScene(scene);
      stage.show();
      cerrarPrincipal();

    } catch (IOException ex) {
      Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private void cerrarPrincipal() {

    Stage stage = (Stage) bvisualizar.getScene().getWindow();
    stage.close();

  }

  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    // TODO Auto-generated method stub

  }

}
