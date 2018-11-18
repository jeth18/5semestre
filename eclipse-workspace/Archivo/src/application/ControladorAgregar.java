package application;


import java.io.BufferedWriter;
import java.io.FileWriter;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladorAgregar implements Initializable {

  @FXML
  private TextField txtnombre;

  @FXML
  private TextField txtprecio;

  @FXML
  private TextField txtpeso;

  @FXML
  private TextField txtexistencia;

  @FXML
  private TextField txtmarca;

  @FXML
  private Button bagregar;

  @FXML
  private Button bcancelar;

  @FXML
  private void aniadirArchivo() {

    if (txtnombre.getText().equals("") || txtprecio.getText().equals("")
        || txtpeso.getText().equals("") || txtexistencia.getText().equals("")) {

      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Error");
      alert.setHeaderText("Campos vacios");
      alert.setContentText("Ingrese datos en todos los campos");

      alert.showAndWait();

    } else {
      FileWriter flwriter = null;
      try {
        flwriter =
            new FileWriter("C:\\Users\\jethr\\eclipse-workspace\\Archivo\\archivo.txt", true);
        BufferedWriter bfwriter = new BufferedWriter(flwriter);

        bfwriter.write(txtnombre.getText() + "\r\n" + txtpeso.getText() + "\r\n"
            + txtprecio.getText() + "\r\n" + txtexistencia.getText() + "\r\n" + txtmarca.getText()
            + "\r\n" + "---------" + "\r\n");

        bfwriter.close();
        System.out.println("Archivo modificado satisfactoriamente..");
        txtnombre.setText("");
        txtprecio.setText("");
        txtpeso.setText("");
        txtexistencia.setText("");


      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        if (flwriter != null) {
          try {
            flwriter.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }
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

    Stage stage = (Stage) bagregar.getScene().getWindow();
    stage.close();

  }

  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    // TODO Auto-generated method stub

  }

}
