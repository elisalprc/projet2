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
import javafx.scene.layout.HBox;
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
        this.setVgap(0); //avant il y avait 5
        this.setPadding(new Insets(1,1,1,1)); //avant il y avait 10,10,10,10
        affichage.setHgap(0.0); //avant il y avait 5,5
        affichage.setVgap(0.0);
        AfficherListeMachine();
        this.getChildren().add(affichage);
    }
    private void AfficherListeMachine(){
        inter.getChildren().clear();
        for(Machine machine : listeM) {   //prend successivement les valeurs de la liste machine
            Button btn = new Button(machine.getRefMachine()); //avant ct getDmachine
            btn.setOnAction(e -> AfficherFormulaireMachine(machine));
            inter.getChildren().add(btn);
            }
        affichage.getChildren().setAll(inter);
    }
            
    private void AfficherFormulaireMachine(Machine machine){
        affichage.getChildren().clear();
        GridPane form = new GridPane(); // on utilise un GridPane pour le layout
        form.setHgap(5);
        form.setVgap(5);
        form.setPadding(new Insets(10));
        form.add(new Label("Designation"),0,0);
        form.add(new Label("Type"),0,1);
        form.add(new Label("Reference"),0,2);
        form.add(new Label("Etat"),0,3);
        form.add(new Label("Cx"),0,4);
        form.add( new Label("Cy"),0,5);
        form.add(new Label("Cout horaire"),0,6);
        form.add(this.d = new TextField(machine.getDmachine()),1,0);
        form.add(this.type = new TextField(machine.getType()),1,1);
        form.add(this.ref = new TextField(machine.getRefMachine()),1,2);
        form.add(this.etat = new TextField(machine.getEtat()),1,3);
        form.add(this.cx = new TextField(String.valueOf(machine.getOrigine_x())),1,4);  //String.valueOf(<double>)
        form.add(this.cy = new TextField(String.valueOf(machine.getOrigine_y())),1,5);
        form.add(this.coutH = new TextField(String.valueOf(machine.getCout())),1,6);
        this.btModif = new Button("Enregistrer");          
        btModif.setOnAction(ev-> {
            this.ctrlM=new ControleurModifierMachine(this);
            this.ctrlM.modifierM(machine);
        });
        Button btnRetour = new Button("Retour");
        btnRetour.setOnAction(e -> AfficherListeMachine());
    
        HBox boutonsBas = new HBox(10, btModif, btnRetour);
        boutonsBas.setAlignment(Pos.CENTER_LEFT);
        form.add(boutonsBas, 0, 8, 2, 1);
        
        affichage.getChildren().setAll(form);
    }
        


//ouiiiii 
// dans chaque vue rajouter un message qui convient de la bonne execution 
    
}
