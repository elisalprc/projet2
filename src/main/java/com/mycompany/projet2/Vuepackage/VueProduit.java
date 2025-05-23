/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Vuepackage;

import com.mycompany.projet2.Controleurpackage.ControleurProduit;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author chach
 */
public class VueProduit extends GridPane{
    //attributs:
    private ControleurProduit ctrlPro; 
    private TextField codeproduit;
    private TextField dproduit;
    private Button btAjt_Produit;
    
   //getters et setters:
    public TextField getCodeproduit(){
        return codeproduit;
    }
    public TextField getDproduit(){
        return dproduit;
    }
    public void setCodeproduit(TextField codeproduit){
        this.codeproduit=codeproduit;
    }
    public void setDproduit(TextField dproduit){
        this.dproduit=dproduit;
    }
    
    //controleur:
    public VueProduit() {                 
        this.setHgap(5.5);
        this.setVgap(5.5);
        this.setAlignment(Pos.CENTER);
        this.add(new Label("Code"),0,0);
        this.add(new Label("Désignation"),0,1);
        this.add(this.codeproduit = new TextField(),1,0);
        this.add(this.dproduit = new TextField(),1,1);
        this.btAjt_Produit = new Button("Ajouter");
        this.add(btAjt_Produit,1,8);

        this.btAjt_Produit.setOnAction((t) -> {
            this.ctrlPro=new ControleurProduit(this);
            this.ctrlPro.ajtPro(t);    
        });
}
}
