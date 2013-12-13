/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorPrincipal;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Vista.IngresarUsuario;
import Vista.PantallaPrincipal;

/**
 *
 * @author Ivan
 */
public class ProyectoBases extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        PantallaPrincipal primera = new PantallaPrincipal(primaryStage);
        Scene scene = new Scene(primera.getPrincipal());
        IngresarUsuario a = new IngresarUsuario();
        //Scene scene = new Scene(a.preparaFormulario());
        /*Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight()); */
        primaryStage.setFullScreen(true);
        primaryStage.setTitle("Tienda");
        primaryStage.setScene(scene);
        scene.getStylesheets().add("File:src/Vista/Principal.css");
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
