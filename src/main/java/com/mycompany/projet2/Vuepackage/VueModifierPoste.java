/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Vuepackage;

import com.mycompany.projet2.Modelepackage.*;
import static com.mycompany.projet2.NewFXMain.getCreation;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

/**
 *
 * @author clema
 */
public class VueModifierPoste extends GridPane {
    //private ControleurModifierPoste ctlmp;
    private TilePane inter = new TilePane();
    private GridPane affichage = new GridPane();
    private TextField rposte;
    private TextField dposte;
    private TextField req;
    private TextField deq;
    private Button btnEnr;
    private ArrayList<Machine> listMach = new ArrayList<Machine>();
    private ArrayList<Poste> listPoste = new ArrayList<Poste>();

    public TextField getRposte() {
        return rposte;
    }

    public TextField getDposte() {
        return dposte;
    }

    public TextField getReq() {
        return req;
    }

    public TextField getDeq() {
        return deq;
    }

    public Button getBtnAjt() {
        return btnEnr;
    }


    public ArrayList<Machine> getListMach() {
        return listMach;
    }

    public ArrayList<Poste> getListPoste() {
        return listPoste;
    }
    
    public VueModifierPoste() {
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
        GridPane form = new GridPane(); // on utilise un GridPane pour le layout
        form.setHgap(5);
        form.setVgap(5);
        form.setPadding(new Insets(10));
        
        form.add(new Label("référence :"),0,0);
        form.add(new Label("désignation :"),0,1);
        form.add(new Label("référence équipement :"),0,2);
        form.add(new Label("désignation :"),0,3);
        form.add(this.rposte = new TextField(poste.getRefPoste()), 1, 0);
        form.add(this.dposte = new TextField(poste.getdPoste()), 1, 1);
        form.add(new Label(poste.getRefEquipement()), 1, 2);
        form.add(new Label(poste.getdEquipement()), 1, 3);
        inter.getChildren().clear();
        inter.setHgap(5); 
        inter.setVgap(5); 
        inter.setPrefColumns(5); 
        inter.setAlignment(Pos.CENTER); 
        for (Machine machine : poste.getListeMachine()) {
        Button btn = new Button(machine.getRefMachine());
        inter.getChildren().add(btn);
        }

        form.add(inter, 0, 4, 5, 1); // sur deux colonnes
        
        Button btnAjtMach = new Button("Ajouter des Machines");
        form.add(btnAjtMach, 0, 5);
        
        Button btnSuppMach = new Button("Supprimer des Machines");
        form.add(btnSuppMach, 0, 6);
        
        btnEnr = new Button("Enregistrer");
        Button btnRetour = new Button("Retour");
        btnRetour.setOnAction(e -> AfficherListePostes());
    
        HBox boutonsBas = new HBox(10, btnEnr, btnRetour);
        boutonsBas.setAlignment(Pos.CENTER_LEFT);
        form.add(boutonsBas, 0, 7, 2, 1);
        
        affichage.getChildren().setAll(form);
    }
    
}
