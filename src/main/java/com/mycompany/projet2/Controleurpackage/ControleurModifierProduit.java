/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Controleurpackage;

import com.mycompany.projet2.Modelepackage.Produit;
import static com.mycompany.projet2.NewFXMain.getCreation;
import com.mycompany.projet2.Vuepackage.VueModifierProduit;

/**
 *
 * @author chach
 */
public class ControleurModifierProduit {
    //attribut:
    private VueModifierProduit vue = new VueModifierProduit();
    
    //constructeur:
    public ControleurModifierProduit(VueModifierProduit vue){
        this.vue = vue;
    }
    
    //méthode pour modifier un produit :
    public void modifierP(Produit produit) {
        String nv_codeproduit = this.vue.getCodeproduit().getText();
        String nv_dproduit = this.vue.getDproduit().getText();
        
        produit.modifierProduit(nv_codeproduit,nv_dproduit);
    } 
    
    public void supprimerP(Produit p) {
        getCreation().getAtelier().supprimerProduit(p);
    }
}
