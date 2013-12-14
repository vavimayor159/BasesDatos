/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

/**
 *
 * @author vavimayor159
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBase {
    /*Variable para almacenar la URL de conexión a nuestra Base de Datos, 
     * si esta estuviera en otra máquina, necesitariamos estar registrados en ella 
     * y contar con su IP*/
    private final String url = "jdbc:postgresql://localhost:5432/TiendaBagguetes";
    private final String pass = "megayo";
    private Connection conexion;
    private Statement stmt;

    public ConexionBase(){
        try{
            System.out.println("Se va a conectar con la base de datos");
            //Acceso al Driver
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection( url,"postgres", pass);
            stmt = conexion.createStatement();
            
        }
        catch( Exception e ){

            //Por si ocurre un error
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void cierraConexion(){
        try {
            stmt.close();
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public Statement getStmt() {
        return stmt;
    }
    
}
