/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import ControladorPrincipal.Baguette;
import ControladorPrincipal.Pedido;
import java.util.LinkedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 *
 * @author vavimayor159
 */
public class FormaAlimentos {
    private GridPane listaHechos;
    private GridPane listaRestantes;
    private BorderPane capaBase;
    private TextoNeon textos;
    private Pedido pedido;
    private int cantidadBaguettes;
    private int restantes;
    private int completos;
    private VBox caja;
    
    public FormaAlimentos(Pedido pedido, int cantidadBaguettes){
        caja = new VBox();
        caja.setPadding(new Insets(10));
        caja.setSpacing(8);
        listaHechos = new GridPane();
        listaRestantes = new GridPane();
        listaHechos.getStyleClass().add("formaCosas");
        listaRestantes.getStyleClass().add("formaCosas");
        capaBase = new BorderPane();
        capaBase.getStyleClass().add("principal");
        textos = new TextoNeon();
        this.cantidadBaguettes = cantidadBaguettes;
        this.pedido = pedido;
        restantes = cantidadBaguettes;
        completos = 0;
    }
    
    public BorderPane muestraFormulario(){
        listaRestantes.setAlignment(Pos.CENTER);
        listaRestantes.setPadding(new Insets(25, 25, 25, 25));
        listaHechos.setAlignment(Pos.CENTER);
        listaHechos.setPadding(new Insets(25, 25, 25, 25));
        Text instrucciones = new Text("Por favor ingresa el contenido de las baguettes"
                + "\n seleccionando en cada baguette"
                + "\n las que no sean seleccionadas se eliminaran del pedido");
        listaRestantes.add(instrucciones, 0, 0, 2, 1);
        
        for (int i = 1; i <= restantes; i++){
            Text falta = new Text("Falta preparar esta baguette");
            listaRestantes.add(falta, 0, i, 2, 1);
            Button creaBaguette = new Button("CreaBaguette");
            creaBaguette.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    crearBaguetteNueva();
                }
            });
            listaRestantes.add(creaBaguette, 2, i);
        }
        
        listaHechos.add(new Text("NoBaguette"), 0, 0);
        listaHechos.add(new Text("NoIngredientes"), 1, 0);
        listaHechos.add(new Text("Precio"), 2, 0);
        
        LinkedList<Baguette> baguettesActuales = pedido.getBaguettes();
        for (int i=0; i< completos; i++){
            Baguette tmp = baguettesActuales.get(i);
            int preparado = i + 1;
            listaHechos.add(new Text(preparado + ""), 0, i+1);
            listaHechos.add(new Text(tmp.getNoIngredientes()+ ""), 1, i+1);
            listaHechos.add(new Text(tmp.getPrecioBase() + ""), 2, i+1);
        }
        
        caja.getChildren().addAll(listaRestantes, listaHechos);
        capaBase.setTop(textos.neoniza("Cocina tu pedido"));
        capaBase.setCenter(caja);
        return capaBase;
    }
    
    public void crearBaguetteNueva(){
        
    }
}
