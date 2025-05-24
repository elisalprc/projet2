/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Vuepackage;

import com.mycompany.projet2.Controleurpackage.ControleurConsultationProduit;
import com.mycompany.projet2.Modelepackage.Produit;
import static com.mycompany.projet2.NewFXMain.getCreation;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

/**
 *
 * @author chach
 */
public class VueConsultationProduit extends TilePane {
    //attributs:
    private ArrayList<Produit> LPRO; 
    private ControleurConsultationProduit ctrlPro;
    private VBox affichage;
    
    //getter:
    public VBox getAffichage() {
        return affichage;
    }
    
    //controleur
    public VueConsultationProduit() {
        //exception a gerer si getCreation() renvoie null ==> pas encore d'atelier 
        this.LPRO = getCreation().getAtelier().getListeProduits();
        this.setVgap(5);
        this.setPadding(new Insets(10,10,10,10));
        this.affichage = new VBox();
        AfficherListeProduits();
        this.getChildren().add(affichage);
    }
    
    private void AfficherListeProduits(){
        affichage.getChildren().clear();
        for(Produit produit : LPRO) {   //prend successivement les valeurs de la liste des produits
            Button btn = new Button(produit.getCodeproduit());
            btn.setOnAction(e -> AfficherFormulaireProduits(produit)); 
            affichage.getChildren().add(btn);
        }
    }
    
    private void AfficherFormulaireProduits(Produit produit){
        affichage.getChildren().clear();
        this.ctrlPro=new ControleurConsultationProduit(this);
        this.ctrlPro.voirP(produit);
        Button btnRetour = new Button("retour");
        btnRetour.setOnAction(evt->AfficherListeProduits());
        Button btnSupp = new Button("Supprimer");
        btnSupp.setOnAction(evt-> {
            getCreation().getAtelier().supprimerProduit(produit);
            AfficherListeProduits();
        });
        HBox boxBtn = new HBox();
        boxBtn.setSpacing(10);
        boxBtn.getChildren().addAll(btnRetour, btnSupp);
        affichage.getChildren().add(boxBtn);
    }
    
}