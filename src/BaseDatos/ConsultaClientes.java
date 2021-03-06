/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import ControladorPrincipal.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vavimayor159
 */
public class ConsultaClientes{
    private ConexionBase conexionPrimaria;
    /*Un ResultSet es un arreglo temporal donde se almacenará el resultado de la consulta SQL*/
    private ResultSet rs;
    // Donde podemos ejecutar nuestras consultas
    private Statement stmt;

    public ConsultaClientes(){
        conexionPrimaria = new ConexionBase();
        stmt = conexionPrimaria.getStmt();
    }
    
    
    public LinkedList<String> nombresClientes(){
        String query = "SELECT nombre FROM Clientes";
        LinkedList<String> resultado;
        resultado = new LinkedList<>();
        try {
            rs = stmt.executeQuery(query);
            while(rs.next()){
                resultado.add(rs.getString("nombre"));
            }
            stmt.execute("END");
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public LinkedList<String> nombresClentes(String condicion){
        String query = "SELECT nombre FROM Clientes WHERE " + condicion;
        LinkedList<String> resultado;
        resultado = new LinkedList<>();
        try {
            rs = stmt.executeQuery(query);
            while(rs.next()){
                resultado.add(rs.getString("nombre"));
            }
            stmt.execute("END");
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public Usuario obtenerUsuario(String nombre){
        Usuario resultado = null;
        int telefono = 0;
        String nombreResultado = "", direccion = "";
        String query = "SELECT * FROM Clientes WHERE nombre = " +
                "\'"+ nombre + "\'";
        try {
            rs = stmt.executeQuery(query);
            while(rs.next()){
                nombreResultado = rs.getString("nombre");
                telefono = rs.getInt("telefono");
                direccion = rs.getString("direccion");
                
            }
            resultado = new Usuario(nombreResultado, telefono, direccion);
            stmt.execute("END");
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    
    // Por seguridad se ejecuta la consulta cada vez en lugar de tener
    // almacenados los datos
    public boolean estaRegistrado(String nombreUsuario){
        
        String query = "SELECT nombre FROM Clientes";
        LinkedList<String> resultado;
        resultado = new LinkedList<>();
        try {
            rs = stmt.executeQuery(query);
            while(rs.next()){
                resultado.add(rs.getString("nombre"));
            }
            stmt.execute("END");
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado.contains(nombreUsuario);
    }
    
    public boolean agregaUsuario(String nombre, int telefono, String direccion){
        boolean ejecutada = false;
        String query = "INSERT INTO Clientes VALUES(" + 
                "\'"+ nombre + "\'" + ", " +
                telefono + ", " + "\'" + direccion + "\'" + ")";
        try {
            stmt.executeUpdate(query);
                ejecutada = true;
            stmt.execute("END");
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ejecutada;
    }
}
