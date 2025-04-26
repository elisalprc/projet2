/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2;

import static com.mycompany.projet2.Verification.DateInputValide;
import static com.mycompany.projet2.Verification.HoraireInputValide;
import static com.mycompany.projet2.Verification.CauseInputValide;
import static com.mycompany.projet2.Verification.EvenementInputValid;
import static com.mycompany.projet2.Verification.MachineInputValid;
import static com.mycompany.projet2.Verification.OperateurInputValide;
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
        
        String file_name = "C:/Documents/SuiviMaintenance";
        
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
        
        // pour écrire dans le fichier texte (on va vérifier à chaque fois que ce que l'utilisateur entre correspond bien aux données voulues et acceptées pour éviter les erreurs
        try{
            WriteFile fichier_texte  = new WriteFile(file_name, true); 
            
            String Date = DateInputValide(); //pour entrer la date dans le gestionnaire de l'atelier (fichier texte)
            String Horaire = HoraireInputValide(); //pour entrer l'horaire
                ArrayList<Machine> LM = new ArrayList<>();
                Machine M1 = new Machine("redTEST","decoupeuse","decoup laser",2,2,10,2,"libre","eqM1","machine1");
                Machine M2 = new Machine("refTEST2","imprimante","imp 3D",4,4,30,8,"libre","eqM2","machine2");
                LM.add(M1);
                LM.add(M2);
            int Machine = MachineInputValid(LM); //pour entrer la machine
            char Evenement = EvenementInputValid(); //pour entrer l'évènement
                 ArrayList<Operateur> LOP = new ArrayList<>();
                    ArrayList<Equipement> LEQ = new ArrayList<>();
                    Equipement test = new Equipement("e1","essai");
                    LEQ.add(test);
                 Operateur op = new Operateur("turing","alan",1,LEQ);
                 LOP.add(op);
            int Operateur = OperateurInputValide(LOP); //pour entrer l'opérateur
            String Cause = CauseInputValide();
            fichier_texte.writeToFile(Date+"   "+Horaire+"   Mach_"+Machine+"    "+Evenement+"            OP"+Operateur+"       "+Cause);
                System.out.println("Text File Written To"); //pour dire que ça a bien écrit dans le fichier texte :)
        }
        catch(IOException e){
            System.out.println("Une erreur est survenue a l'ecriture, desole, veuillez recommencer");           
        }
    }
}

//Cahier de maintenance de l'atelier de fabrication : 
//
//
//Date       Heure   Machine   Evènements   Opérateur   Cause 

