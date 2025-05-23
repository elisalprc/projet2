/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Modelepackage;

import com.mycompany.projet2.Modelepackage.Gamme;
import com.mycompany.projet2.Modelepackage.Machine;
import com.mycompany.projet2.Modelepackage.Poste;
import com.mycompany.projet2.Modelepackage.Produit;
import com.mycompany.projet2.Modelepackage.Operateur;
import java.util.ArrayList;

/**
 *
 * @author chach
 */

// sauvegarder les données dans un fichier texte par ex pour éviter de rentrer à chaque fois les infos des objets à crééer et reremplir les listes à chaque ouverture de l'application !
public class Atelier {
    //Attributs :
        private String nom; 
        private Personne chefAtelier;
        private ArrayList<Machine> listeMachines;
        private ArrayList<Poste> listePostes;
        private ArrayList<Produit> listeProduits;
        private ArrayList<Gamme> listeGamme;
        private ArrayList<Operateur> listeOperateurs;
        private ArrayList<Equipement> listeEq;
        private ArrayList<Operation> listeOperations;
        
    //Getters :
        public String getNom(){
            return nom;
        }
        
        public ArrayList getListeEq() {
            return listeEq;
        }
   
        public ArrayList getListeMachines() {
            return listeMachines;
        }

        public ArrayList getListePostes() {
            return listePostes;
        }

        public ArrayList getListeProduits() {
            return listeProduits;
        }

        public ArrayList getListeGamme() {
            return listeGamme;
        }

        public ArrayList getListeOperateurs() {
            return listeOperateurs;
        }
        
        public ArrayList getListeOperations(){
            return this.listeOperations;
        }

        public Personne getChefAtelier() {
        return chefAtelier;
        }
        
    //Setters :
        public void setNom(String nom){
            this.nom=nom;
        }

        public void setListeMachines(ArrayList listeMachines) {
            this.listeMachines = listeMachines;
        }

        public void setListePostes(ArrayList listePostes) {
            this.listePostes = listePostes;
        }

        public void setListeProduits(ArrayList listeProduits) {
            this.listeProduits = listeProduits;
        }

        public void setListeGamme(ArrayList listeGamme) {
            this.listeGamme = listeGamme;
        }

        public void setListeOperateurs(ArrayList listeOpérateurs) {
            this.listeOperateurs = listeOpérateurs;
        }
        
    //Constructeur:
        public Atelier(String nom, ArrayList listeMachines, ArrayList listePostes, ArrayList listeProduits, ArrayList listeGamme, ArrayList listeOperateurs) {
            this.nom = nom;
            this.listeMachines = listeMachines;
            this.listePostes = listePostes;
            this.listeProduits = listeProduits;
            this.listeGamme = listeGamme;
            this.listeOperateurs = listeOperateurs;
        }

        public void setChefAtelier(Personne chefAtelier) {
        this.chefAtelier = chefAtelier;
        }
        
        public Atelier(){}
        
        public Atelier(String nom, ArrayList listeMachines, ArrayList listePostes, ArrayList listeProduits, ArrayList listeGamme, ArrayList listeOperateurs, ArrayList listEq, ArrayList listeOpe,  Personne chefAtelier) {
            this.nom = nom;
            this.listeMachines = listeMachines;
            this.listePostes = listePostes;
            this.listeProduits = listeProduits;
            this.listeGamme = listeGamme;
            this.listeOperateurs = listeOperateurs;
            this.listeEq = listEq;
            this.listeOperations = listeOpe; 
            this.chefAtelier = chefAtelier;
        }
    
    //Methodes:
        //Ajout d'un élément dans les listes:
        public void ajoutMachine(Machine machine){
            listeMachines.add(machine); 
            this.listeEq.add(machine);
        }
        public void ajoutPoste(Poste poste){
            listePostes.add(poste);
            this.listeEq.add(poste);
        }
        public void ajoutProduit(Produit produit){
            listeProduits.add(produit);
        }
        public void ajoutOperateur(Operateur operateur){
            listeOperateurs.add(operateur);
        }
        public void ajoutGammeFabrication(Gamme gamme){
            listeGamme.add(gamme);
        }
        
        //suppression d'un élément des listes:
        public void supprimerMachine(Machine machine){
            listeMachines.remove(machine);
            this.listeEq.remove(machine);
        }
        public void supprimerPoste(Poste poste){
            listePostes.remove(poste);
            this.listeEq.remove(poste);
        }
        public void supprimerProduit(Produit produit){
            listeProduits.remove(produit);
        }
        public void supprimerOperateur(Operateur operateur){
            listeOperateurs.remove(operateur);
        }
        public void supprimerGammeFabrication(Gamme gamme){
            listeGamme.remove(gamme);
        }
        
        //modification d'un élement
        public void modifierMachine(Machine m, int index){
            listeMachines.set(index,m); 
        }
        public void modifierPoste(Poste p, int index){
            listePostes.set(index,p);
        }
        public void modifierProduit(Produit P, int index){
            listeProduits.set(index,P);
        }
        public void modifierOperateur(Operateur O, int index){
            listeOperateurs.set(index,O);
        }
        public void modifierGamme(Gamme g, int index){
            listeGamme.set(index,g); //remplacer la gamme à la position i par la game g
    }
       
}
