/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Controleurpackage;

import com.mycompany.projet2.Modelepackage.Equipement;
import com.mycompany.projet2.Modelepackage.Gamme;
import com.mycompany.projet2.Modelepackage.Operation;
import static com.mycompany.projet2.NewFXMain.getCreation;
import com.mycompany.projet2.Vuepackage.VueAjoutGamme;
import com.mycompany.projet2.Vuepackage.VueModifierGamme;
import java.util.ArrayList;

/**
 *
 * @author elisa
 */
public class ControleurModifierGamme {
    private VueModifierGamme vue; 
    private ArrayList<Equipement> eqSelect = new ArrayList<>();
    private ArrayList<Operation> opSelect = new ArrayList<>();
    
    public ControleurModifierGamme(VueModifierGamme vue) {
        this.vue = vue;
    }
    
    public void ajoutEq(Equipement eq) {
        this.eqSelect.add(eq);
    }
    
    public void suppEq(Equipement eq){
        this.eqSelect.remove(eq);
    }
    
    public void ajoutOp(Operation op) {
        this.opSelect.add(op);
    }
    
    public void suppOp(Operation op) {
        this.opSelect.remove(op);
    }
    
    public void modifierG(Gamme gamme){
        gamme.modifierGamme(this.vue.getProduit().getValue(), this.vue.getRefGamme().getText(), opSelect, eqSelect);
    }
    
    public void supprimerG(Gamme gamme) {
        getCreation().getAtelier().supprimerGammeFabrication(gamme);
    }
    
    
}
