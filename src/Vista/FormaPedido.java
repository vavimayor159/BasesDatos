/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import ControladorPrincipal.ControlaBaseDatos;
import ControladorPrincipal.ControlaVistas;
import ControladorPrincipal.Pedido;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
public class FormaPedido {
    private GridPane formulario;
    private BorderPane capaBase;
    private TextoNeon textos;
    private Date fecha;
    private Pedido pedido;
    
    public FormaPedido(){
        formulario = new GridPane();
        capaBase = new BorderPane();
        capaBase.getStyleClass().add("principal");
        textos = new TextoNeon();
        fecha = new Date();
    }
    
    public BorderPane muestraFormulario(){
        formulario.setAlignment(Pos.CENTER);
        formulario.setHgap(8);
        formulario.setVgap(12);
        formulario.setPadding(new Insets(25, 25, 25, 25));
        
        Text felicitacion = new Text("Felicidades estas apunto de recibir \n"
                + "un delicioso pedido por favor ingresa los datos\n"
                + "de tu pedido");
        formulario.add(felicitacion, 0, 0, 2, 1);
        
        Label nom = new Label("Nombre:");
        formulario.add(nom, 0, 1);

        Label campoNombre = new Label();
        formulario.add(campoNombre, 1, 1);

        Label fec = new Label("Fecha:");
        formulario.add(fec, 0, 2);

        Label fechaActual = new Label(fecha.toString());
        formulario.add(fechaActual, 1, 2);
        
        Label dir = new Label("Direccion:");
        formulario.add(dir, 0, 3);
        
        Label direccion = new Label();
        formulario.add(direccion, 1, 3);
        
        Label noBaguettes = new Label("Cantidad de baguettes:");
        formulario.add(noBaguettes, 0, 4);
        
        final TextField cantidad = new TextField();
        formulario.add(cantidad, 1, 4);
        
        Label formaPago = new Label("Forma de Pago:");
        formulario.add(formaPago, 0, 5);
        
        final ChoiceBox pago = new ChoiceBox(FXCollections.observableArrayList(
    "Efectivo", "Tarjeta"));
        
        formulario.add(pago, 1, 5);
        
        Button agregarPedido = new Button("Realizar Pedido");
        
        agregarPedido.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String nombre = campoNombre.getText();
                int telefonoObtenido;
                telefonoObtenido = Integer.parseInt(telefono.getText());
                String direccionObtenida = direccion.getText();
                ControlaBaseDatos.agregaCliente(nombre, telefonoObtenido, direccionObtenida);
                ControlaVistas.muestraFormaPedido();
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
