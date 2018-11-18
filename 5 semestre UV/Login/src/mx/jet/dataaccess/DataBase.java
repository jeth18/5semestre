 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.jet.dataaccess;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Jethran Gomez
 */
public class DataBase {
    public static Connection connection;
    private Statement statement;
    public static DataBase database;
    
    private DataBase() {
    }
    
    private static void setConnection(){
        Configuracion configuracion= new Configuracion();
        Properties configuracionProperties = null;
        try {
            configuracionProperties = configuracion.loadConfiguracion();
            String url= "jdbc:mysql://"+configuracionProperties.getProperty("server")+"/";
            String databaseName = configuracionProperties.getProperty("database");
            String userName = configuracionProperties.getProperty("username");
            String password = configuracionProperties.getProperty("password");
       
            connection = (Connection)DriverManager.getConnection(url+databaseName,userName,password);
        } catch (IOException | SQLException ex) {
            java.util.logging.Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    
    public static Connection getDataBaseConnection() {
        setConnection();
        return connection;
 
    }
    
    public static void closeConnection(){
        if(connection!=null){
            try {
                if(!connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public ResultSet executeQuery(String query) throws SQLException{
        statement = connection.createStatement();
        ResultSet result =statement.executeQuery(query);
        return result;        
    }
}
