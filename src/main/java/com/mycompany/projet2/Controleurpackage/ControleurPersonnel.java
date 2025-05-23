/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Controleurpackage;

import com.mycompany.projet2.Modelepackage.Operateur;
import static com.mycompany.projet2.NewFXMain.getCreation;
import com.mycompany.projet2.Vuepackage.VueAjtPersonnel;
import javafx.event.ActionEvent;

/**
 *
 * @author clema
 */
public class ControleurPersonnel {
    VueAjtPersonnel vue = new VueAjtPersonnel();
    
    public ControleurPersonnel(VueAjtPersonnel vue){
        this.vue = vue;
    }
    
    public void AjtOperateur(ActionEvent t){
        Operateur operateur;
        int id = Integer.parseInt(this.vue.getIdPers().getText());
        operateur = new Operateur(this.vue.getNomPers().getText(), this.vue.getPrenomPers().getText(),id, this.vue.getListEq());
        operateur.afficherOperateur();
        getCreation().getAtelier().ajoutOperateur(operateur);
    }
}
