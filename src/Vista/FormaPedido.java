/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import ControladorPrincipal.ControlaVistas;
import ControladorPrincipal.Pedido;
import ControladorPrincipal.Usuario;
import java.util.Calendar;
import java.util.Date;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
    private Usuario usuario;
    private String cadenaPago;
    private String entrega;
    
    public FormaPedido(Usuario usuario){
        formulario = new GridPane();
        capaBase = new BorderPane();
        capaBase.getStyleClass().add("principal");
        textos = new TextoNeon();
        fecha = new Date();
        this.usuario = usuario;
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

        Label campoNombre = new Label(usuario.getNombre());
        formulario.add(campoNombre, 1, 1);

        Label fec = new Label("Fecha:");
        formulario.add(fec, 0, 2);

        Label fechaActual = new Label(fecha.toString());
        formulario.add(fechaActual, 1, 2);
        
        Label dir = new Label("Direccion:");
        formulario.add(dir, 0, 3);
        
        Label direccion = new Label(usuario.getDireccion());
        formulario.add(direccion, 1, 3);
        
        final TextField nuevaDireccion = new TextField();
        nuevaDireccion.setPromptText("Solo si la direccion de entrega es distinta"
                + "a la del usuario");
        formulario.add(nuevaDireccion, 2, 3);
        
        Label noBaguettes = new Label("Cantidad de baguettes:");
        formulario.add(noBaguettes, 0, 4);
        
        final TextField cantidad = new TextField();
        formulario.add(cantidad, 1, 4);
        
        Label formaPago = new Label("Forma de Pago:");
        formulario.add(formaPago, 0, 5);
        
        ObservableList<String> opciones = FXCollections.observableArrayList(
        "Efectivo", "Tarjeta");
        
        final ComboBox pago = new ComboBox(opciones);
        pago.setPromptText("Pago");
        pago.valueProperty().addListener(new ChangeListener<String>() {
            @Override 
            public void changed(ObservableValue ov, String t, String t1) {                
                cadenaPago = t1;                
            }    
        });
        
        formulario.add(pago, 1, 5);
        
        final String nombre = usuario.getNombre();
        final Calendar hoy = Calendar.getInstance();
        Button agregarPedido = new Button("Realizar Pedido");
        
        agregarPedido.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int cantidadBaguettes = Integer.parseInt(cantidad.getText());
                if(nuevaDireccion.getText() != null && !"".equals(nuevaDireccion.getText())){
                    entrega = nuevaDireccion.getText();
                } else {
                    entrega = usuario.getDireccion();
                }
                pedido = new Pedido(nombre, hoy,
                        entrega, cadenaPago);
                ControlaVistas.muestraFormaAlimentos(pedido, cantidadBaguettes);
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
        hbBtn.getChildren().addAll(regresar, agregarPedido);
        formulario.add(hbBtn, 1, 6);
        
        formulario.setGridLinesVisible(true);
        capaBase.setTop(textos.neoniza("Detalles de pedido"));
        capaBase.setCenter(formulario);
        return capaBase;
    }
    
}
