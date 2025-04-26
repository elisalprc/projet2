/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2;

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
    public String getCodeProduit() {
        return codeProduit;
    }

    public void setCodeProduit(String codeProduit) {
        this.codeProduit = codeProduit;
    }

    public String getdProduit() {
        return dProduit;
    }

    public void setdProduit(String dProduit) {
        this.dProduit = dProduit;
    }
    
    //fin getter et setter
    
    @Override
    public String toString(){
        return "produit : " + this.dProduit + ", code : " + this.codeProduit;
    }
    
}
