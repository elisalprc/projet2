/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.FichierTextpackage;

import com.mycompany.projet2.Modelepackage.Equipement;
import com.mycompany.projet2.FichierTextpackage.ReadFile;
import com.mycompany.projet2.FichierTextpackage.WriteFile;
import com.mycompany.projet2.Modelepackage.Machine;
import com.mycompany.projet2.NewFXMain;
import com.mycompany.projet2.Modelepackage.Operateur;
import static com.mycompany.projet2.FichierTextpackage.Verification.DateInputValide;
import static com.mycompany.projet2.FichierTextpackage.Verification.HoraireInputValide;
import static com.mycompany.projet2.FichierTextpackage.Verification.CauseInputValide;
import static com.mycompany.projet2.FichierTextpackage.Verification.EvenementInputValid;
import static com.mycompany.projet2.FichierTextpackage.Verification.MachineInputValid;
import static com.mycompany.projet2.FichierTextpackage.Verification.OperateurInputValide;
import com.mycompany.projet2.Lire;
import static com.mycompany.projet2.Modelepackage.ArrayListe_Atelier.LMA;
import static com.mycompany.projet2.Modelepackage.ArrayListe_Atelier.LOP;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author chach
 */
public class Maintenance extends NewFXMain {
// =====================================================================================       
// IMPORTANT : pour ecrire et lire dans un fichier texte donc sauvegarder des données !
// =====================================================================================   
    
    //Methode pour écrire dans le gestionnaire de l'atelier et ainsi suivre les retours sur fiabilité et maintenance de notre atelier de fabrication:
    public static void GestionAtelier(){   
        
        String file_name = "SuiviMaintenance.txt.";
        
        // pour lire un fichier texte
        try{
            ReadFile file = new ReadFile(file_name);
            String[] lignes = file.OpenFile();
            int i;
            for (i=0; i<lignes.length;i++){
                System.out.println(lignes[i]);
            }
        }
        catch(IOException e){
            System.out.println("Une erreur est survenue a la lecture, desole, veuillez recommencer");           
        }
        
        //pour poursuivre
        String poursuivre;
        System.out.println("Voulez vous saisir de nouvelles donnees dans le fichier SuiviMaintenance ? Si oui, entrez : OUI, sinon saisir autre chose");
        poursuivre = Lire.S();
        while (poursuivre.equals("OUI")){
        
        
        // pour écrire dans le fichier texte (on va vérifier à chaque fois que ce que l'utilisateur entre correspond bien aux données voulues et acceptées pour éviter les erreurs
            try{
                WriteFile fichier_texte  = new WriteFile(file_name, true); 
            
                String Date = DateInputValide(); //pour entrer la date dans le gestionnaire de l'atelier (fichier texte)
                String Horaire = HoraireInputValide(); //pour entrer l'horaire
                int Machine = MachineInputValid(LMA); //pour entrer la machine
                char Evenement = EvenementInputValid(); //pour entrer l'évènement
                int Operateur = OperateurInputValide(LOP); //pour entrer l'opérateur
                String Cause = CauseInputValide();
                fichier_texte.writeToFile(Date+";"+Horaire+";Mach_"+Machine+";"+Evenement+";OP"+Operateur+";"+Cause);
                System.out.println("Text File Written To"); //pour dire que ça a bien écrit dans le fichier texte :)
            }
            catch(IOException e){
                System.out.println("Une erreur est survenue a l'ecriture, desole, veuillez recommencer");           
            }
        
            System.out.println("Voulez vous saisir de nouvelles donnees dans le fichier SuiviMaintenance ? Si oui, entrez : OUI, sinon saisir autre chose");
            poursuivre = Lire.S();
        }
    }
}


