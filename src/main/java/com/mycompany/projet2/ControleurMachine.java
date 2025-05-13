/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2;

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
    
    void ajtM(ActionEvent t) {
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
             
             
        
             } 
        
    }
    

