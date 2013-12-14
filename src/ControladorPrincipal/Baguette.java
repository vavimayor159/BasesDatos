/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorPrincipal;

import java.util.LinkedList;

/**
 *
 * @author vavimayor159
 */
public class Baguette {
    private String tamaño;
    private int noIngredientes;
    private String tipoPan;
    private int PrecioBase;
    private LinkedList<Ingrediente> ingredientes;

    public Baguette(String tamaño, int noIngredientes, String tipoPan, int PrecioBase) {
        this.tamaño = tamaño;
        this.noIngredientes = noIngredientes;
        this.tipoPan = tipoPan;
        this.PrecioBase = PrecioBase;
    }
    
    public String getTamaño() {
        return tamaño;
    }

    public int getNoIngredientes() {
        return noIngredientes;
    }

    public String getTipoPan() {
        return tipoPan;
    }

    public int getPrecioBase() {
        return PrecioBase;
    }

    public LinkedList<Ingrediente> getIngredientes() {
        return ingredientes;
    }
    
    
    
}
