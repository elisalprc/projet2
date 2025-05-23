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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
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
        for(Produit produit : LPRO) {   //prend successivement les valeurs de la liste des produits
            Button btn = new Button(produit.getCodeproduit());
            btn.setOnAction(e -> {
                //interface de modification apparaît 
                affichage.getChildren().clear();
                affichage.add(new Label("Code"),1,1);
                affichage.add(new Label("Désignation"),1,2);
 
                affichage.add(this.codeproduit = new TextField(produit.getCodeproduit()),2,1);
                affichage.add(this.dproduit = new TextField(produit.getDproduit()),2,2);
                this.getChildren().add(affichage);
                this.btModif_Produit = new Button("Enregistrer");
                affichage.add(btModif_Produit,1,4);                
                btModif_Produit.setOnAction(ev-> {
                    this.ctrlPro=new ControleurModifierProduit(this);
                    this.ctrlPro.modifierP(produit);
                    System.out.println(toString());
                });
                
            Button supp = new Button("Supprimer le produit");
            supp.setOnAction(s-> {
                this.ctrlPro = new ControleurModifierProduit(this);
                this.ctrlPro.supprimerP(produit);
            });
            affichage.add(supp,1,5);
                
        });
            
            inter.getChildren().add(btn);
        }
            this.getChildren().add(inter);
    }
    
// dans chaque vue rajouter un message qui convient de la bonne execution 
}
