/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Vuepackage;

import com.mycompany.projet2.Controleurpackage.ControleurConsultationMachine;
import com.mycompany.projet2.Controleurpackage.ControleurMachine;
import com.mycompany.projet2.Modelepackage.Machine;
import static com.mycompany.projet2.NewFXMain.getCreation;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;


/**
 *
 * @author elisa
 */
public class VueConsultationMachine extends TilePane {   //smooth 
    private ArrayList<Machine> listeM; 
    private ControleurConsultationMachine ctrlM;
    
    public VueConsultationMachine() {
        this.listeM = getCreation().getAtelier().getListeMachines();
        this.setVgap(5);
        this.setPadding(new Insets(10,10,10,10));
        for(Machine machine : listeM) {   //prend successivement les valeurs de la liste machine 
            Button btn = new Button(machine.getDmachine());
            btn.setOnAction(e -> {
                this.ctrlM=new ControleurConsultationMachine(this);
                this.ctrlM.voirM(machine);
        });
            this.getChildren().add(btn);
        }
    
}
}