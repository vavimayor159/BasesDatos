/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author vavimayor159
 */
public class TextoNeon {
    private Blend blend;
    private DropShadow ds;
    private DropShadow ds1;
    private Blend blend2;
    private InnerShadow is;
    private InnerShadow is1;
    private Blend blend1;
    
    public TextoNeon(){
        blend = new Blend();
        blend.setMode(BlendMode.MULTIPLY);

        ds = new DropShadow();
        ds.setColor(Color.rgb(254, 235, 66, 0.3));
        ds.setOffsetX(5);
        ds.setOffsetY(5);
        ds.setRadius(5);
        ds.setSpread(0.2);

        blend.setBottomInput(ds);

        ds1 = new DropShadow();
        ds1.setColor(Color.web("#f13a00"));
        ds1.setRadius(20);
        ds1.setSpread(0.2);

        blend2 = new Blend();
        blend2.setMode(BlendMode.MULTIPLY);

        is = new InnerShadow();
        is.setColor(Color.web("#feeb42"));
        is.setRadius(9);
        is.setChoke(0.8);
        blend2.setBottomInput(is);

        is1 = new InnerShadow();
        is1.setColor(Color.web("#f13a00"));
        is1.setRadius(5);
        is1.setChoke(0.4);
        blend2.setTopInput(is1);

        blend1 = new Blend();
        blend1.setMode(BlendMode.MULTIPLY);
        blend1.setBottomInput(ds1);
        blend1.setTopInput(blend2);

        blend.setTopInput(blend1);
    }
    
    public Text neoniza(String texto){
        Text textoNeonizado = new Text(texto);
        textoNeonizado.setFont(Font.loadFont("file:Resources/fonts/Delicious-Heavy.otf", 100));
        textoNeonizado.setFill(Color.WHITE);
        textoNeonizado.setEffect(blend);
        return textoNeonizado;
    }
    
}
