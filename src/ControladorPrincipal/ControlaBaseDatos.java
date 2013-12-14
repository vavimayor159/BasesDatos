/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorPrincipal;

import BaseDatos.ConsultaClientes;
import java.util.LinkedList;

/**
 *
 * @author vavimayor159
 */
public class ControlaBaseDatos {
    private static ConsultaClientes clientes;
    public ControlaBaseDatos(){
        clientes = new ConsultaClientes();
    }
    
    public static boolean buscaCliente(String cliente){
        return clientes.estaRegistrado(cliente);
    }
    
    public static LinkedList<String> listaClientes(){
        return clientes.nombresClientes();
    }
    
    public static LinkedList<String> listaClientes(String condicion){
        return clientes.nombresClentes(condicion);
    }
    
    public static boolean agregaCliente(String nombre, int telefono, String direccion){
        return clientes.agregaUsuario(nombre, telefono, direccion);
    }
    
    public static Usuario obtenCliente(String nombre){
        return clientes.obtenerUsuario(nombre);
    }
}
