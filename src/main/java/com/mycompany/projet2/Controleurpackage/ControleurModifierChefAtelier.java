/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Controleurpackage;

import com.mycompany.projet2.Modelepackage.*;
import static com.mycompany.projet2.NewFXMain.getCreation;
import com.mycompany.projet2.Vuepackage.VueModifierPersonnel;
import java.util.ArrayList;
import javafx.event.ActionEvent;

/**
 *
 * @author clema
 */
public class ControleurModifierChefAtelier {
    VueModifierPersonnel vue = new VueModifierPersonnel();

    public ControleurModifierChefAtelier(VueModifierPersonnel vue) {
        this.vue = vue;
    }
    
    public void ModifierChef(Operateur operateur){
        Personne exC = getCreation().getAtelier().getChefAtelier();
        String nexC = exC.getNom();
        String pexC = exC.getPrenom();
        int idexC = exC.getId();
        
        String nvnom = operateur.getNom();
        String nvprenom = operateur.getPrenom();
        int nvId = operateur.getId();
        ArrayList<Equipement> ListeEq = operateur.getListeEquipements();
        operateur.ModifierOperateur(nexC, pexC, idexC, ListeEq);
        Personne nvC = new Personne(nvnom, nvprenom, nvId);
        
        getCreation().getAtelier().setChefAtelier(nvC);
    }
}
