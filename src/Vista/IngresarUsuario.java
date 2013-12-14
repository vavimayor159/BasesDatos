/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import ControladorPrincipal.ControlaVistas;
import ControladorPrincipal.ControlaBaseDatos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 *
 * @author vavimayor159
 */
public class IngresarUsuario {
    private GridPane formulario;
    private BorderPane capaBase;
    private TextoNeon textos;
    
    public IngresarUsuario(){
        formulario = new GridPane();
        capaBase = new BorderPane();
        capaBase.getStyleClass().add("principal");
        textos = new TextoNeon();
    }
    
    public BorderPane preparaFormulario(){
        formulario.setAlignment(Pos.CENTER);
        formulario.setHgap(10);
        formulario.setVgap(12);
        formulario.setPadding(new Insets(25, 25, 25, 25));

        Label userName = new Label("User Name:");
        formulario.add(userName, 0, 1);

        final TextField userTextField = new TextField();
        formulario.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        formulario.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        formulario.add(pwBox, 1, 2);
        
        final Text actiontarget = new Text();
        formulario.add(actiontarget, 1, 6);
        
        Button ingresar = new Button("Ingresar");
        ingresar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(ControlaBaseDatos.buscaCliente(userTextField.getText())){
                    ControlaVistas.muestraFormaPedido(
                            ControlaBaseDatos.obtenCliente(
                            userTextField.getText()));
                } else {
                    ControlaVistas.muestraVistaRegistro();
                }
            }
        });
        Button cancelar = new Button("Cancelar");
        cancelar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ControlaVistas.muestraVistaPrincipal();
            }
        });
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().addAll(cancelar, ingresar);
        formulario.add(hbBtn, 1, 4);
        
        capaBase.setCenter(formulario);
        capaBase.setTop(textos.neoniza("Ingresa"));
        return capaBase;
    }
    
}
