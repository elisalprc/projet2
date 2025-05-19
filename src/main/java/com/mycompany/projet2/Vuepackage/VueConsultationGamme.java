/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Vuepackage;

import com.mycompany.projet2.Controleurpackage.ControleurConsultationGamme;
import com.mycompany.projet2.Modelepackage.Gamme;
import static com.mycompany.projet2.NewFXMain.getCreation;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

/**
 *
 * @author eleprince01
 */
public class VueConsultationGamme extends TilePane {
    private ArrayList<Gamme> ListeGamme;
    private ControleurConsultationGamme ctrlG;
    private VBox affichage; 
    
    public VBox getAffichage() {
        return affichage;
    }
    
    public VueConsultationGamme() {
        this.ListeGamme = getCreation().getAtelier().getListeGamme();
        this.setVgap(5);
        this.setPadding(new Insets(10,10,10,10));
        this.getChildren().add(affichage = new VBox());
        for(Gamme gamme : this.ListeGamme) {
            Button btn = new Button(gamme.getRefGamme());
            btn.setOnAction(e-> {
                this.ctrlG=new ControleurConsultationGamme(this);
                this.ctrlG.voirG(gamme);
            });
            this.getChildren().add(btn);
            }
        }
    }
    

