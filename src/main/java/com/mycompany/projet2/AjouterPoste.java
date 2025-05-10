/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2;

/**
 *
 * @author clema
 */
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

   
public class AjouterPoste extends NewFXMain {
    
    public GridPane getVue() {
    GridPane pane = new GridPane();
    pane.setAlignment(Pos.CENTER);
    pane.setHgap(9.9);
    pane.setVgap(9.9);
       
       //les refs de poste :
       pane.add(new Label("reference du poste :"),0,0);
       TextField rposte = new TextField();
       pane.add(rposte, 1, 0);
       pane.add(new Label("id du poste :"),0,1);
       TextField dposte = new TextField();
       pane.add(dposte, 1, 1);
       pane.add(new Label("référence de l'équipement :"),0,2);
       TextField req = new TextField();
       pane.add(req, 1, 2);
       pane.add(new Label("id de l'équipement :"),0,3);
       TextField deq = new TextField();
       pane.add(deq, 1, 3);
       
       
       //la description (ajoutée au début, histoire d'un peu comprendre. C'est pas une variable du coup)
       pane.add(new Label("description du poste :"), 0, 4);
       TextField descposte = new TextField();
       pane.add(descposte, 1, 4);
       
       //ajouter une machine à la liste de machine et voir les diff machines ajoutées (ne se fait donc pas automatiquement)
       pane.add(new Label("Machines :"),0,5);
       Button btAddMachPoste = new Button("Ajouter machine "); 
       pane.add(btAddMachPoste, 0, 6);
       Button btAffiMachPoste = new Button("Afficher les machines du poste");
       pane.add(btAffiMachPoste, 0, 7);
       
       //enregistrer le poste, ou le supprimer
       Button btAddPoste = new Button("Ajouter le poste");
       Button btAnnul = new Button("Supprimer le poste");
       pane.add(btAddPoste, 0, 8);
       pane.add(btAnnul, 1, 8);
       
       btAddMachPoste.setOnAction(evt -> {
           TextField AddMachine = new TextField();
           pane.add(AddMachine, 1, 4);
       });
       
       //pour ajouter le poste à la liste : 
       btAddPoste.setOnAction(evt ->{
           ArrayList<Machine> listeMach = new ArrayList<>();
           Poste poste = new Poste(rposte.getText(), dposte.getText(), listeMach, req.getText(), deq.getText()); 
           
           //+ ajouter tout ce qu'il faut pour mettre le poste ds un dossier (?)
       });
        //pour supprimer les infos (à faire plus tard, il faut que je vois comment on fait à la maison. Same pour afficher la liste des machines) : 
        btAnnul.setOnAction(evt ->{
            rposte.clear();
            dposte.clear();
            descposte.clear();
        });
            
       //pour ouvrir la fenetre, avec le pane et tout (même si ça c'est juste pour tester):
       return pane;
    }
    
}
