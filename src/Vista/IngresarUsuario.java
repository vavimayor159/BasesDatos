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
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author vavimayor159
 */
public class IngresarUsuario {
    private GridPane formulario;
    private BorderPane capaBase;
    
    public IngresarUsuario(){
        formulario = new GridPane();
        capaBase = new BorderPane();
        capaBase.getStyleClass().add("principal");
    }
    
    public BorderPane preparaFormulario(){
        formulario.setAlignment(Pos.CENTER);
        formulario.setHgap(10);
        formulario.setVgap(12);
        formulario.setPadding(new Insets(25, 25, 25, 25));
        
        formulario.add(creaTitulo(), 0, 0, 2, 1);

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
                System.out.println(userTextField.getPromptText());
                if(ControlaBaseDatos.buscaCliente(userTextField.getPromptText())){
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("Esta en la base de datos");
                } else {
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("No esta en la base de datos");
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
        return capaBase;
    }
    
    private Text creaTitulo(){
        Text datosUsuario = new Text("Ingresa");
        
        datosUsuario.setFont(Font.loadFont("file:Resources/fonts/Delicious-Heavy.otf", 100));
        datosUsuario.setFill(Color.WHITE);
        
        Blend blend = new Blend();
        blend.setMode(BlendMode.MULTIPLY);

        DropShadow ds = new DropShadow();
        ds.setColor(Color.rgb(254, 235, 66, 0.3));
        ds.setOffsetX(5);
        ds.setOffsetY(5);
        ds.setRadius(5);
        ds.setSpread(0.2);

        blend.setBottomInput(ds);

        DropShadow ds1 = new DropShadow();
        ds1.setColor(Color.web("#f13a00"));
        ds1.setRadius(20);
        ds1.setSpread(0.2);

        Blend blend2 = new Blend();
        blend2.setMode(BlendMode.MULTIPLY);

        InnerShadow is = new InnerShadow();
        is.setColor(Color.web("#feeb42"));
        is.setRadius(9);
        is.setChoke(0.8);
        blend2.setBottomInput(is);

        InnerShadow is1 = new InnerShadow();
        is1.setColor(Color.web("#f13a00"));
        is1.setRadius(5);
        is1.setChoke(0.4);
        blend2.setTopInput(is1);

        Blend blend1 = new Blend();
        blend1.setMode(BlendMode.MULTIPLY);
        blend1.setBottomInput(ds1);
        blend1.setTopInput(blend2);

        blend.setTopInput(blend1);
        
        datosUsuario.setEffect(blend);
        
        return datosUsuario;
    }
}
