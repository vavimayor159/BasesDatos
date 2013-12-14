/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import ControladorPrincipal.ControlaBaseDatos;
import ControladorPrincipal.ControlaVistas;
import ControladorPrincipal.Usuario;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 *
 * @author vavimayor159
 */
public class FormaRegistro {
    private GridPane formulario;
    private BorderPane capaBase;
    private TextoNeon textos;
    
    public FormaRegistro(){
        formulario = new GridPane();
        capaBase = new BorderPane();
        capaBase.getStyleClass().add("principal");
        textos = new TextoNeon();
    }
    
    public BorderPane muestraFormulario(){
        formulario.setAlignment(Pos.CENTER);
        formulario.setHgap(8);
        formulario.setVgap(12);
        formulario.setPadding(new Insets(25, 25, 25, 25));
        
        Text noEncontrado = new Text("Parece que eres nuevo por aqui, por favor "
                + "\n ingresa tus datos para realizar tu pedido"
                + "\n y agregarte a nuestras promociones");
        formulario.add(noEncontrado, 0, 0, 2, 1);
        
        Label nom = new Label("Nombre:");
        formulario.add(nom, 0, 1);

        final TextField campoNombre = new TextField();
        formulario.add(campoNombre, 1, 1);

        Label tel = new Label("Telefono");
        formulario.add(tel, 0, 2);

        final TextField telefono = new TextField();
        formulario.add(telefono, 1, 2);
        
        Label dir = new Label("Direccion");
        formulario.add(dir, 0, 3);
        
        final TextField direccion = new TextField();
        formulario.add(direccion, 1, 3);
        
        Button registrar = new Button("Registrarse");
        
        registrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String nombre = campoNombre.getText();
                int telefonoObtenido;
                telefonoObtenido = Integer.parseInt(telefono.getText());
                String direccionObtenida = direccion.getText();
                ControlaBaseDatos.agregaCliente(nombre, telefonoObtenido, direccionObtenida);
                ControlaVistas.muestraFormaPedido(new Usuario(nombre, telefonoObtenido, direccionObtenida));
            }
        });
        Button regresar = new Button("Regresar");
        regresar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ControlaVistas.muestraFormulario();
            }
        });
        
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().addAll(regresar, registrar);
        formulario.add(hbBtn, 1, 6);
        
        formulario.setGridLinesVisible(true);
        capaBase.setTop(textos.neoniza("Registrate"));
        capaBase.setCenter(formulario);
        return capaBase;
    }
    
    
}
