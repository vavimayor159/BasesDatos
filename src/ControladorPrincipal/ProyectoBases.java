/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorPrincipal;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Ivan
 */
public class ProyectoBases extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        ControlaVistas principal = new ControlaVistas(primaryStage);
        ControlaVistas.muestraVistaPrincipal();
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
