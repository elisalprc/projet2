/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Modelepackage;

import com.mycompany.projet2.Modelepackage.Operation;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author eleprince01
 */
public class Gamme {
//Atributs:
    //private String dProduit; //produit associé à la gamme 
    private Produit produit;
    private String refGamme;
    private ArrayList<Operation> listeOperations;
    private ArrayList<Equipement> listeEquipement; 
    
//Constructeur:
    public Gamme(Produit prod, String refGamme, ArrayList<Operation> listeOperations, ArrayList<Equipement> listeEquipement){
        this.produit = prod;
        this.listeEquipement=listeEquipement;
        this.listeOperations=listeOperations;
        this.refGamme=refGamme;
    }
    
    public void modifierGamme(Produit p, String ref, ArrayList<Operation> listeOp, ArrayList<Equipement> listeEq){
        this.produit = p;
        this.refGamme = ref;
        this.listeOperations = listeOp;
        this.listeEquipement = listeEq;
    }

//Getters et setters:
    public String getRefGamme() {
        return refGamme;
    }

    public ArrayList<Operation> getListeOperations() {
        return listeOperations;
    }

    public ArrayList<Equipement> getListeEquipement() {
        return listeEquipement;
    }
    
    public String getDProduit() {
        return this.produit.getDproduit();
    }
    
    public Produit getProduit() {
        return this.produit;
    }

    
//Methodes:
    //suppression d'une gamme:
      //voir directement dans Atelier pour supprimer une gamme de l'ensemble des gammes proposées.
    
    //afficher une gamme
    public void afficherGamme(Gamme gamme){
    System.out.println("Pour réaliser la gamme de fabrication "+refGamme+" il faut les operations suivantes : "+listeOperations+" ainsi que les equipements suivants : "+listeEquipement);
    }
    
    @Override
    public String toString() {
        String a ="";
        for(Equipement eq : this.listeEquipement) {
            a=a+"\n" + eq.getRefEquipement();
        }
        String b ="";
        for(Operation op : this.listeOperations) {
            b=b+"\n" + op.getRefOperation();
        }
    
        return this.refGamme + "," + getDProduit() + a + b + "\n";
    }
    
    
    public void ajouterOp(Operation operation) {
        this.listeOperations.add(operation);
    }
    
    public void suppOp(Operation operation){
        this.listeOperations.remove(operation);
    }
    
    public void ajouterEq(Equipement equipement) {
        this.listeEquipement.add(equipement);
    }
    
    public void suppEq(Equipement equipement) {
        this.listeEquipement.remove(equipement);
    }
  
    //cout d'une Gamme:
    public double coutGamme(){
        
        return 5; 
    }
    
    public double dureeGamme(){
        double c=0;
        for (Operation op : this.listeOperations){
            c=c+op.getDureeOperation(); 
        } 
        return c;
    }
}
