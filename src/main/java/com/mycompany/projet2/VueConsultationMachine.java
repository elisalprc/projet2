/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;

/**
 *
 * @author elisa
 */
public class VueConsultationMachine extends TilePane {   //smooth 
    
    public VueConsultationMachine(ArrayList<Machine> listeM) {
        this.setVgap(5);
        this.setPadding(new Insets(10,10,10,10));
        int t = listeM.size();
        for(int i=0;i<=t;i++) {
            Button btn = new Button(listeM.get(i).getDmachine());
            this.getChildren().add(btn);
            btn.setOnAction(e -> {
                //afficher les infos en bas dans la fenêtre 
        
        });
        }
    
}
}