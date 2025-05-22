/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Controleurpackage;

import com.mycompany.projet2.Modelepackage.*;
import com.mycompany.projet2.Vuepackage.VueModifierPoste;
import java.util.ArrayList;
import javafx.event.ActionEvent;

/**
 *
 * @author clema
 */
public class ControleurModifierPoste {
    private VueModifierPoste vue = new VueModifierPoste();

    public ControleurModifierPoste(VueModifierPoste vue) {
        this.vue = vue;
    }
    
    public void ModifierP(Poste poste){
        String nvrposte = this.vue.getRposte().getText();
        String nvdposte = this.vue.getDposte().getText();
        ArrayList<Machine> ListeM = this.vue.getListMach();
        poste.modifierPoste(nvrposte, nvdposte, ListeM);
    }
    
    
}
