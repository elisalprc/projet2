/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Controleurpackage;

import com.mycompany.projet2.Modelepackage.*;
import com.mycompany.projet2.Vuepackage.VueModifierPersonnel;
import java.util.ArrayList;
import javafx.event.ActionEvent;

/**
 *
 * @author clema
 */
public class ControleurModifierOperateur {
    VueModifierPersonnel vue = new VueModifierPersonnel();

    public ControleurModifierOperateur(VueModifierPersonnel vue) {
        this.vue = vue;
    }
    
    public void ModifierOp(Operateur operateur){
        String nvnom = this.vue.getNomPers().getText();
        String nvprenom = this.vue.getPrenomPers().getText();
        int nvId = Integer.parseInt(this.vue.getIdPers().getText());
        ArrayList<Equipement> ListeEq = this.vue.getListEq();
        operateur.ModifierOperateur(nvnom, nvprenom, nvId, ListeEq);
    }
    
}
