/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Vuepackage;

import com.mycompany.projet2.Controleurpackage.ControleurModifierPoste;
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
    private ControleurModifierPoste ctlmp;
    private VBox panneauAjoutMachines;
    private TilePane inter = new TilePane();
    private GridPane affichage = new GridPane();
    private TextField rposte;
    private TextField dposte;
    private TextField req;
    private TextField deq;
    private Button btnEnr;
    private ArrayList<Machine> listMach = new ArrayList<Machine>();
    private ArrayList<Poste> listPoste = new ArrayList<Poste>();
    private ArrayList<Machine> listM = new ArrayList<Machine>();
    
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
        this.listM = getCreation().getAtelier().getListeMachines();
        affichage.getChildren().clear();
        ArrayList<Machine> machinesDisponibles = new ArrayList<>(listM);
        ArrayList<Machine> machinesDuPoste = new ArrayList<>(poste.getListeMachine());
        machinesDisponibles.removeAll(machinesDuPoste);
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
        inter.setAlignment(Pos.CENTER_LEFT); 
        for (Machine machine : machinesDuPoste) {
        Button btn = new Button(machine.getRefMachine());
        inter.getChildren().add(btn);
        }

        form.add(inter, 0, 4, 5, 1); // sur deux colonnes
        
        Button btnAjtMach = new Button("Ajouter des Machines");
        form.add(btnAjtMach, 0, 5);
        panneauAjoutMachines = new VBox(); // vide au départ
        form.add(panneauAjoutMachines, 0, 6, 2, 1);
        btnAjtMach.setOnAction(evt->{
            panneauAjoutMachines.getChildren().clear(); // on vide en premier
            if(machinesDisponibles.isEmpty()){
                Label info = new Label("Toutes les machines sont déjà affectées à ce poste.");
                panneauAjoutMachines.getChildren().add(info);
            }
            else{
                TilePane panneauMachines = new TilePane();
                panneauMachines.setHgap(5);
                panneauMachines.setVgap(5);
                panneauMachines.setPrefColumns(5);
                for (Machine m : machinesDisponibles) {
                    Button btn = new Button(m.getRefMachine());
                    btn.setOnAction(e -> {
                        machinesDuPoste.add(m); // ajouter au poste
                        panneauMachines.getChildren().remove(btn);// retirer le bouton de l'affichage
                        machinesDisponibles.remove(m);
                    });
                    panneauMachines.getChildren().add(btn);
                }

                panneauAjoutMachines.getChildren().add(panneauMachines);
            }
        });
        
        //Boutton pour supprimer des Machines
        Button btnSuppMach = new Button("Supprimer des Machines");
        form.add(btnSuppMach, 0, 7);
        btnSuppMach.setOnAction(evt-> {
            panneauAjoutMachines.getChildren().clear();
            Label infoSupp = new Label("Cliquez sur une machine pour la supprimer.");
            form.add(infoSupp, 0, 9, 2, 1); // ligne 8, span sur 2 colonnes (ajuste si besoin)

            inter.getChildren().clear(); // Vider puis recréer les boutons avec leur logique de suppression
            for (Machine machine : poste.getListeMachine()) {
            Button btn = new Button(machine.getRefMachine());
            btn.setOnAction(e -> {
                machinesDuPoste.remove(machine); // retirer de la liste
                inter.getChildren().remove(btn);   // retirer de l'affichage
                form.getChildren().remove(infoSupp); //supprimer le text, sinon il reste indéfiniment
                machinesDisponibles.add(machine); //ajouter la machine à la liste des machines restantes
                });
            inter.getChildren().add(btn);
            }
        });
        
        btnEnr = new Button("Enregistrer");
        btnEnr.setOnAction(evt->{
            panneauAjoutMachines.getChildren().clear();
            this.ctlmp = new ControleurModifierPoste(this);
            poste.setListeMachine(machinesDuPoste);
            this.ctlmp.ModifierP(poste);
        });
        Button btnRetour = new Button("Retour");
        btnRetour.setOnAction(e -> AfficherListePostes());
    
        HBox boutonsBas = new HBox(10, btnEnr, btnRetour);
        boutonsBas.setAlignment(Pos.CENTER_LEFT);
        form.add(boutonsBas, 0, 8, 2, 1);
        
        affichage.getChildren().setAll(form);
    }
    
}
