/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package com.mycompany.projet2;

import com.mycompany.projet2.Dessinpackage.VueSchema_Atelier;
import static com.mycompany.projet2.FichierTextpackage.Maintenance.GestionAtelier;
import com.mycompany.projet2.Modelepackage.*;
import com.mycompany.projet2.Vuepackage.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author elisa
 */

//avant de commencer, telecharger le fichier texte suivimaintenance et 
//renseigner le chemin dans les classes maintenance et fiabilité 

public class NewFXMain extends Application {
    private static ArrayListe_Atelier creation = new ArrayListe_Atelier(); //creation.getAtelier()

    public static ArrayListe_Atelier getCreation() {
        return creation;
    }
    

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
        Pane leftPane = new Pane();  // Conteneur vertical pour l'encadré à gauche
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


////////////////////////////////////////////////////////////////////////////////
//                 POUR LES MACHINES                                          //
////////////////////////////////////////////////////////////////////////////////
        
        MenuButton menuMachine = new MenuButton("Machines");
        MenuItem ajtMachine = new MenuItem("Ajouter ");
        MenuItem modifMachine = new MenuItem("Modifier");
        MenuItem voirMachine = new MenuItem("Consulter liste");
        
        ajtMachine.setOnAction(e -> {
            cadrePoste.getChildren().setAll(new VueAjtMachine());
        });
        
        //a voir comment positionner la fenetre sur le coté et sa taille car elle a l'air un peu étroite 
        
        modifMachine.setOnAction(e -> {
            cadrePoste.getChildren().setAll(new VueModifierMachine());
        });
        voirMachine.setOnAction(e -> {
            cadrePoste.getChildren().setAll(new VueConsultationMachine());
        });
        menuMachine.getItems().addAll(ajtMachine,modifMachine,voirMachine);
       
        menuBar.add(menuMachine, 0, 0);

////////////////////////////////////////////////////////////////////////////////
//                 POUR LES POSTES                                            //
////////////////////////////////////////////////////////////////////////////////        
        
        MenuButton menuPoste = new MenuButton("Postes");
        MenuItem ajtPoste = new MenuItem("Ajouter ");
        MenuItem modifPoste = new MenuItem("Modifier");
        MenuItem voirPoste = new MenuItem("Consulter liste");
        
        ajtPoste.setOnAction(e -> {
            cadrePoste.getChildren().setAll(new VueAjtPoste());
        });
        modifPoste.setOnAction(e -> {
            cadrePoste.getChildren().setAll(new VueModifierPoste());
        });
        voirPoste.setOnAction(e -> {
            cadrePoste.getChildren().setAll(new VueConsulterPoste());
        });
        
        menuPoste.getItems().addAll(ajtPoste,modifPoste,voirPoste);
       
        menuBar.add(menuPoste, 1, 0);
        
////////////////////////////////////////////////////////////////////////////////
//                 POUR LES GAMMES                                            //
////////////////////////////////////////////////////////////////////////////////        
        
        MenuButton menuGamme = new MenuButton("Gammes");
        MenuItem ajtGamme = new MenuItem("Ajouter ");
        MenuItem modifGamme = new MenuItem("Modifier");
        MenuItem voirGamme = new MenuItem("Consulter liste");

        ajtGamme.setOnAction(e -> {
            cadrePoste.getChildren().setAll(new VueAjoutGamme());
        });
        modifGamme.setOnAction(e -> { 
            cadrePoste.getChildren().setAll(new VueModifierGamme());
        });
        voirGamme.setOnAction(e -> {
            cadrePoste.getChildren().setAll(new VueConsultationGamme());
        });

        menuGamme.getItems().addAll(ajtGamme,modifGamme,voirGamme);
       
        menuBar.add(menuGamme, 2, 0);
        
////////////////////////////////////////////////////////////////////////////////
//                 POUR LES PRODUITS                                          //
////////////////////////////////////////////////////////////////////////////////
        MenuButton menuProduit = new MenuButton("Produits");
        MenuItem ajtProduit = new MenuItem("Ajouter ");
        MenuItem modifProduit = new MenuItem("Modifier");
        MenuItem voirProduit = new MenuItem("Consulter liste");

        ajtProduit.setOnAction(e -> {
        cadrePoste.getChildren().setAll(new VueProduit());
        });
        modifProduit.setOnAction(e -> {
         cadrePoste.getChildren().setAll(new VueModifierProduit());
        });
        voirProduit.setOnAction(e -> {
         cadrePoste.getChildren().setAll(new VueConsultationProduit());
        });

        menuProduit.getItems().addAll(ajtProduit,modifProduit,voirProduit);
       
        menuBar.add(menuProduit, 3, 0);
        
////////////////////////////////////////////////////////////////////////////////
//                 POUR LE PERSONNEL                                          //
////////////////////////////////////////////////////////////////////////////////
        
        MenuButton menuPersonnel = new MenuButton("Personnel");
        MenuItem ajtPersonnel = new MenuItem("Ajouter ");
        MenuItem modifPersonnel = new MenuItem("Modifier");
        MenuItem voirPersonnel = new MenuItem("Consulter liste");

        ajtPersonnel.setOnAction(e -> {
            cadrePoste.getChildren().setAll(new VueAjtPersonnel());
        });
        modifPersonnel.setOnAction(e -> {
            cadrePoste.getChildren().setAll(new VueModifierPersonnel());
        });
        voirPersonnel.setOnAction(e -> {
            cadrePoste.getChildren().setAll(new VueConsulterPersonnel());
        });

       menuPersonnel.getItems().addAll(ajtPersonnel,modifPersonnel,voirPersonnel);
       
       menuBar.add(menuPersonnel, 4, 0);
       
       
////////////////////////////////////////////////////////////////////////////////
//                POUR LA FIABILITE                                           //
////////////////////////////////////////////////////////////////////////////////
       
        Button fiabilite =  new Button("Fiabilité");
        menuBar.add(fiabilite, 5, 0);
          
        fiabilite.setOnAction(e -> {
            SceneFiabilite scenefiab = new SceneFiabilite(cadrePoste);
            GridPane vue = scenefiab.getVueFiab();  // On récupère l'interface

            cadrePoste.getChildren().setAll(vue); 
        }); 
    
////////////////////////////////////////////////////////////////////////////////
//                POUR L'AFFICHAGE DU SCHEMA DE L'ATELIER                     //
////////////////////////////////////////////////////////////////////////////////
    Button SchemaAtelier = new Button("Schéma Atelier");
        menuBar.add(SchemaAtelier, 7, 0);
        //Pane pane = new Pane();
        SchemaAtelier.setOnAction(e -> {
            leftPane.getChildren().clear(); //il faut impérativement nettoyer avant d'afficher :')
            leftPane.getChildren().setAll(new VueSchema_Atelier());
            //VueSchema_Atelier vueAtelier = new VueSchema_Atelier(leftPane);
        });
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creation de notre atelier de base
        creation.atelier_base();
        GestionAtelier();
        launch(args);         
}
}
