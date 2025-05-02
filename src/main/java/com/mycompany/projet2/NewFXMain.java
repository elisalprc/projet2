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
        pane1.setHgap(5.5);
        pane1.setVgap(5.5);
        pane1.add(new Label("Atelier"), 0, 0); //x,y
        
        VBox paneV = new VBox();
        paneV.setPadding(new Insets(20, 50, 50, 50));
        paneV.setSpacing(10);
        paneV.getChildren().add(pane1);
        Scene scene = new Scene(paneV, 300, 300);  
        primaryStage.setScene(scene);               
        primaryStage.setTitle("Atelier");        
        primaryStage.show();
        
        MenuButton menuMachine = new MenuButton("action");
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
       
       pane1.add(menuMachine, 0, 3);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}