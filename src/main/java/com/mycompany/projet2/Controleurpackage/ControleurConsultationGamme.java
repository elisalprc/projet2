/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Controleurpackage;

import com.mycompany.projet2.Modelepackage.Gamme;
import com.mycompany.projet2.Vuepackage.VueConsultationGamme;
import javafx.scene.control.Label;

/**
 *
 * @author eleprince01
 */
public class ControleurConsultationGamme {
    private VueConsultationGamme vue;
    
    public ControleurConsultationGamme(VueConsultationGamme vue) {
        this.vue = vue;
    }
    
    public void voirG(Gamme gamme) {
        this.vue.getAffichage().getChildren().clear();
        this.vue.getAffichage().getChildren().add(new Label(gamme.toString()));
    }
    
}
