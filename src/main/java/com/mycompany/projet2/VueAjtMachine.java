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
    private TextField d;
    private TextField type;
    private TextField ref;
    private TextField etat;
    private TextField cx;
    private TextField cy;
    private TextField coutH;
    private TextField temps;
    private Button btAjt;
    
    //peut etre que y a pas besoin de les mettre en attribut
    
    public VueAjtMachine() {
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
        }
        
        // ajout machine
        /* Button btAdd = new Button("Ajouter");
        pane.add(btAdd, 0, 8);
        btAdd.setOnAction(evt -> {
             Machine Mach_1 = new Machine(ref.getText(), 
                              type.getText(),
                              d.getText(),
                              Double.parseDouble(cx.getText()),
                              Double.parseDouble(cy.getText()),
                              Double.parseDouble(cout.getText()),
                              Double.parseDouble(tps.getText()),
                              etat.getText());
             ArrayList<Machine> listeMachine = new ArrayList<>(); 
             listeMachine.add(Mach_1);
             
             
        
             }); */
    
   
}

