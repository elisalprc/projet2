/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Controleurpackage;

import com.mycompany.projet2.Modelepackage.Produit;
import static com.mycompany.projet2.NewFXMain.getCreation;
import com.mycompany.projet2.Vuepackage.VueProduit;
import javafx.event.ActionEvent;

/**
 *
 * @author chach
 */
public class ControleurProduit {
    private VueProduit vue = new VueProduit();
    
    public ControleurProduit(VueProduit vue) {
        this.vue = vue;
    }
    
    //methodes / evenements
    
    public void ajtPro(ActionEvent t) {
        Produit produit;
        produit = new Produit(this.vue.getCodeproduit().getText(),
                         this.vue.getDproduit().getText());
        produit.afficherProduit();
        getCreation().getAtelier().ajoutProduit(produit);
        } 
}
