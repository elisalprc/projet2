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
        // this.setVgap(5);
        //this.setPadding(new Insets(10,10,10,10));
        this.getChildren().add(affichage = new VBox(0));
        for(Produit produit : LPRO) {   //prend successivement les valeurs de la liste des produits
            Button btn = new Button(produit.getCodeproduit());
            btn.setOnAction(e -> {
                this.ctrlPro=new ControleurConsultationProduit(this);
                this.ctrlPro.voirP(produit);
        });
            this.getChildren().add(btn);
        }
    
}
    
    
}
