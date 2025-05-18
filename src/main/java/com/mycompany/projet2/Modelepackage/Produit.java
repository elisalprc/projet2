/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Modelepackage;

/**
 *
 * @author eleprince01
 */
public class Produit {
    private String codeProduit;
    private String dProduit;

    public Produit(String c, String d) {
        this.codeProduit = c;
        this.dProduit = d;
    }
    
    //getter et setter 
    public String getCodeproduit() {
        return codeProduit;
    }

    public void setCodeproduit(String codeProduit) {
        this.codeProduit = codeProduit;
    }

    public String getDproduit() {
        return dProduit;
    }

    public void setDproduit(String dProduit) {
        this.dProduit = dProduit;
    }
    
    //fin getter et setter
    
    public void afficherProduit(){
        System.out.println("code du produit = "+ this.codeProduit);
        System.out.println("désignation du produit = "+ this.dProduit);
    }
    @Override
    public String toString(){
        return "produit : " + this.dProduit + ", code : " + this.codeProduit;
    }
    
    public void modifierProduit(String codeproduit, String dproduit) {
        this.codeProduit = codeproduit;
        this.dProduit = dproduit;
    }
    
}
