/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Modelepackage;

import com.mycompany.projet2.Modelepackage.Operation;
import java.util.ArrayList;
/**
 *
 * @author eleprince01
 */
public class Gamme {
//Atributs:
    private String refGamme;
    private ArrayList<Operation> listeOperations;
    private ArrayList<Equipement> listeEquipement; //indice pair = machine et indice impair = poste ??
    private ArrayList<Gamme>listeGamme;
    
//Constructeur:
    public Gamme(String refGamme, ArrayList<Operation> listeOperations, ArrayList<Equipement> listeEquipement){
        this.listeEquipement=listeEquipement;
        this.listeOperations=listeOperations;
        this.refGamme=refGamme;
    }

//Getters et setters:
    public String getRefGamme() {
        return refGamme;
    }

    public void setRefGamme(String refGamme) {
        this.refGamme = refGamme;
    }

    public ArrayList<Operation> getListeOperations() {
        return listeOperations;
    }

    public void setListeOperations(ArrayList<Operation> listeOperations) {
        this.listeOperations = listeOperations;
    }

    public ArrayList<Equipement> getListeEquipement() {
        return listeEquipement;
    }

    public void setListeEquipement(ArrayList<Equipement> listeEquipement) {
        this.listeEquipement = listeEquipement;
    }
    
//Methodes:
    //suppression d'une gamme:
      //voir directement dans Atelier pour supprimer une gamme de l'ensemble des gammes proposées.
    
    //modifierGamme:
      //voir directement dans Atelier
    
    //afficher une gamme
    public void afficherGamme(Gamme gamme){
    System.out.println("Pour réaliser la gamme de fabrication "+refGamme+" il faut les operations suivantes : "+listeOperations+" ainsi que les equipements suivants : "+listeEquipement);
    }
    //creerGamme () ;
    public void creerGamme(String ref,ArrayList<Operation> listeOperations, ArrayList<Equipement> listeEquipement){
        Gamme gamme = new Gamme (ref, listeOperations, listeEquipement);
        listeGamme.add(gamme);
    }
    //cout d'une Gamme:
    public float coutGamme(){
        // en fonction de l'equipement utilisé et de la durée de l'opp ?
        return 5; //pour l'insstat ça sera 5 euro TT
    }
}




//Les méthodes de calcul suivantes :

//coutGamme(), (retourne le coût d’une gamme donnée (float)

//dureeGamme (), (calcule la durée d’exécution d’une gamme (float).