/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Modelepackage;

import java.util.ArrayList;

/**
 *
 * @author clema
 */
public class Operateur extends Personne {
    private ArrayList<Equipement> ListeEquipements;

    public ArrayList<Equipement> getListeEquipements() {
        return ListeEquipements;
    }

    public void setListeEquipements(ArrayList<Equipement> ListeEquipements) {
        this.ListeEquipements = ListeEquipements;
    }

    public Operateur(String nom, String prenom, int id, ArrayList<Equipement> ListeEquipements) {
        super(nom, prenom, id);
        this.ListeEquipements = new ArrayList<>();
        this.ListeEquipements = ListeEquipements;
    }
    
    public void ajoutEquipement(Equipement e) {
        this.ListeEquipements.add(e);
    }
    
    @Override
    public String toString(){
        return "identite : " + getPrenom() + " " + getNom() + ", eq : " + this.ListeEquipements;
    }
    
}
