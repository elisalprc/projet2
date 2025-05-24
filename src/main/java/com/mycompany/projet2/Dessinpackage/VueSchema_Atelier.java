/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Dessinpackage;

import com.mycompany.projet2.Modelepackage.Machine;
import static com.mycompany.projet2.NewFXMain.getCreation;
import java.util.ArrayList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author chach
 */
public class VueSchema_Atelier extends Pane{
    
    //private Pane leftPane;

    private ArrayList<Rec> liste_recs = new ArrayList<Rec>();
    private ArrayList<Machine> LMA = new ArrayList<Machine>();
    private Button VueAtelier = new Button("Schéma at");
    private ControleurSchema_Atelier ctrlA;
    
    //public Pane getVueAt() {
    //    return leftPane;
    //}
    
    public VueSchema_Atelier(){
        //this.leftPane = leftPane;
        
        this.getChildren().clear(); //il faut impérativement nettoyer avant d'afficher :')
        //this.vue.getVueAt().getChildren().clear(); //pour que les affichages ne s'empilent pas 
        this.LMA = getCreation().getAtelier().getListeMachines();
        this.liste_recs = Rec.Initialisation_Liste_rec(LMA);
        
       // StackPane stack = new StackPane();

        for (int i = 0; i< this.liste_recs.size(); i++){
            Rec rec = this.liste_recs.get(i);
            Rectangle rectangle = new Rectangle(rec.getOri_x(),rec.getOri_y(),rec.getLar(),rec.getLon());
            //rectangle.setX(this.liste_recs.get(i).getOri_x());
            //rectangle.setY(this.liste_recs.get(i).getOri_y());
            //rectangle.setWidth(this.liste_recs.get(i).getLar());
            //rectangle.setHeight(this.liste_recs.get(i).getLon());
            rectangle.setStroke(Color.BLACK);
            rectangle.setFill(Color.WHITE);
            
            Text text = new Text ("Mach_"+(i+1));
            text.setX(rec.getOri_x() + 11);
            text.setY(rec.getOri_y() + 31);
            
            //this.setAlignment(Pos.CENTER); //this c'est l'objet crée
            this.getChildren().addAll(rectangle, text);
            //this.setLayoutX(liste_recs.get(i).getOri_x());
            //this.setLayoutY(liste_recs.get(i).getOri_y());
              
            //this.leftPane.getChildren().addAll(this);
            this.VueAtelier.setOnAction((t) -> {
            this.ctrlA=new ControleurSchema_Atelier(this);
            this.ctrlA.Afficher_Schema(t);
            
        });
        }
        
    }
     
}
            
