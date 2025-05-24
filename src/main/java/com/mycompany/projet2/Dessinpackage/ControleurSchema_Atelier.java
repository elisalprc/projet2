/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Dessinpackage;

import com.mycompany.projet2.Modelepackage.Machine;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;

/**
 *
 * @author chach
 */
public class ControleurSchema_Atelier {
    private VueSchema_Atelier vue;
    private ArrayList<Rec> liste_recs = new ArrayList<Rec>();
    private ArrayList<Machine> LMA = new ArrayList<Machine>();
    private Pane leftPane;
    
   // this.vue.afficherAtelier();
    public ControleurSchema_Atelier(VueSchema_Atelier vue) {
        this.vue = vue;
    }

     public void Afficher_Schema(ActionEvent t) {
        //this.vue.getVueAt().getChildren().clear();
        leftPane.getChildren().setAll(new VueSchema_Atelier());
        //VueSchema_Atelier vueAtelier = new VueSchema_Atelier();
        
    }
}
