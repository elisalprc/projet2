/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Vuepackage;

import com.mycompany.projet2.Controleurpackage.ControleurPersonnel;
import com.mycompany.projet2.Modelepackage.Equipement;
import com.mycompany.projet2.Modelepackage.Operateur;
import com.mycompany.projet2.Modelepackage.Personne;
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
public class VueAjtPersonnel extends GridPane {
    private ControleurPersonnel ctlp = new ControleurPersonnel();
    private TilePane inter = new TilePane();
    private GridPane affichage = new GridPane();
    private ArrayList<Personne> listPersonnel; 
    private TextField idPers; 
    private TextField nomPers; 
    private TextField prenomPers; 
    private Button btnListEq;
    private Button btnAjt;
    private Button btnAnnul;
    
    public VueAjtPersonnel(){
        this.setHgap(5.5);
        this.setVgap(5.5);
        this.setAlignment(Pos.CENTER);
        this.add(new Label("nom :"),0,0);
        this.add(new Label("prénom :"),0,1);
        this.add(new Label("identifiant :"),0,2);
        this.add(this.nomPers = new TextField(), 1, 0);
        this.add(this.prenomPers = new TextField(), 1, 1);
        this.add(this.idPers = new TextField(), 1, 2);
        this.btnListEq = new Button("Ajouter des Equipement");
        this.add(btnListEq, 0, 3);
        this.btnAjt = new Button("Ajouter l'opérateur");
        VBox inter = new VBox(5); // espacement de 5 entre les boutons
        this.add(inter, 0, 5, 2, 1); // ajoute inter sur 2 colonnes sous btnListMach
        this.add(btnAjt, 0, 7);
        this.btnAnnul = new Button("Annuler");
        this.add(btnAnnul, 1, 7);
        
        this.btnAjt.setOnAction(evt->{
            //this.ctlp = new ControleurPersonnel(this);
            //this.ctlp.ajtPost(evt);
        });
        
        ArrayList<Equipement> listeEq = getCreation().getAtelier().getListeEq();
        this.btnListEq.setOnAction(evt -> {
        inter.getChildren().clear(); // évite de réafficher les mêmes boutons
        for (Equipement equipement : listeEq) {
            Button btn = new Button(equipement.getRefEquipement());
            btn.setOnAction(e -> {
                listeEq.add(equipement);
                inter.getChildren().remove(btn); // supprime du bon conteneur
            });
            inter.getChildren().add(btn);
        }
            this.getChildren().add(inter);
        });
        
        this.btnAnnul.setOnAction(evt ->{
            this.getChildren().clear();
        });
    }
}
