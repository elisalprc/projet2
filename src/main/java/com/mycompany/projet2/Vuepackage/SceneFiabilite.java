/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Vuepackage;

/**
 *
 * @author chach
 */

import static com.mycompany.projet2.FichierTextpackage.Fiabilite.CalculFiabilite;
import static com.mycompany.projet2.FichierTextpackage.Fiabilite.TrieFiabilite;
import static com.mycompany.projet2.Modelepackage.ArrayListe_Atelier.Convertion_LMA_LM;
import static com.mycompany.projet2.Modelepackage.ArrayListe_Atelier.LMA;
import com.mycompany.projet2.NewFXMain;
import static com.mycompany.projet2.Vuepackage.VerificationDonneeEntree.Existance_MachineEntree;
import static com.mycompany.projet2.Vuepackage.VerificationDonneeEntree.AfficherErreur;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 *
 * @author chach
 */

public class SceneFiabilite extends NewFXMain{
    private VBox cadreParent;
    
    public SceneFiabilite(VBox cadreFiab) {
        this.cadreParent = cadreFiab;
    }
    
    static ArrayList<String> LM = new ArrayList<>(); //liste des machines de l'atelier dont on cherche à connaitre la fiabilité
    static ArrayList<Double> MachFiabilite = new ArrayList<>();
    //ArrayList<Machine> LMA = new ArrayList<>();
    
        
    public static double Afficher_Fiabilite(ArrayList<String> LM , ArrayList<Double> MachFiabilite , String Machine_trouve){
        // recherche et affichage de la fiabilité
            double fiab;
            int k = LM.indexOf(Machine_trouve);
            if (Existance_MachineEntree(k)==true){
                System.out.println("La machine existe dans la liste, elle se situe à la position : "+(k+1));
                fiab = MachFiabilite.get(k);
            }
            else {
                int n = (LM.size() - 1);
                AfficherErreur(" Erreur : La machine entrée n'existe pas dans l'atelier. Erreur : Les machines existantes vont de :"+LM.get(0)+" à : "+LM.get(n)+". Veuillez vérifier votre saisie et recommencer.");
                fiab = -1;
            }
        return fiab;
    }
    
    
    public GridPane getVueFiab() {
    GridPane pane = new GridPane();
    pane.setAlignment(Pos.CENTER);
    pane.setHgap(9.9);
    pane.setVgap(9.9);
       
       //les labels donc fiab et machine :
       pane.add(new Label("Machine :"),0,0);
       TextField machine = new TextField();
       pane.add(machine, 1, 0);
       pane.add(new Label("Fiabilité :"),0,1);
       Label fiabilite = new Label("--");
       pane.add(fiabilite,1,1);
       
       //ajout et action du bouton qui va afficherl a fiabilite de la machine entrée
        Button btAdd = new Button("Afficher fiabilité");
        pane.add(btAdd, 0, 4);
       
        btAdd.setOnAction((ActionEvent evt) -> {
            LM.clear();
            LM = Convertion_LMA_LM(LMA); //convertion bien effectuée et listes bien remplies
            MachFiabilite.clear();
            for (int i=0; i<LM.size(); i++){
                MachFiabilite.add(CalculFiabilite(LM.get(i))); //on calcul la fiabilite de la machine
            }
            String Machine_trouve = machine.getText();         
            double fiab = Afficher_Fiabilite(LM , MachFiabilite , Machine_trouve); 
                fiabilite.setText(Double.toString(fiab));
            });
        
       //ajout et action du bouton qui va afficher la liste des machines par ordre de fiabilité :
        Button btAddList = new Button("Afficher la liste de fiabilité");
        pane.add(btAddList, 1, 4);
        
        //création d'un VBox pour contenir la liste (but permettre de le vider plus facilement pour éviter les surrelistes et listes à l'infini :,)
        VBox vboxListe = new VBox();
        pane.add(vboxListe, 0, 5, 2, 1); 
        
        btAddList.setOnAction(evt -> {
            String[] ListeCroissanteMachineEnFonctionFiab;
            LM.clear();
            LM = Convertion_LMA_LM(LMA); //convertion bien effectuée et listes bien remplies
            MachFiabilite.clear();
            
            // Nettoyer le VBox avant d’ajouter la nouvelle liste
            vboxListe.getChildren().clear();

            for (int i=0; i<LM.size(); i++){
                MachFiabilite.add(CalculFiabilite(LM.get(i))); //on calcul la fiabilite de la machine
            }

            ListeCroissanteMachineEnFonctionFiab = TrieFiabilite(MachFiabilite,LM);
            for (String s : ListeCroissanteMachineEnFonctionFiab) {
                vboxListe.getChildren().add(new Text(s));
            } 
        }); 
       
            
       //pour ouvrir la fenetre, avec le pane et tout (même si ça c'est juste pour tester):
       return pane;
    }
    
    
    
    
}
 
