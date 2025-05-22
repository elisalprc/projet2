/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Dessinpackage;

import static com.mycompany.projet2.Dessinpackage.Rec.Initialisation_Liste_rec;
import com.mycompany.projet2.Modelepackage.Machine;
import static com.mycompany.projet2.NewFXMain.getCreation;
import java.util.ArrayList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author chach
 */
public class VueSchema_Atelier {
    
    private VBox leftPane;

    private ArrayList<Rec> liste_recs = new ArrayList<Rec>();
    private ArrayList<Machine> LMA = new ArrayList<Machine>();
    private Button VueAtelier;
    
    public VBox getVueAt() {
        return leftPane;
    }
    
    public VueSchema_Atelier(VBox leftPane){
        this.leftPane = leftPane;
        
        leftPane.getChildren().clear(); //il faut impérativement nettoyer avant d'afficher :')
        //this.vue.getVueAt().getChildren().clear(); //pour que les affichages ne s'empilent pas 
        this.LMA = getCreation().getAtelier().getListeMachines();
        this.liste_recs = Rec.Initialisation_Liste_rec(LMA);
        
        for (int i = 0; i< this.liste_recs.size(); i++){
            Rec rec = this.liste_recs.get(i);
            Text text = new Text ("Mach_"+(i+1));
            Rectangle rectangle = new Rectangle();
            rectangle.setX(rec.getOri_x());
            rectangle.setY(this.liste_recs.get(i).getOri_y());
            rectangle.setWidth(this.liste_recs.get(i).getLar());
            rectangle.setHeight(this.liste_recs.get(i).getLon());
            rectangle.setStroke(Color.BLACK);
            rectangle.setFill(Color.WHITE); 
            
        // Il faut d'abord appliquer le texte à une scène temporaire pour que la taille soit calculée
   /* text.applyCss();
    double textWidth = text.getLayoutBounds().getWidth();
    double textHeight = text.getLayoutBounds().getHeight();

    // Positionner le texte au centre du rectangle
    text.setX((width - textWidth) / 2);
    text.setY((height + textHeight) / 2 - 3); // -3 pour ajuster le centrage vertical

    Pane schema = new Pane();
    schema.setPrefSize(width, height);
    schema.getChildren().addAll(rectangle, text);

    schema.setLayoutX(rec.getOri_x());
    schema.setLayoutY(rec.getOri_y());

    this.leftPane.getChildren().add(schema);*/
                
            //schema.setAlignment(Pos.CENTER);
            Pane schema = new Pane();
            schema.getChildren().addAll(rectangle, text); //, text
            schema.setLayoutX(this.liste_recs.get(i).getOri_x());
            schema.setLayoutY(this.liste_recs.get(i).getOri_y());
              
            this.leftPane.getChildren().addAll(schema);
        }
        
    }
     
}
            
