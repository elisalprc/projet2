/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Vuepackage;

import com.mycompany.projet2.Controleurpackage.ControleurModifierProduit;
import com.mycompany.projet2.Modelepackage.Produit;
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

/**
 *
 * @author chach
 */
public class VueModifierProduit extends TilePane { //pourquoi un extends Tilpane ?? c'est quoi ??
    //attributs :
    private ArrayList<Produit> LPRO = new ArrayList<Produit>();
    private ControleurModifierProduit ctrlPro;
    private GridPane affichage = new GridPane();
    private Button btModif_Produit;
    private TilePane inter = new TilePane();
    //on met les attributs de produit en TextField pour pouvoir les modifier et rentrer :)
    private TextField codeproduit;
    private TextField dproduit;
    
    //getters : 
    public TextField getCodeproduit(){
        return codeproduit;
    }
    public TextField getDproduit(){
        return dproduit;
    }
    public ArrayList<Produit> getLPRO(){
        return LPRO;
    }
    
    public VueModifierProduit() {
        this.LPRO = getCreation().getAtelier().getListeProduits();
        this.setVgap(5);
        this.setPadding(new Insets(5,1,5,1));
        affichage.setHgap(1.5);
        affichage.setVgap(3.0);
        AfficherListeProduits();
        this.getChildren().add(affichage);
    }
    
    private void AfficherListeProduits(){
        inter.getChildren().clear();
        for(Produit produit : LPRO) {   //prend successivement les valeurs de la liste des produits
            Button btn = new Button(produit.getCodeproduit());
            btn.setOnAction(e -> AfficherFormulaireProduits(produit));
            inter.getChildren().add(btn);
        }
        affichage.getChildren().setAll(inter);
    }
    private void AfficherFormulaireProduits(Produit produit){
        affichage.getChildren().clear();
        GridPane form = new GridPane(); // on utilise un GridPane pour le layout
        form.setHgap(5);
        form.setVgap(5);
        form.setPadding(new Insets(10));
        form.getChildren().clear();
        form.add(new Label("Code"),1,1);
        form.add(new Label("Désignation"),1,2);
        form.add(this.codeproduit = new TextField(produit.getCodeproduit()),2,1);
        form.add(this.dproduit = new TextField(produit.getDproduit()),2,2);
        this.btModif_Produit = new Button("Enregistrer");
        form.add(btModif_Produit,1,4);                
        btModif_Produit.setOnAction(ev-> {
            this.ctrlPro=new ControleurModifierProduit(this);
            this.ctrlPro.modifierP(produit);
            System.out.println(toString());
        });
        
        Button btnRetour = new Button("Retour");
        btnRetour.setOnAction(e -> AfficherListeProduits());
    
        HBox boutonsBas = new HBox(10, btModif_Produit, btnRetour);
        boutonsBas.setAlignment(Pos.CENTER_LEFT);
        form.add(boutonsBas, 0, 8, 2, 1);
        affichage.getChildren().add(form);
    }
    
// dans chaque vue rajouter un message qui convient de la bonne execution 
}
