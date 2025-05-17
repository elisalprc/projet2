/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Controleurpackage;

import com.mycompany.projet2.Modelepackage.Machine;
import static com.mycompany.projet2.NewFXMain.getCreation;
import com.mycompany.projet2.Vuepackage.VueConsultationMachine;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 *
 * @author elisa
 */
public class ControleurConsultationMachine {
    private VueConsultationMachine vue;
    
    public ControleurConsultationMachine(VueConsultationMachine vue) {
        this.vue = vue;
    }
    
    public void voirM(Machine machine) {
        this.vue.getAffichage().getChildren().clear(); //pour que les affichages ne s'empilent pas 
        this.vue.getAffichage().getChildren().add(new Label(machine.toString()));
    } 
    
 }

