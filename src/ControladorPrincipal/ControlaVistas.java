/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorPrincipal;

import Vista.FormaPedido;
import Vista.IngresarUsuario;
import Vista.PantallaPrincipal;
import Vista.FormaRegistro;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author vavimayor159
 */
public class ControlaVistas {
    private static Stage primaryStage;
    private static PantallaPrincipal primera;
    private static IngresarUsuario formulario;
    private static FormaRegistro registro;
    private static FormaPedido pedido;
    private static Scene index;
    private static Scene escenaFormulario;
    private static Scene escenaPrincipal;
    private static Scene escenaRegistro;
    private static Scene escenaPedido;
    private static Usuario usuario;
    
    public ControlaVistas(Stage primaryStage){
        ControlaVistas.primaryStage = primaryStage;
        ControlaVistas.primaryStage.setFullScreen(true);
        ControlaVistas.primaryStage.setTitle("Tienda");
    }
    
    public static void muestraVistaPrincipal(){
        ControlaVistas.usuario = null;
        primera = new PantallaPrincipal(primaryStage);
        escenaPrincipal = new Scene(primera.getPrincipal());
        escenaPrincipal.getStylesheets().add("File:src/Vista/Principal.css");
        primaryStage.setScene(escenaPrincipal);
    }
    
    public static void muestraFormulario(){
        ControlaVistas.usuario = null;
        formulario = new IngresarUsuario();
        escenaFormulario = new Scene(formulario.preparaFormulario());
        escenaFormulario.getStylesheets().add("File:src/Vista/Principal.css");
        primaryStage.setScene(escenaFormulario);
        primaryStage.show();
    }
    
    public static void muestraVistaRegistro(){
        registro = new FormaRegistro();
        escenaRegistro = new Scene(registro.muestraFormulario());
        escenaRegistro.getStylesheets().add("File:src/Vista/Principal.css");
        primaryStage.setScene(escenaRegistro);
        primaryStage.show();
    }

    public static void setUsuarioActual(String nombre, int telefono, String direccion) {
        ControlaVistas.usuario = new Usuario(nombre, telefono, direccion);
    }
    
    public static void muestraFormaPedido(Usuario usuario){
        ControlaVistas.setUsuarioActual(usuario.getNombre(), usuario.getTelefono(),
                usuario.getDireccion());
        pedido = new FormaPedido(usuario);
        escenaPedido = new Scene(pedido.muestraFormulario());
        escenaPedido.getStylesheets().add("File:src/Vista/Principal.css");
        primaryStage.setScene(escenaPedido);
        primaryStage.show();
    }
    
    
}
