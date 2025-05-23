/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Vuepackage;


import com.mycompany.projet2.Modelepackage.*;
import static com.mycompany.projet2.NewFXMain.getCreation;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

/**
 *
 * @author clema
 */
public class VueConsulterPoste extends GridPane {
    private TilePane inter = new TilePane();
    private GridPane affichage = new GridPane();
    private ArrayList<Poste> listPoste = new ArrayList<Poste>();

    public ArrayList<Poste> getListPoste() {
        return listPoste;
    }
    
    public VueConsulterPoste() {
        this.listPoste = getCreation().getAtelier().getListePostes();
        this.setVgap(0); //avant il y avait 5
        this.setPadding(new Insets(1,1,1,1)); //avant il y avait 10,10,10,10
        affichage.setHgap(0.0); //avant il y avait 5,5
        affichage.setVgap(0.0); //avant il y avait 5,5
        AfficherListePostes();
        this.getChildren().add(affichage);
    }
    private void AfficherListePostes(){
        inter.getChildren().clear();
        for (Poste poste : listPoste) {
            Button btn = new Button(poste.getRefPoste());
            btn.setOnAction(e -> afficherFormulairePoste(poste));
            inter.getChildren().add(btn);
        }
        affichage.getChildren().setAll(inter);
    }
    
    private void afficherFormulairePoste(Poste poste) {
        affichage.getChildren().clear();
        GridPane form = new GridPane(); 
        form.setHgap(5);
        form.setVgap(5);
        form.setPadding(new Insets(10));
        
        form.add(new Label("référence :"),0,0);
        form.add(new Label("désignation :"),0,1);
        form.add(new Label("référence équipement :"),0,2);
        form.add(new Label("désignation :"), 0, 3);
        form.add(new Label("Liste des machines :"), 0, 4);
        
        Label lblRefPoste = new Label(poste.getRefPoste());
        
        lblRefPoste.setWrapText(true);
        lblRefPoste.setMaxWidth(200);  

        Label lblDPoste = new Label(poste.getdPoste());
        lblDPoste.setWrapText(true);
        lblDPoste.setMaxWidth(200);

        Label lblRefEq = new Label(poste.getRefEquipement());
        lblRefEq.setWrapText(true);
        lblRefEq.setMaxWidth(200);

        Label lblDEq = new Label(poste.getdEquipement());
        lblDEq.setWrapText(true);
        lblDEq.setMaxWidth(200);

        form.add(lblRefPoste, 1, 0);
        form.add(lblDPoste, 1, 1);
        form.add(lblRefEq, 1, 2);
        form.add(lblDEq, 1, 3);
        
        inter.getChildren().clear();
        inter.setHgap(5); 
        inter.setVgap(5); 
        inter.setPrefColumns(5); 
        inter.setAlignment(Pos.CENTER_LEFT); 
        for (Machine machine : poste.getListeMachine()) {
            inter.getChildren().add(new Label(machine.getRefMachine() + "; "));
        }
        form.add(inter, 0, 5, 5, 1);
        Button btnRetour = new Button("Retour");
        form.add(btnRetour,0,6);
        btnRetour.setOnAction(evt->AfficherListePostes());
        
        affichage.getChildren().setAll(form);
    }
}
