/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorPrincipal;

import java.util.Calendar;

/**
 *
 * @author vavimayor159
 */
public class Pedido {
    
    private String nombreCliente;
    private Calendar fecha;
    private String direccionEntrega;
    private String tipoPago;
    private String nombreRepartidor;

    public Pedido(String nombreCliente, Calendar fecha, String direccionEntrega, String tipoPago) {
        this.nombreCliente = nombreCliente;
        this.fecha = fecha;
        this.direccionEntrega = direccionEntrega;
        this.tipoPago = tipoPago;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public String getNombreRepartidor() {
        return nombreRepartidor;
    }
    
    
    
}
