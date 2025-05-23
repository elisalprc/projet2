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
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

/**
 *
 * @author clema
 */
public class VueConsulterPersonnel extends GridPane {
    private TilePane inter = new TilePane();
    private GridPane affichage = new GridPane();
    private ArrayList<Operateur> listPersonnel; 
    private ArrayList<Equipement> ListeEq;
    private Button btnRetour = new Button("Retour");
    private Button btnVirer = new Button("Virer");

    public ArrayList<Equipement> getListEq() {
        return ListeEq;
    }
    
    public VueConsulterPersonnel() {
        this.listPersonnel = getCreation().getAtelier().getListeOperateurs();
        this.setVgap(0); //avant il y avait 5
        this.setPadding(new Insets(1,1,1,1)); //avant il y avait 10,10,10,10
        affichage.setHgap(0.0); //avant il y avait 5,5
        affichage.setVgap(0.0); //avant il y avait 5,5
        
        AfficherListePersonnel();
        this.getChildren().add(affichage);
    }
    
    private void AfficherListePersonnel(){
        inter.getChildren().clear();
        Button btnChef = new Button("Chef de l'atelier");
        btnChef.setOnAction(evt ->AfficherChefAtelier());
        for (Operateur operateur : listPersonnel) {
            Button btn = new Button(operateur.getNom() + " " + operateur.getPrenom());
            btn.setOnAction(e -> afficherFormulaireOperateur(operateur));
            inter.getChildren().add(btn);
        }
        
        VBox panneauListe = new VBox(20); // 20 = espace vertical entre éléments
        panneauListe.setAlignment(Pos.TOP_LEFT);
        panneauListe.getChildren().addAll(btnChef, inter);
        
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
        form.add(new Label(operateur.getNom()), 1, 0);
        form.add(new Label(operateur.getPrenom()), 1, 1);
        form.add(new Label(Integer.toString(operateur.getId())), 1, 2);
        Button btnListeEq = new Button("Afficher la liste des équipements");
        form.add(btnListeEq, 0, 3);
        btnListeEq.setOnAction(e->{
            inter.getChildren().clear();
            inter.setHgap(5); 
            inter.setVgap(5); 
            inter.setPrefColumns(5); 
            inter.setAlignment(Pos.CENTER_LEFT); 
            for (Equipement equipement : operateur.getListeEquipements()) {
                inter.getChildren().add(new Label(equipement.getRefEquipement() + "; "));
            }
            form.add(inter, 0, 4, 5, 1);
        });
        
        btnRetour.setOnAction(e -> AfficherListePersonnel());
        form.add(btnRetour,0,5);
        btnVirer.setOnAction(evt ->{
            getCreation().getAtelier().supprimerOperateur(operateur);
            AfficherListePersonnel();
        });
        form.add(btnVirer, 1, 5);
        
        affichage.getChildren().setAll(form);
    }

    private void AfficherChefAtelier() {
        inter.getChildren().clear();
        Personne chef = getCreation().getAtelier().getChefAtelier();
        VBox panneauListe = new VBox(20);
        GridPane form = new GridPane(); // on utilise un GridPane pour le layout
        form.setHgap(5);
        form.setVgap(5);
        form.setPadding(new Insets(10));
        
        form.add(new Label("nom :"),0,0);
        form.add(new Label("prenom :"),0,1);
        form.add(new Label("Identifiant :"),0,2);
        form.add(new Label(chef.getNom()), 1, 0);
        form.add(new Label(chef.getPrenom()), 1, 1);
        form.add(new Label(Integer.toString(chef.getId())), 1, 2);
        
        btnRetour.setOnAction(e->AfficherListePersonnel());
        form.add(btnRetour, 0, 3);
        
        affichage.getChildren().setAll(form);
    }
}
