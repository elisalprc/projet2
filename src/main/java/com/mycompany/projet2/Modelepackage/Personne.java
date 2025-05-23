/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Modelepackage;

/**
 *
 * @author clema
 */
public class Personne {
    private String nom;
    private String prenom;
    private int id;

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getId() {
        return id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Personne(String nom, String prenom, int id) {
        this.nom = nom;
        this.prenom = prenom;
        this.id = id;
    }
    
    public void AfficherPersonne(){
        System.out.println("nom = "+ this.nom);
        System.out.println("prénom = "+ this.prenom);
        System.out.println("Identifiant = "+ this.id);
    }
    
    public void ModifierPersonne(String nom, String prenom, int id){
        this.nom = nom;
        this.prenom = prenom;
        this.id = id;
    }
    
    @Override
    public String toString() {
        return this.prenom + " " + this.nom + ", code : " + this.id;
    }
    
}
