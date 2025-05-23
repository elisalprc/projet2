/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Vuepackage;

import com.mycompany.projet2.Controleurpackage.ControleurModifierGamme;
import com.mycompany.projet2.Modelepackage.Equipement;
import com.mycompany.projet2.Modelepackage.Gamme;
import com.mycompany.projet2.Modelepackage.Operation;
import com.mycompany.projet2.Modelepackage.Produit;
import static com.mycompany.projet2.NewFXMain.getCreation;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author elisa
 */
public class VueModifierGamme extends VBox {
    private TabPane modification = new TabPane();
    private ControleurModifierGamme ctrlG = new ControleurModifierGamme(this);
    private TextField refGamme;
    private ComboBox<Produit> produit;

    public TextField getRefGamme() {
        return refGamme;
    }

    public ComboBox<Produit> getProduit() {
        return produit;
    }
    
    public VueModifierGamme() {
        ArrayList<Gamme> list;
        list = getCreation().getAtelier().getListeGamme();
        HBox inter = new HBox();
        for(Gamme g : list) {
            Button btn = new Button(g.getRefGamme());
            btn.setOnAction(e-> {
                creerTab(g);
            });
            inter.getChildren().add(btn);  
        }
        this.getChildren().add(inter);
    }
 
    public void creerTab(Gamme gammeMod) {
                // une gamme porte un nom et est faite pour un produit 
        Tab tabInfo = new Tab("Informations");
        VBox box = new VBox();
        box.getChildren().addAll(new Label("reference : "), refGamme = new TextField(gammeMod.getRefGamme())); //AddAll pour ajt plusieurs trucs 
        
        this.produit = new ComboBox<Produit>();
        ArrayList<Produit> listeProduit;
        listeProduit = getCreation().getAtelier().getListeProduits();
        for(Produit p : listeProduit) {
            this.produit.getItems().add(p);     // ajt dans la combobox 
        }
        this.produit.setValue(gammeMod.getProduit());
        box.getChildren().addAll(new Label(" "),new Label("Produit à fabriquer"),new Label(" "),this.produit);    // aerer 
        tabInfo.setClosable(false);      // l'utilisateur ne peut pas fermer l'onglet 
        tabInfo.setContent(box);
        this.modification.getTabs().addAll(tabInfo);
        
        //=================================//
        //Selection des equipements 
        
        Tab tabEquipement = new Tab("Equipements");      
        VBox box2 = new VBox();
        box2.getChildren().add(new Label("Equipements necessaires"));
        ArrayList<Equipement> listEq;
        listEq = getCreation().getAtelier().getListeEq();
        for(Equipement eq : listEq) {
            CheckBox choix = new CheckBox(eq.getRefEquipement());
            choix.setOnAction(e->  {
                if(choix.isSelected()){
                    this.ctrlG.ajoutEq(eq);
                }
                else {
                    this.ctrlG.suppEq(eq);
                }
            });
            box2.getChildren().add(choix);
        }
        tabEquipement.setClosable(false);
        tabEquipement.setContent(box2);
        this.modification.getTabs().addAll(tabEquipement);
        
        //====================================//
        //Selection des operations (doublons possibles)
        // creer VBox qui va contenir des Hbox : nom op, bouton plus, bouton -
        Tab tabOperation = new Tab("Operations");
        VBox box3 = new VBox();
        box3.getChildren().add(new Label("Operations a effectuer"));
        ArrayList<Operation> listeOp;
        listeOp = getCreation().getAtelier().getListeOperations();
        for(Operation op : listeOp) {
            final int[] compteur = {0};
            HBox conteneur = new HBox();
            Label compte = new Label("0");
            Button btn_plus = new Button("+");
            Button btn_moins = new Button("-");
            btn_moins.setDisable(true);   //inutilisable 
            btn_plus.setOnAction(e-> {
                compteur[0]=compteur[0]+1;
                compte.setText(String.valueOf(compteur[0]));
                btn_moins.setDisable(false);
                this.ctrlG.ajoutOp(op);
            });
            
            btn_moins.setOnAction(e-> {
                if(compteur[0]>0){
                    compteur[0]=compteur[0]-1;
                    compte.setText(String.valueOf(compteur[0]));
                    this.ctrlG.suppOp(op);
                }
                if(compteur[0] == 0){
                    btn_moins.setDisable(true);
                }
            });
            
            conteneur.getChildren().addAll(new Label(op.getdOperation()),btn_moins,compte,btn_plus);
            box3.getChildren().add(conteneur);  
        }
        tabOperation.setClosable(false);
        tabOperation.setContent(box3);
        this.modification.getTabs().add(tabOperation);
        
        //=====================================//
        //reste à valider !
        HBox boutons = new HBox();
        
        Tab tabValider = new Tab("Valider la modification");
        Button ok = new Button("Valider");
        ok.setOnAction(e-> {
            this.ctrlG.modifierG(gammeMod);
        });
        Button supp = new Button("Supprimer la gamme");
        supp.setOnAction(e-> {
            this.ctrlG.supprimerG(gammeMod);
        });
        boutons.getChildren().addAll(ok,supp);
        tabValider.setClosable(false);
        tabValider.setContent(boutons);
        this.modification.getTabs().add(tabValider);
        
        this.getChildren().add(modification);
    }
}
    

