/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorPrincipal;

import Vista.IngresarUsuario;
import Vista.PantallaPrincipal;
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
    private static Scene index;
    private static Scene escenaFormulario;
    private static Scene escenaPrincipal;
    
    public ControlaVistas(Stage primaryStage){
        ControlaVistas.primaryStage = primaryStage;
        ControlaVistas.primaryStage.setFullScreen(true);
        ControlaVistas.primaryStage.setTitle("Tienda");
    }
    
    public static void muestraVistaPrincipal(){
        primera = new PantallaPrincipal(primaryStage);
        escenaPrincipal = new Scene(primera.getPrincipal());
        escenaPrincipal.getStylesheets().add("File:src/Vista/Principal.css");
        primaryStage.setScene(escenaPrincipal);
    }
    
    public static void muestraFormulario(){
        formulario = new IngresarUsuario();
        escenaFormulario = new Scene(formulario.preparaFormulario());
        escenaFormulario.getStylesheets().add("File:src/Vista/Principal.css");
        primaryStage.setScene(escenaFormulario);
        primaryStage.show();
    }
}
