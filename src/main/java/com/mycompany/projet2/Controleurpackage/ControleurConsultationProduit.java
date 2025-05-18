/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Controleurpackage;

import com.mycompany.projet2.Modelepackage.Produit;
import com.mycompany.projet2.Vuepackage.VueConsultationProduit;
import javafx.scene.control.Label;

/**
 *
 * @author chach
 */
public class ControleurConsultationProduit {
    private VueConsultationProduit vue;
    
    public ControleurConsultationProduit(VueConsultationProduit vue) {
        this.vue = vue;
    }
    
    public void voirP(Produit produit) {
        this.vue.getAffichage().getChildren().clear(); //pour que les affichages ne s'empilent pas 
        this.vue.getAffichage().getChildren().add(new Label(produit.toString()));
    }
}
