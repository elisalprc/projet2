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
import java.util.ArrayList;
import javafx.event.ActionEvent;

/**
 *
 * @author elisa
 */
public class ControleurAjoutGamme {
    private VueAjoutGamme vue; 
    private ArrayList<Equipement> eqSelect = new ArrayList<>();
    private ArrayList<Operation> opSelect = new ArrayList<>();
    
    public ControleurAjoutGamme(VueAjoutGamme vue) {
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
    
    public void ajouterG(){
        
        Gamme gamme; 
        gamme = new Gamme(this.vue.getProduit().getValue(),this.vue.getRef().getText(),this.opSelect,this.eqSelect);
        getCreation().getAtelier().ajoutGammeFabrication(gamme);
        // a modifier : (voir classes arrayliste atelier et gamme : constructeur avecd un objet produit en argument 
        // et pas un string.  Je le ferai plus tard car la jpp et ducoup ca initialise par correctement
        // la gamme 
        
    }
    
}
