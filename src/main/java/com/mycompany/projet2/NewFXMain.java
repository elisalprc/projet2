/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package com.mycompany.projet2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author elisa
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        GridPane pane1 = new GridPane();
        pane1.setAlignment(Pos.CENTER);
        pane1.setHgap(6.6);
        pane1.setVgap(6.6);
        
        VBox paneV = new VBox();
        paneV.setPadding(new Insets(20, 50, 50, 50));
        paneV.setSpacing(10);
        paneV.getChildren().add(pane1);
        Scene scene = new Scene(paneV, 600, 300);  
        primaryStage.setScene(scene);               
        primaryStage.setTitle("Atelier");        
        primaryStage.show();
        
        MenuButton menuMachine = new MenuButton("Machines");
        MenuItem ajtMachine = new MenuItem("Ajouter ");
        MenuItem modifMachine = new MenuItem("Modifier");
        MenuItem voirMachine = new MenuItem("Consulter liste");
        
        ajtMachine.setOnAction(e -> {
        // Changer vers la scène 1
        });
        modifMachine.setOnAction(e -> {
         // Changer vers la scène 2
        });
        voirMachine.setOnAction(e -> {
         // Changer vers la scène 3
        });
        menuMachine.getItems().addAll(ajtMachine,modifMachine,voirMachine);
       
        pane1.add(menuMachine, 0, 0);
        
        MenuButton menuPoste = new MenuButton("Postes");
        MenuItem ajtPoste = new MenuItem("Ajouter ");
        MenuItem modifPoste = new MenuItem("Modifier");
        MenuItem voirPoste = new MenuItem("Consulter liste");
        
        ajtPoste.setOnAction(e -> {
        // Changer vers la scène 1
        });
        modifPoste.setOnAction(e -> {
         // Changer vers la scène 2
        });
        voirPoste.setOnAction(e -> {
         // Changer vers la scène 3
        });
        
        menuPoste.getItems().addAll(ajtPoste,modifPoste,voirPoste);
       
        pane1.add(menuPoste, 1, 0);
        
        MenuButton menuGamme = new MenuButton("Gammes");
        MenuItem ajtGamme = new MenuItem("Ajouter ");
        MenuItem modifGamme = new MenuItem("Modifier");
        MenuItem voirGamme = new MenuItem("Consulter liste");

        ajtGamme.setOnAction(e -> {
        // Changer vers la scène 1
        });
        modifGamme.setOnAction(e -> {
         // Changer vers la scène 2
        });
        voirGamme.setOnAction(e -> {
         // Changer vers la scène 3
        });

        menuGamme.getItems().addAll(ajtGamme,modifGamme,voirGamme);
       
        pane1.add(menuGamme, 2, 0);
        
        MenuButton menuProduit = new MenuButton("Produits");
        MenuItem ajtProduit = new MenuItem("Ajouter ");
        MenuItem modifProduit = new MenuItem("Modifier");
        MenuItem voirProduit = new MenuItem("Consulter liste");

        ajtProduit.setOnAction(e -> {
        // Changer vers la scène 1
        });
        modifProduit.setOnAction(e -> {
         // Changer vers la scène 2
        });
        voirProduit.setOnAction(e -> {
         // Changer vers la scène 3
        });

        menuProduit.getItems().addAll(ajtProduit,modifProduit,voirProduit);
       
        pane1.add(menuProduit, 3, 0);
        
        MenuButton menuPersonnel = new MenuButton("Personnel");
        MenuItem ajtPersonnel = new MenuItem("Ajouter ");
        MenuItem modifPersonnel = new MenuItem("Modifier");
        MenuItem voirPersonnel = new MenuItem("Consulter liste");

        ajtPersonnel.setOnAction(e -> {
        // Changer vers la scène 1
        });
        modifPersonnel.setOnAction(e -> {
         // Changer vers la scène 2
        });
        voirPersonnel.setOnAction(e -> {
         // Changer vers la scène 3
        });

       menuPersonnel.getItems().addAll(ajtPersonnel,modifPersonnel,voirPersonnel);
       
       pane1.add(menuPersonnel, 4, 0);
       
       Button fiabilite =  new Button("Fiabilité");
       pane1.add(fiabilite, 5, 0);
       
       fiabilite.setOnAction(e ->{
           
       });
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);   
    }  
}