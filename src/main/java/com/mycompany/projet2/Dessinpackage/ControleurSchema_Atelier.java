/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Dessinpackage;

import com.mycompany.projet2.Modelepackage.Machine;
import static com.mycompany.projet2.NewFXMain.getCreation;
import java.util.ArrayList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 *
 * @author chach
 */
public class ControleurSchema_Atelier {
    private VueSchema_Atelier vue;
    private ArrayList<Rec> liste_recs = new ArrayList<Rec>();
    private ArrayList<Machine> LMA = new ArrayList<Machine>();
    private Pane leftPane;
    
    public ControleurSchema_Atelier(VueSchema_Atelier vue) {
        this.vue = vue;
    }
    
    public void Afficher_Atelier() {
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
                
            //schema.setAlignment(Pos.CENTER);
            Pane schema = new Pane();
            schema.getChildren().addAll(rectangle, text);
            schema.setLayoutX(this.liste_recs.get(i).getOri_x());
            schema.setLayoutY(this.liste_recs.get(i).getOri_y());
              
            this.leftPane.getChildren().addAll(schema);
        }
        
    }
}
