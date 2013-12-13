/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobases;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

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
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());
        primaryStage.setTitle("Tienda");
        primaryStage.setScene(scene);
        scene.getStylesheets().add(ProyectoBases.class.getResource("Principal.css").toExternalForm());
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
