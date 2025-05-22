/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Vuepackage;

import com.mycompany.projet2.Controleurpackage.ControleurPoste;
import com.mycompany.projet2.Modelepackage.Machine;
import static com.mycompany.projet2.NewFXMain.getCreation;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

/**
 *
 * @author clema
 */
public class VueAjtPoste extends GridPane {
    private ControleurPoste ctlp;
    private TilePane inter = new TilePane();
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
        this.add(this.rposte = new TextField(), 1, 0);
        this.add(this.dposte = new TextField(), 1, 1);
        this.add(this.req = new TextField(), 1, 2);
        this.add(this.deq = new TextField(), 1, 3);
        this.btnListMach = new Button("Ajouter des Machines");
        this.add(btnListMach, 0, 4);
        this.btnAjt = new Button("Ajouter le poste");
        VBox inter = new VBox(5); // espacement de 5 entre les boutons
        this.add(inter, 0, 5, 2, 1); // ajoute inter sur 2 colonnes sous btnListMach
        this.add(btnAjt, 0, 7);
        this.btnAnnul = new Button("Annuler");
        this.add(btnAnnul, 1, 7);
        
        this.btnAjt.setOnAction(evt->{
            this.ctlp = new ControleurPoste(this);
            this.ctlp.ajtPost(evt);
        });
        
        ArrayList<Machine> listeM = getCreation().getAtelier().getListeMachines();
        this.btnListMach.setOnAction(evt -> {
        inter.getChildren().clear(); // évite de réafficher les mêmes boutons
        for (Machine machine : listeM) {
            Button btn = new Button(machine.getRefMachine());
            btn.setOnAction(e -> {
                listMach.add(machine);
                inter.getChildren().remove(btn); // supprime du bon conteneur
            });
            inter.getChildren().add(btn);
        }
            this.getChildren().add(inter);
        });
        
        this.btnAnnul.setOnAction(evt ->{
            this.getChildren().clear();
        });
    }

    
    
    
}
