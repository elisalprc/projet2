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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author elisa
 */
public class NewFXMain extends Application {
    public Atelier Atelier1 = new Atelier();
    
    @Override
    public void start(Stage primaryStage) {
         BorderPane root = new BorderPane();  // structure principale

        // Créer un conteneur horizontal (HBox) pour le menu et le cadre à gauche
        HBox topBox = new HBox();  // Crée une boîte horizontale pour organiser le menu et le cadre
        topBox.setSpacing(10);  // Espacement entre les éléments
        topBox.setPadding(new Insets(10));  // Marge autour du conteneur

        // Créer un conteneur GridPane pour le menu en haut
        GridPane menuBar = new GridPane();
        menuBar.setAlignment(Pos.CENTER);
        menuBar.setHgap(10.10);
        menuBar.setVgap(10.10);

        // Ajouter le menuBar dans topBox
        topBox.getChildren().add(menuBar);  // Mettre le menuBar dans le topBox
        
        // Placer le topBox dans le BorderPane
        root.setTop(topBox);  // Ajoute le menu et le cadre à gauche au haut de la fenêtre
        topBox.setAlignment(Pos.CENTER);
        
        // Créer le cadre gauche qui restera fixe
        VBox leftPane = new VBox();  // Conteneur vertical pour l'encadré à gauche
        leftPane.setStyle("-fx-border-color: grey; -fx-border-width: 2;");  // Style du cadre
        leftPane.setPadding(new Insets(10));  // Marge autour du cadre
        leftPane.setPrefWidth(550);  // Largeur du cadre
        leftPane.setPrefHeight(350);  // Hauteur du cadre
        root.setLeft(leftPane);  // Ajouter le cadre gauche dans topBox

        // Créer une VBox pour le contenu à droite (par exemple, "Ajouter Poste")
        VBox contentPane = new VBox();  // Conteneur pour les éléments à droite du menu
        contentPane.setSpacing(10);  // Espacement entre les éléments
        contentPane.setPadding(new Insets(10));  // Marge autour des éléments
        
        VBox cadrePoste = new VBox();
        cadrePoste.setStyle("-fx-border-color: grey; -fx-border-width: 2;");  // Style du cadre
        cadrePoste.setPadding(new Insets(10));  // Marge autour du cadre
        cadrePoste.setPrefWidth(400);  // Largeur du cadre
        cadrePoste.setPrefHeight(400);  // Hauteur du cadre
        contentPane.getChildren().add(cadrePoste);  // Ajouter le cadre à la zone droite

        // Ajouter le contentPane dans le BorderPane, à droite
        root.setRight(contentPane);  // Zone de droite

        // Créer la scène
        Scene scene = new Scene(root, 1000, 500);  // Créer la scène avec la taille désirée
        primaryStage.setScene(scene);  // Appliquer la scène
        primaryStage.setTitle("Atelier");  // Définir le titre de la fenêtre
        primaryStage.show();  // Afficher la fenêtre
        
        MenuButton menuMachine = new MenuButton("Machines");
        MenuItem ajtMachine = new MenuItem("Ajouter ");
        MenuItem modifMachine = new MenuItem("Modifier");
        MenuItem voirMachine = new MenuItem("Consulter liste");
        
        ajtMachine.setOnAction(e -> {
            //Stage stage = new Stage();    
            //Scene sc = new Scene(new VueAjtMachine());
            //stage.setScene(sc);
            //stage.setTitle("Ajouter machine");
            //stage.show(); 
        });
        
        //a voir comment positionner la fenetre sur le coté et sa taille car elle a l'air un peu étroite 
        
        modifMachine.setOnAction(e -> {
         // Changer vers la scène 2
        });
        voirMachine.setOnAction(e -> {
         // Changer vers la scène 3
        });
        menuMachine.getItems().addAll(ajtMachine,modifMachine,voirMachine);
       
        menuBar.add(menuMachine, 0, 0);
        
        MenuButton menuPoste = new MenuButton("Postes");
        MenuItem ajtPoste = new MenuItem("Ajouter ");
        MenuItem modifPoste = new MenuItem("Modifier");
        MenuItem voirPoste = new MenuItem("Consulter liste");
        
        ajtPoste.setOnAction(e -> {
            AjouterPoste ajouterPoste = new AjouterPoste(cadrePoste);
            GridPane vue = ajouterPoste.getVue();  // On récupère l'interface

            cadrePoste.getChildren().setAll(vue);
        });
        modifPoste.setOnAction(e -> {
         // Changer vers la scène 2
        });
        voirPoste.setOnAction(e -> {
         // Changer vers la scène 3
        });
        
        menuPoste.getItems().addAll(ajtPoste,modifPoste,voirPoste);
       
        menuBar.add(menuPoste, 1, 0);
        
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
       
        menuBar.add(menuGamme, 2, 0);
        
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
       
        menuBar.add(menuProduit, 3, 0);
        
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
       
       menuBar.add(menuPersonnel, 4, 0);
       
       Button fiabilite =  new Button("Fiabilité");
       menuBar.add(fiabilite, 5, 0);
       
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