/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobases;


import eu.schudt.javafx.controls.calendar.DatePicker;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Ivan
 */
public class PantallaPrincipal {
    private IngresarUsuario formulario;
    private BorderPane principal;
    private Button btn;
    private Button eligeFecha;
    private AnchorPane botonesPedido;
    private TilePane capaTitulo;
    private Stage primaryStage;
    
    public PantallaPrincipal(Stage primaryStage){
        GridPane gridPane;
        gridPane = new GridPane();
        DatePicker calendario;
        formulario = new IngresarUsuario();
        eligeFecha = new Button("Ver la fecha");
        eligeFecha.getStyleClass().add("botonServicio");
        // Initialize the DatePicker for birthday
        calendario = new DatePicker(Locale.ENGLISH);
        calendario.setDateFormat(new SimpleDateFormat("dd-MM-yyyy"));
        calendario.getCalendarView().todayButtonTextProperty().set("Today");
        calendario.getCalendarView().setShowWeeks(false);
        calendario.getStylesheets().add("File:Resources/DatePicker.css");
        calendario.getPromptText();
        // Add DatePicker to grid
        Text ingresaFecha = new Text("Ingresa la fecha a buscar:");
        gridPane.add(ingresaFecha, 0, 5);
        gridPane.add(calendario, 1, 5);
        gridPane.add(eligeFecha, 3, 5);
        
        this.primaryStage = primaryStage;
        principal = new BorderPane();
        principal.getStyleClass().add("principal");
        btn = new Button();
        capaTitulo = new TilePane();
        capaTitulo.setId("titulo");
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
        GridPane centrado = new GridPane();
        centrado.setAlignment(Pos.CENTER_LEFT);
        centrado.setHgap(10);
        centrado.setVgap(12);
        centrado.add(this.construyeTitulo(), 5, 0);
        principal.setTop(centrado);
        principal.setRight(gridPane);
    }
    
    private AnchorPane agregarBotonesPedido() {
        AnchorPane anchorpane = new AnchorPane();
        Button botonNuevo = new Button("Nuevo Pedido");
        botonNuevo.getStyleClass().add("botonCompras");
        botonNuevo.setPrefSize(150, 100);
        
        botonNuevo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Scene scene1 = new Scene(formulario.preparaFormulario());
                scene1.getStylesheets().add(ProyectoBases.class.getResource("Principal.css").toExternalForm());
                
                primaryStage.setScene(scene1);
            }
        });
        
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
    
    private Text construyeTitulo(){
        Text titulo = new Text("Bienvenido a \"La Baguetera\"");
        titulo.setFont(Font.loadFont("file:Resources/fonts/Delicious-Heavy.otf", 100));
        titulo.setFill(Color.WHITE);
        
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

        Reflection r = new Reflection();
        r.setInput(blend);
        r.setFraction(0.9);
        
        titulo.setEffect(r);
        
        return titulo;
    }
    
}