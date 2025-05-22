/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Vuepackage;

import com.mycompany.projet2.Controleurpackage.ControleurPoste;
import com.mycompany.projet2.Modelepackage.Machine;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author clema
 */
public class VueAjtPoste extends GridPane {
    private ControleurPoste ctlp;
    private TextField rposte;
    private TextField dposte;
    private TextField req;
    private TextField deq;
    private Button btnAjt;
    private Button btnAnnul;
    private Button btnListMach;
    private ArrayList<Machine> listMach = new ArrayList<Machine>();

    public ControleurPoste getCtlp() {
        return ctlp;
    }

    public TextField getRposte() {
        return rposte;
    }

    public TextField getDposte() {
        return dposte;
    }

    public TextField getReq() {
        return req;
    }

    public TextField getDeq() {
        return deq;
    }

    public Button getBtnAjt() {
        return btnAjt;
    }

    public Button getBtnAnnul() {
        return btnAnnul;
    }

    public Button getBtnNvlMach() {
        return btnListMach;
    }
    
    public ArrayList<Machine> getListMach(){
        return listMach;
    }
    
    public VueAjtPoste(){
        this.setHgap(5.5);
        this.setVgap(5.5);
        this.setAlignment(Pos.CENTER);
        this.add(new Label("référence :"),0,0);
        this.add(new Label("désignation :"),0,1);
        this.add(new Label("référence équipement :"),0,2);
        this.add(new Label("désignation :"),0,3);
        this.add(new Label("description :"),0,4);
        this.add(rposte, 1, 0);
        this.add(dposte, 1, 1);
        this.add(req, 1, 2);
        this.add(deq, 1, 3);
        this.btnListMach = new Button("Ajouter des Machines");
        this.add(btnListMach, 0, 4);
        this.btnAjt = new Button("Ajouter le poste");
        this.add(btnAjt, 0, 6);
        this.btnAnnul = new Button("Annuler");
        this.add(btnAnnul, 1, 6);
        
        this.btnAjt.setOnAction(evt->{
            this.ctlp = new ControleurPoste(this);
            this.ctlp.ajtPost(evt);
        });
    }

    
    
    
}
