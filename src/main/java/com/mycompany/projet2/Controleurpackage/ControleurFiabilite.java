/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Controleurpackage;

import static com.mycompany.projet2.Modelepackage.ArrayListe_Atelier.LMA;
import com.mycompany.projet2.Vuepackage.SceneFiabilite;
//import static com.mycompany.projet2.Vuepackage.SceneFiabilite.Convertion_LMA_LM;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;

/**
 *
 * @author chach
 */
public class ControleurFiabilite {
    private VBox cadreFiab;
    
    private SceneFiabilite vue = new SceneFiabilite(cadreFiab);
    
    public ControleurFiabilite(SceneFiabilite vue) {
        this.vue = vue;
    }
    
    //methodes / evenements
    
    public void Afficher_Fiabilité(ActionEvent t){
        /*Convertion_LMA_LM(LMA); //on initialise les arraylist en vrai elles le seront déjà mais bon c un test
            String Machine_trouve = machine.getText(); 
            //on l'initialise à une valeur qui n'existe pas pour repérer les erreurs
            double fiab = Afficher_Fiabilite(LM , MachFiabilite , Machine_trouve, stage);
            System.out.println("la fiabilité est : "+fiab);
                fiabilite.setText(Double.toString(fiab));
                pane.add(fiabilite,1,1);
                System.out.println("La fiabilité est bien affichée");
    }
        */
    
    /*public void ajtM(ActionEvent t) {
        Machine machine;
        machine = new Machine(this.vue.getRef().getText(),
                         this.vue.getType().getText(),
                         this.vue.getD().getText(),
                         Double.parseDouble(this.vue.getCx().getText()),
                         Double.parseDouble(this.vue.getCy().getText()),
                         Double.parseDouble(this.vue.getCoutH().getText()),
                         Double.parseDouble(this.vue.getTemps().getText()),
                         this.vue.getEtat().getText());
        machine.afficherMachine();
        //Atelier.ajoutMachine(machine);
             
             
        */
             }
    
}
