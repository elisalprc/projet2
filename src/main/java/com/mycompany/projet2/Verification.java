/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

/**
 *
 * @author chach
 */
public class Verification {
//c'est une classe qui va nous permettre d'effectuer toutes les vérifications afin d'éviter les erreurs.

//verification des entrées de l'utilisateur dans le fichier text pour la gestion de l'atelier de fabrication.
    //verification de la date entrée :
    public static boolean DateValide(String input) {
        String format = "dd/MM/yyyy";
        try {
            //on va ici convertir le texte entrée en date
            DateTimeFormatter formatteur = DateTimeFormatter.ofPattern(format); //ici en fait on créer un formatteur de date, donc en gros le formateur va mettre la date sous le format voulu lors de la conversion de l'entrée en date.
            LocalDate date = LocalDate.parse(input, formatteur);
            
            //on définit les limites temporelles, parce que non on ne veut pas de 00/01/1555 ! ou de 31/01/2087!
            LocalDate min = LocalDate.now().minusYears(5); //on part du principe que notre atelier à été créé il y à 5 ans (si ça vous va :)
            LocalDate max = LocalDate.now(); //on ne pourra pas entrer de date supérieure à celle du jour, parce que bah oui aujourd'hui n'est pas le futur pour les machines.
            
            //on test et compare :
            return !date.isBefore(min) && !date.isAfter(max);
            
        } catch (DateTimeParseException e) {
            return false;
        }
    } 
    
    public static String DateInputValide(){
        System.out.println("entrer la date sous le format : jj/mm/aaaa");
            String entrée = Lire.S();
            while (DateValide(entrée) == false){
               System.out.println("La date entree est incorrecte");
               entrée = Lire.S();
            }
            return entrée; 
    }
    
    
    //vérification de l'heure rentrée (sur la même base que vu précédemment:
    public static boolean HoraireValide(String input) {
        String format = "HH:mm";
        try {
            //on va ici convertir le texte entrée en date
            DateTimeFormatter formatteur = DateTimeFormatter.ofPattern(format);
            LocalTime horaire = LocalTime.parse(input, formatteur);
            
            //on définit les limites temporelles, les machines ne peuvent tourner qu'entre l'ouverture et la fermeture de l'atelier
            LocalTime ouverture = LocalTime.of(10, 0); 
            LocalTime fermeture = LocalTime.of(20, 30);
            
            //on test et compare :
            return !horaire.isBefore(ouverture) && !horaire.isAfter(fermeture);
            
        } catch (DateTimeParseException e) {
            return false;
        }
    } 
    
    public static String HoraireInputValide(){
        System.out.println("entrer l'horaire sous le format : hh:mm ");
            String entrée = Lire.S();
            while (HoraireValide(entrée) == false){
               System.out.println("L'horaire entree est incorrecte (Rappel : l'atelier ouvre a 10 heures et ferme a 20h30.)");
               entrée = Lire.S();
            }
            return entrée; 
    }
    
    //vérification de la machine:
    public static int MachineInputValid(ArrayList<Machine> LM){
        System.out.println("entrer le numero de la machine utilisée (de 1 a "+LM.size()+")");
        int entrée = Lire.i();
        while ((entrée > LM.size())||(entrée < 1)){
            System.out.println("la saisie de la machine est erronée veuillez recommencer (de 1 a "+LM.size()+")");
            entrée = Lire.i();   
        }
        return entrée;    
    }
    
    //vérification de l'évènement:
    public static char EvenementInputValid(){
    System.out.println("entrer l'evenement sous le format : A (pour arret) ou D (pour démarrage)");
    char entrée = Lire.c();
    while (entrée != 'A'&& entrée != 'D'){
        System.out.println("Une erreur est survenue dans la saisie de l'evenement, veuillez entrer A ou D");
        entrée = Lire.c();
        }
    return entrée;
    }
    
    //vérification de l'opérteur: 
    public static int OperateurInputValide(ArrayList<Operateur> LOP){
    System.out.println("entrer le numéro de l'opérateur (entre 100 et "+(100+LOP.size())+")");
    int entrée = Lire.i(); 
    while ((entrée > 100+LOP.size())||(entrée < 100)){
            System.out.println("la saisie de l'opérateur  est erronée veuillez recommencer (de 100 à "+(100+LOP.size())+")");
            entrée = Lire.i();   
        }
    return entrée;
    }
    
    //vérification de la cause:
    public static String CauseInputValide(){
    System.out.println("entrer la cause : panne, accident, maintenance ou x si aucun des trois");
    String entrée = Lire.S();
    while ((!"panne".equals(entrée))&&(!"accident".equals(entrée))&&(!"maintenance".equals(entrée))&&(!"x".equals(entrée))){
        System.out.println("Une erreur est survenue dans la saisie de la cause, veuillez entrer : panne, accident, maintenance ou x si aucun des trois");
        entrée = Lire.S();
    }
    return entrée;
    }
}
