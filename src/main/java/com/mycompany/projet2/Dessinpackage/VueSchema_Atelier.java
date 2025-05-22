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
    
    
    public VueSchema_Atelier(VBox cadre_at){
        this.leftPane= cadre_at;
    }
    
    public GridPane getVueAt() {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(9.9);
        pane.setVgap(9.9);
        
        this.LMA = getCreation().getAtelier().getListeMachines();
        this.liste_recs = Initialisation_Liste_rec(LMA);
            
            for (int i=0 ; i<this.liste_recs.size();i++) {
                Text text = new Text("Mach_" + (i+1));
                Pane schema = new Pane();
                Rectangle rectangle = new Rectangle();
                rectangle.setX(this.liste_recs.get(i).getOri_x());
                rectangle.setY(this.liste_recs.get(i).getOri_y());
                rectangle.setWidth(this.liste_recs.get(i).getLar());
                rectangle.setHeight(this.liste_recs.get(i).getLon());
                rectangle.setStroke(Color.BLACK);
                rectangle.setFill(Color.WHITE); 
                
                //schema.setAlignment(Pos.CENTER);
                schema.getChildren().addAll(rectangle, text);
                schema.setLayoutX(this.liste_recs.get(i).getOri_x());
                schema.setLayoutY(this.liste_recs.get(i).getOri_y());
                
                this.leftPane.getChildren().addAll(schema);
            } 
            return pane ;
        } 
     
}
            
