/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Vuepackage;

import com.mycompany.projet2.Controleurpackage.ControleurModifierChefAtelier;
import com.mycompany.projet2.Controleurpackage.ControleurModifierOperateur;
import com.mycompany.projet2.Modelepackage.*;
import static com.mycompany.projet2.NewFXMain.getCreation;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

/**
 *
 * @author clema
 */
public class VueModifierPersonnel extends GridPane {
    private ControleurModifierOperateur ctlmp;
    private ControleurModifierChefAtelier ctlmc;
    private TilePane inter = new TilePane();
    private GridPane affichage = new GridPane();
    private ArrayList<Operateur> listPersonnel; 
    private ArrayList<Equipement> ListeEq;
    private TextField idPers; 
    private TextField nomPers; 
    private TextField prenomPers; 
    private Button btnListEq;
    private Button btnAjt;
    private Button btnAnnul;
    private Button btnRetour = new Button("Retour");

    public ArrayList<Equipement> getListEq() {
        return ListeEq;
    }

    public TextField getIdPers() {
        return idPers;
    }

    public TextField getNomPers() {
        return nomPers;
    }

    public TextField getPrenomPers() {
        return prenomPers;
    }
    
    public VueModifierPersonnel() {
        this.listPersonnel = getCreation().getAtelier().getListeOperateurs();
        this.setVgap(0); //avant il y avait 5
        this.setPadding(new Insets(1,1,1,1)); //avant il y avait 10,10,10,10
        affichage.setHgap(0.0); //avant il y avait 5,5
        affichage.setVgap(0.0); //avant il y avait 5,5
        
        AfficherChoix();
        this.getChildren().add(affichage);
    }
    
    private void AfficherChoix(){
        inter.getChildren().clear();
        Button btnOp = new Button("Opérateurs");
        Button btnChef = new Button("Chef d'Atelier");
        inter.getChildren().add(btnOp);
        inter.getChildren().add(btnChef);
        btnOp.setOnAction(evt -> AfficherListeOperateurs());
        btnChef.setOnAction(evt-> ModifierChefAtelier());
        affichage.getChildren().setAll(inter);
    }
    
    private void AfficherListeOperateurs(){
        inter.getChildren().clear();
        for (Operateur operateur : listPersonnel) {
            Button btn = new Button(operateur.getNom() + " " + operateur.getPrenom());
            btn.setOnAction(e -> afficherFormulaireOperateur(operateur));
            inter.getChildren().add(btn);
        }
        btnRetour.setOnAction(e->AfficherChoix());
        
        VBox panneauListe = new VBox(20); // 20 = espace vertical entre éléments
        panneauListe.setAlignment(Pos.TOP_LEFT);
        panneauListe.getChildren().addAll(inter, btnRetour);
        
        affichage.getChildren().setAll(panneauListe);
    }
    
    private void afficherFormulaireOperateur(Operateur operateur) {
        this.ListeEq = getCreation().getAtelier().getListeMachines();
        affichage.getChildren().clear();
        ArrayList<Equipement> EquipementsDisponibles = new ArrayList<>(ListeEq);
        ArrayList<Equipement> EquipementDeOperateur = new ArrayList<>(operateur.getListeEquipements());
        EquipementsDisponibles.removeAll(EquipementDeOperateur);
        GridPane form = new GridPane(); // on utilise un GridPane pour le layout
        form.setHgap(5);
        form.setVgap(5);
        form.setPadding(new Insets(10));
        
        form.add(new Label("nom :"),0,0);
        form.add(new Label("prenom :"),0,1);
        form.add(new Label("Identifiant :"),0,2);
        form.add(this.nomPers = new TextField(operateur.getNom()), 1, 0);
        form.add(this.prenomPers = new TextField(operateur.getPrenom()), 1, 1);
        form.add(this.idPers = new TextField(Integer.toString(operateur.getId())), 1, 2);
        form.add(new Label("Liste des équipements :"), 0, 3);
        inter.getChildren().clear();
        inter.setHgap(5); 
        inter.setVgap(5); 
        inter.setPrefColumns(5); 
        inter.setAlignment(Pos.CENTER_LEFT); 
        for (Equipement equipement : EquipementDeOperateur) {
            Button btn = new Button(equipement.getRefEquipement());
            inter.getChildren().add(btn);
        }

        form.add(inter, 0, 4, 5, 1); // sur deux colonnes
        
        Button btnAjtEq = new Button("Ajouter des Equipements");
        form.add(btnAjtEq, 0, 5);
        VBox panneauAjoutEquipements = new VBox(); // vide au départ
        form.add(panneauAjoutEquipements, 0, 6, 2, 1);
        btnAjtEq.setOnAction(evt->{
            panneauAjoutEquipements.getChildren().clear(); // on vide en premier
            if(EquipementsDisponibles.isEmpty()){
                Label info = new Label("Tous les équipements sont déjà affectées à cet opérateur.");
                panneauAjoutEquipements.getChildren().add(info);
            }
            else{
                TilePane panneauEqipements = new TilePane();
                panneauEqipements.setHgap(5);
                panneauEqipements.setVgap(5);
                panneauEqipements.setPrefColumns(5);
                for (Equipement eq : EquipementsDisponibles) {
                    Button btn = new Button(eq.getRefEquipement());
                    btn.setOnAction(e -> {
                        EquipementDeOperateur.add(eq); // ajouter au poste
                        panneauEqipements.getChildren().remove(btn);// retirer le bouton de l'affichage
                        EquipementsDisponibles.remove(eq);
                    });
                    panneauEqipements.getChildren().add(btn);
                }

                panneauAjoutEquipements.getChildren().add(panneauEqipements);
            }
        });
        
        //Boutton pour supprimer des Machines
        Button btnSuppEq = new Button("Supprimer des Equipements");
        form.add(btnSuppEq, 0, 7);
        btnSuppEq.setOnAction(evt-> {
            panneauAjoutEquipements.getChildren().clear();
            Label infoSupp = new Label("Cliquez sur un Equipement pour la supprimer.");
            form.add(infoSupp, 0, 9, 2, 1); // ligne 8, span sur 2 colonnes (ajuste si besoin)

            inter.getChildren().clear(); // Vider puis recréer les boutons avec leur logique de suppression
            for (Equipement equipement : operateur.getListeEquipements()) {
            Button btn = new Button(equipement.getRefEquipement());
            btn.setOnAction(e -> {
                EquipementDeOperateur.remove(equipement); // retirer de la liste
                inter.getChildren().remove(btn);   // retirer de l'affichage
                form.getChildren().remove(infoSupp); //supprimer le text, sinon il reste indéfiniment
                EquipementsDisponibles.add(equipement); //ajouter la machine à la liste des machines restantes
                });
            inter.getChildren().add(btn);
            }
        });
        
        Button btnEnr = new Button("Enregistrer");
        btnEnr.setOnAction(evt->{
            panneauAjoutEquipements.getChildren().clear();
            this.ctlmp = new ControleurModifierOperateur(this);
            operateur.setListeEquipements(EquipementDeOperateur);
            this.ctlmp.ModifierOp(operateur);
        });
        btnRetour.setOnAction(e -> AfficherListeOperateurs());
    
        HBox boutonsBas = new HBox(10, btnEnr, btnRetour);
        boutonsBas.setAlignment(Pos.CENTER_LEFT);
        form.add(boutonsBas, 0, 8, 2, 1);
        
        affichage.getChildren().setAll(form);
    }

    private void ModifierChefAtelier() {
        inter.getChildren().clear();
        VBox panneauListe = new VBox(20);
        Label titre = new Label("Choisissez le nouveau chef");
        for (Operateur operateur : listPersonnel) {
            Button btn = new Button(operateur.getNom() + " " + operateur.getPrenom());
            btn.setOnAction(e -> {
                Label surEtCertain = new Label("Remplacer le chef actuel par " + operateur.getNom() + " " + operateur.getPrenom() + " :");
                Button btnValider = new Button("Valider");
                panneauListe.getChildren().addAll(surEtCertain, btnValider);
                btnValider.setOnAction(evt -> {
                   this.ctlmc = new ControleurModifierChefAtelier(this);
                    this.ctlmc.ModifierChef(operateur);
                    AfficherChoix();
                });
            });
            inter.getChildren().add(btn);
        }
        btnRetour.setOnAction(e->AfficherChoix());
        
        panneauListe.setAlignment(Pos.TOP_LEFT);
        panneauListe.getChildren().addAll(titre, inter, btnRetour);
        
        affichage.getChildren().setAll(panneauListe);
    }
    
}
