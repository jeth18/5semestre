package mx.jet.dataaccess;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author jethran Gomez
 */
public class Configuracion {
    public Properties loadConfiguracion() throws FileNotFoundException, IOException {        
        Properties properties = new Properties();
        properties.load(this.getClass().getResourceAsStream("configuracion.properties"));
        
        return properties;
    }
}
