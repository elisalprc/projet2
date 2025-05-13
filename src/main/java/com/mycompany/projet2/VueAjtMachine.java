/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2;


import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


/**
 *
 * @author elisa
 */
public class VueAjtMachine extends GridPane {
    private ControleurMachine ctrlM;
    private Atelier model; // utile pour ajouter la machine dans l'atelier 
    private TextField d;
    private TextField type;
    private TextField ref;
    private TextField etat;
    private TextField cx;
    private TextField cy;
    private TextField coutH;
    private TextField temps;
    private Button btAjt;

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

    public TextField getTemps() {
        return temps;
    }

    
    
    public ControleurMachine getM() {
        return this.ctrlM;
    }
   
    public VueAjtMachine() {        //pour modif machine on aura besoin d'un argument machine (modele)
        //il faudrait arriver à passer atelier en argument pour pouvoi rajt la mach cree 
        
        //this.model = atelier;            
        this.setHgap(5.5);
        this.setVgap(5.5);
        this.setAlignment(Pos.CENTER);
        this.add(new Label("Designation"),0,0);
        this.add(new Label("Type"),0,1);
        this.add(new Label("Reference"),0,2);
        this.add(new Label("Etat"),0,3);
        this.add(new Label("Cx"),0,4);
        this.add( new Label("Cy"),0,5);
        this.add(new Label("Cout horaire"),0,6);
        this.add(new Label("Temps"),0,7);
        this.add(this.d = new TextField(),1,0);
        this.add(this.type = new TextField(),1,1);
        this.add(this.ref = new TextField(),1,2);
        this.add(this.etat = new TextField(),1,3);
        this.add(this.cx = new TextField(),1,4);
        this.add(this.cy = new TextField(),1,5);
        this.add(this.coutH = new TextField(),1,6);
        this.add(this.temps = new TextField(),1,7);
        this.btAjt = new Button("Ajouter");
        this.add(btAjt,1,8);

        this.btAjt.setOnAction((t) -> {
            this.ctrlM=new ControleurMachine(this);
            this.ctrlM.ajtM(t);
        });
        }
        
        
    
   
}
