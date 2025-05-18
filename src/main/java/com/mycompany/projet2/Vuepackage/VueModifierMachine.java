/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Vuepackage;


import com.mycompany.projet2.Controleurpackage.ControleurModifierMachine;
import com.mycompany.projet2.Modelepackage.Atelier;
import com.mycompany.projet2.Modelepackage.Machine;
import static com.mycompany.projet2.NewFXMain.getCreation;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;


/**
 *
 * @author elisa
 */
public class VueModifierMachine extends TilePane {
    private ArrayList<Machine> listeM;
    private ControleurModifierMachine ctrlM;
    private GridPane affichage = new GridPane();
    private TilePane inter = new TilePane();
    private TextField d;
    private TextField type;
    private TextField ref;
    private TextField etat;
    private TextField cx;
    private TextField cy;
    private TextField coutH;
    private Button btModif;

    public ArrayList<Machine> getListeM() {
        return listeM;
    }

    public TextField getD() {
        return d;
    }

    public TextField getType() {
        return type;
    }

    public TextField getRef() {
        return ref;
    }

    public TextField getEtat() {
        return etat;
    }

    public TextField getCx() {
        return cx;
    }

    public TextField getCy() {
        return cy;
    }

    public TextField getCoutH() {
        return coutH;
    }
    
    public VueModifierMachine() {
        this.listeM = getCreation().getAtelier().getListeMachines();
        this.setVgap(5);
        this.setPadding(new Insets(10,10,10,10));
        affichage.setHgap(5.5);
        affichage.setVgap(5.5);
        for(Machine machine : listeM) {   //prend successivement les valeurs de la liste machine
            Button btn = new Button(machine.getDmachine());
            btn.setOnAction(e -> {
                //interface de modification apparaît 
                
                affichage.add(new Label("Designation"),0,0);
                affichage.add(new Label("Type"),0,1);
                affichage.add(new Label("Reference"),0,2);
                affichage.add(new Label("Etat"),0,3);
                affichage.add(new Label("Cx"),0,4);
                affichage.add( new Label("Cy"),0,5);
                affichage.add(new Label("Cout horaire"),0,6);
                affichage.add(this.d = new TextField(machine.getDmachine()),1,0);
                affichage.add(this.type = new TextField(machine.getType()),1,1);
                affichage.add(this.ref = new TextField(machine.getRefMachine()),1,2);
                affichage.add(this.etat = new TextField(machine.getEtat()),1,3);
                affichage.add(this.cx = new TextField(String.valueOf(machine.getOrigine_x())),1,4);  //String.valueOf(<double>)
                affichage.add(this.cy = new TextField(String.valueOf(machine.getOrigine_y())),1,5);
                affichage.add(this.coutH = new TextField(String.valueOf(machine.getCout())),1,6);
                this.btModif = new Button("Enregistrer");
                affichage.add(btModif,0,8);                
                btModif.setOnAction(ev-> {
                    this.ctrlM=new ControleurModifierMachine(this);
                    this.ctrlM.modifierM(machine);
                });
                this.getChildren().add(affichage);
        });
            inter.getChildren().add(btn);
        }
            this.getChildren().add(inter);
    }

//ouiiiii 
// dans chaque vue rajouter un message qui convient de la bonne execution 
    
}
