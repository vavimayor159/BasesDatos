/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobases;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author Ivan
 */
public class PantallaPrincipal {
    private BorderPane principal;
    private Button btn;
    private AnchorPane botonesPedido;
    
    
    public PantallaPrincipal(){
        principal = new BorderPane();
        btn.setText("Say 'Hello World'");
        btn.getStyleClass().add("botonServicio");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        botonesPedido = agregarBotonesPedido();
        principal.setBottom(botonesPedido);
        principal.setCenter(btn);
    }
    
    private AnchorPane agregarBotonesPedido() {
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

    public BorderPane getPrincipal() {
        return principal;
    }
    
}
