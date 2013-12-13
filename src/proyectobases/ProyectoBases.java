/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobases;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Ivan
 */
public class ProyectoBases extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.getStyleClass().add("botonServicio");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        BorderPane root = new BorderPane();
        root.setCenter(btn);
        AnchorPane botonesPedido = agregarBotonesPedido();
        root.setBottom(botonesPedido);
        
        Scene scene = new Scene(root);
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
    
    public HBox botonesServicio() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);

        Button botonActual = new Button("Actual");
        botonActual.getStyleClass().add("botonServicio");

        Button botonSiguiente = new Button("Siguiente");
        botonSiguiente.getStyleClass().add("botonServicio");
        hbox.getChildren().addAll(botonActual, botonSiguiente);

        return hbox;
    }
    
    public AnchorPane agregarBotonesPedido() {
        AnchorPane anchorpane = new AnchorPane();
        Button botonNuevo = new Button("Nuevo Pedido");
        botonNuevo.getStyleClass().add("botonCompras");
        botonNuevo.setPrefSize(150, 100);
        Button botonCancelar = new Button("Cancel");
        botonCancelar.getStyleClass().add("botonServicio");

        HBox hb = new HBox();
        hb.setPadding(new Insets(0, 10, 10, 10));
        hb.setSpacing(10);
        hb.getChildren().addAll(botonCancelar, botonNuevo);

        anchorpane.getChildren().addAll(hb);   // Add grid from Example 1-5
        AnchorPane.setBottomAnchor(hb, 8.0);
        AnchorPane.setRightAnchor(hb, 5.0);

        return anchorpane;
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
