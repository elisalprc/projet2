/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Controleurpackage;

import com.mycompany.projet2.Modelepackage.Machine;
import com.mycompany.projet2.Vuepackage.VueModifierMachine;
import javafx.scene.control.TextField;

/**
 *
 * @author elisa
 */
public class ControleurModifierMachine {
    private VueModifierMachine vue = new VueModifierMachine();
    
    public ControleurModifierMachine(VueModifierMachine vue) {
        this.vue = vue;
    }
    
    public void modifierM(Machine machine) {
        String nvType = this.vue.getType().getText();
        String nvRef = this.vue.getRef().getText();
        String nvD = this.vue.getD().getText();
        double nvX = Double.parseDouble(this.vue.getCx().getText());
        double nvY = Double.parseDouble(this.vue.getCy().getText());
        double nvCout = Double.parseDouble(this.vue.getCoutH().getText());
        String nvEtat = this.vue.getEtat().getText();
        machine.modifierMachine(nvType,nvRef,nvD,nvX,nvY,nvCout,nvEtat);
        
              
                
    }
    
}
