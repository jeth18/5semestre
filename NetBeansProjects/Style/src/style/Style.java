package style;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Jethran Gómez
 */
public class Style extends Application {

  /**
   * Este metodo sirve para cargar la pagina principal
   *
   * @param stage
   * @throws Exception en caso de un error
   */
  @Override
  public void start(Stage stage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("FXMLStyle.fxml"));

    Scene scene = new Scene(root);

    stage.setScene(scene);
    stage.show();
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }

}
