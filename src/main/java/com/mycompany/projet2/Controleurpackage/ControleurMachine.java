/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Controleurpackage;

import com.mycompany.projet2.Vuepackage.VueAjtMachine;
import com.mycompany.projet2.Modelepackage.Machine;
import static com.mycompany.projet2.NewFXMain.getCreation; //exception ?? 
import java.util.ArrayList;
import javafx.event.ActionEvent;


/**
 *
 * @author eleprince01
 */
public class ControleurMachine {
    private VueAjtMachine vue = new VueAjtMachine();
    
    public ControleurMachine(VueAjtMachine vue) {
        this.vue = vue;
    }
    
    //methodes / evenements
    
    public void ajtM(ActionEvent t) {
        Machine machine;
        machine = new Machine(this.vue.getRef().getText(),
                         this.vue.getType().getText(),
                         this.vue.getD().getText(),
                         Double.parseDouble(this.vue.getCx().getText()),
                         Double.parseDouble(this.vue.getCy().getText()),
                         Double.parseDouble(this.vue.getCoutH().getText()),
                         this.vue.getEtat().getText());
        //gerer l'exception de si getCreation() est null ==> pas d'atelier
        getCreation().getAtelier().ajoutMachine(machine);
        
             } 
        
    }
    

