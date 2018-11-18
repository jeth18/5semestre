package style;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JFileChooser;

/**
 * Esta clase es el controlador de FXMLStyle
 * @author jethran Gomez
 */
public class StyleController implements Initializable {
    
  /**
   * textfield del file donde se encontrara la ruta del archivo 
   */
  @FXML
  private TextField txtFile;
    
  /**
   * Button para buscar un archivo 
   */
  @FXML
  private Button examinar;
    
  /**
   * Button para analizar el archivo
   */
  @FXML
  private Button analizar;
    
  /**
   * textArea aqui se mostrar el resultado de lo analizado
   */
  @FXML
  private TextArea txtArea;
    
  /**
   * Este metodo sirve para cargar un filechooser y poder cargar un metodo
   * @param event informacion del evento
   */
  @FXML
  private void fileChooser(ActionEvent event) {
      
    JFileChooser chooser = new JFileChooser();
    chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
      
    int returnVal = chooser.showOpenDialog(null);
      
    if (returnVal == JFileChooser.APPROVE_OPTION) {
      txtFile.setText(chooser.getSelectedFile().toString());
      analizar.setDisable(false);
    } 
  }
  
  /**
   * Este metodo sirve para analizar la ruta con el estilo de google 
   * e imprime en el txtArea el resultado
   * @param event informacion del evento
   */
  @FXML
  private void analizar(ActionEvent event) {
      
    try {
      String[] cmd = {"cmd","/c", "java -jar checkstyle-8.2-all.jar -c google_checks.xml "
              + txtFile.getText()};
              
      Process proceso = Runtime.getRuntime().exec(cmd);
              
      BufferedReader input =
          new BufferedReader(new InputStreamReader(proceso.getInputStream()));
              
      String linea;
      txtArea.setDisable(false);    
      while ((linea = input.readLine()) != null) {
        txtArea.setText(txtArea.getText() + "\n" + linea);
      }
              
      input.close();
            
    } catch (IOException error) {
      error.printStackTrace();
    }
  }
  
  /**
   * Este metodo declara algunas variables para que no puedan ser editables por 
   * el usuario
   * @param url direccion de referencia
   * @param rb recursos
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
      
    txtFile.setDisable(true);
    analizar.setDisable(true);
    txtArea.setDisable(true);
      
  }    
}
