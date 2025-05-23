/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Controleurpackage;

import com.mycompany.projet2.Modelepackage.Machine;
import com.mycompany.projet2.Modelepackage.Poste;
import static com.mycompany.projet2.NewFXMain.getCreation;
import com.mycompany.projet2.Vuepackage.VueAjtPoste;
import javafx.event.ActionEvent;

/**
 *
 * @author clema
 */
public class ControleurPoste {
    private VueAjtPoste vue = new VueAjtPoste();
    
     public ControleurPoste(VueAjtPoste vue) {
        this.vue = vue;
    }
    
    //methodes / evenements
    
    public void ajtPost(ActionEvent t) {
        Poste poste;
        poste = new Poste(this.vue.getDposte().getText(), this.vue.getRposte().getText(), this.vue.getListMach(),this.vue.getReq().getText(),this.vue.getDeq().getText());
        poste.afficherPoste();
        getCreation().getAtelier().ajoutPoste(poste);
        } 
    
}
