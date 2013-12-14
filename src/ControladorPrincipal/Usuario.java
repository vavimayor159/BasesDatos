/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorPrincipal;

/**
 *
 * @author vavimayor159
 */
public class Usuario {
    private String nombre;
    private int Telefono;
    private String direccion;

    public Usuario(String nombre, int Telefono, String direccion) {
        this.nombre = nombre;
        this.Telefono = Telefono;
        this.direccion = direccion;
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getTelefono() {
        return Telefono;
    }

    public String getDireccion() {
        return direccion;
    }
    
}
