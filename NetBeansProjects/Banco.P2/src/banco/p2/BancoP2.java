package banco.p2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * El main para cargar el programa 
 * 
 * @author Jethran Gomez
 * @version 1.0
 * @fecha 2018-08-31
 */
public class BancoP2 extends Application {
    /**
     * Este metodo sirve para cargar la pagina de agregacion del 
     * los datos para verificar el prestamo
     * 
     * @param stage
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLInicioBanco.fxml"));
        
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
