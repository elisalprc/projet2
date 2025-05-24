/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Vuepackage;

import com.mycompany.projet2.Controleurpackage.ControleurConsultationMachine;
import com.mycompany.projet2.Controleurpackage.ControleurMachine;
import com.mycompany.projet2.Modelepackage.Machine;
import static com.mycompany.projet2.NewFXMain.getCreation;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;


/**
 *
 * @author elisa
 */  
    public class VueConsultationMachine extends TilePane {   //smooth 
    private ArrayList<Machine> listeM; 
    private ControleurConsultationMachine ctrlM;
    private VBox affichage;
    
    public VBox getAffichage(){
        return this.affichage;
    }
    public VueConsultationMachine() {
        //exception a gerer si getCreation() renvoie null ==> pas encore d'atelier 
        this.listeM = getCreation().getAtelier().getListeMachines();
        this.setVgap(5);
        this.setPadding(new Insets(10,10,10,10));
        this.affichage = new VBox(10);
        AfficherListeMachine();
        this.getChildren().add(affichage);
    }
        
    
    private void AfficherListeMachine(){
        affichage.getChildren().clear();
        for(Machine machine : listeM) {   //prend successivement les valeurs de la liste machine
            Button btn = new Button(machine.getDmachine());
            btn.setOnAction(e -> AfficherFormulaireMachine(machine));
            affichage.getChildren().add(btn);
        }
    }
    
    private void AfficherFormulaireMachine(Machine machine){
        affichage.getChildren().clear();
        this.ctrlM=new ControleurConsultationMachine(this);
        this.ctrlM.voirM(machine);
        Button btnRetour = new Button("retour");
        btnRetour.setOnAction(evt->AfficherListeMachine());
        Button btnSupp = new Button("Supprimer");
        btnSupp.setOnAction(evt-> {
            getCreation().getAtelier().supprimerMachine(machine);
            AfficherListeMachine();
        });
        HBox boxBtn = new HBox();
        boxBtn.setSpacing(10);
        boxBtn.getChildren().addAll(btnRetour, btnSupp);
        affichage.getChildren().add(boxBtn);
    }
}
