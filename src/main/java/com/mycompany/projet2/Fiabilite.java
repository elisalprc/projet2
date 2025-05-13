/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2;

import java.io.IOException;
//import java.time.Duration;
//import java.time.LocalDate;
import java.time.LocalDateTime;
//import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author chach
 */
public class Fiabilite {
    static ArrayList<String> Liste_Date = new ArrayList<>();
    static ArrayList<String> Liste_Horaire = new ArrayList<>();
    static ArrayList<String> Liste_Machine = new ArrayList<>();
    static ArrayList<String> Liste_Evenement = new ArrayList<>();
    
    
//pour recuperer les données du fichier texte (SuiviMaintenance) et décomposer les données dans les listes
    public static void Recup_Donnees_Fichier_Texte(){
    int i,k;  
    //création d'une liste des tokens donc des petits morceaux découpés de chaque ligne lue.
        ArrayList<String> tokens = new ArrayList<>();
        
    //chemin du fichier à lire et décomposer   
        String file_name = "C:/Documents/SuiviMaintenance";
        
    // pour lire le fichier texte et récupérer chaque ligne dans une liste
        try{
            ReadFile file = new ReadFile(file_name);
            String[] lignes = file.OpenFile(); //c'est un tableau qui contient toutes les lignes du fichier
            for (i=0; i<lignes.length;i++){
        //Pour décomposer chaque ligne lue :
                StringTokenizer tokenizer = new StringTokenizer(lignes[i], ";"); //on va lire la ligne i et on va la découper à chaque fois qu'on rencontre " ; "
       
                while (tokenizer.hasMoreTokens()) { //tant qu'il y a encore des morceaux de la ligne lue à découper faire :
                    tokens.add(tokenizer.nextToken()); //on ajoute chaque nouvelle donnée découpée du reste de la ligne lue dans une arrayliste
                }
            }
        }
        catch(IOException e){
            System.out.println("Une erreur est survenue a la lecture, desole, veuillez recommencer");           
        }
        
        k = 0;
        for ( i=0; i<(tokens.size()-1); i=i+6){ //on ajoute les differents tokkens au différentes listes qui vont les garder
            Liste_Date.add(k,tokens.get(i));
            Liste_Horaire.add(k,tokens.get((i+1)));
            Liste_Machine.add(k,tokens.get((i+2)));
            Liste_Evenement.add(k,tokens.get((i+3)));
            k=k+1;
        }
    }
    
//méthodes pour avoir le temps d'observation et les temps d'arrêts des machines : pour le calcul de fiabilité:   
    //temps d'observation = création de l'atelier (05/01/2020 - jour d'aujourd'hui (pour avoir une longue période d'observation et donc une meilleure fiabilité)
    public static int Temps_Observation(){ //en fonction de la date de création de l'atelier
    //création des deux dates de référence qui vont permettre de déduire le temps d'observation
        String format = "dd/MM/yyyy-HH:mm";
        String CreationAtelier = "05/01/2020-06:00";
        DateTimeFormatter formatteur = DateTimeFormatter.ofPattern(format); //ici en fait on créer un formatteur de date, donc en gros le formateur va mettre la date sous le format voulu lors de la conversion de l'entrée en date.
        LocalDateTime Creation_Atelier = LocalDateTime.parse(CreationAtelier, formatteur);
        LocalDateTime Aujourdhui = LocalDateTime.now();
        
    //on va maintenant calculer la différence entre les dates (différence en unité de temps : minute)
        long differenceInMinutes = ChronoUnit.MINUTES.between(Creation_Atelier, Aujourdhui);
        
    //on va renvoyer la valeur du 
        int To = (int) differenceInMinutes; //temps d'observation
        return To;
    }
    
    public static int Temps_Arret(ArrayList<Integer> Indice_retenu){ 
    //pour les formats des dates : sera utile pour le calcul du temps d'arret
        String formatDate = "dd/MM/yyyy";
        DateTimeFormatter formatteurD = DateTimeFormatter.ofPattern(formatDate);
        String formatHeure = "HH:mm";
        DateTimeFormatter formatteurH = DateTimeFormatter.ofPattern(formatHeure);
        
    //on va récuperer les différents temps d'arrets relevés sur la periode d'observation (unité : minute) et les additionner ensemble  
        int TpsArret = 0; //initialisation de la variable qui va compter la durée des temps d'arret (en minute)
        for (int i =0; i<(Indice_retenu.size())-1; i=i+2){
           String DateDepart = Liste_Date.get(i+1);
           String DateArret = Liste_Date.get(i);
           String HoraireDepart = Liste_Horaire.get(i+1);
           String HoraireArret = Liste_Horaire.get(i);
           LocalDateTime DD = LocalDateTime.parse(DateDepart, formatteurD);
           LocalDateTime DA = LocalDateTime.parse(DateArret, formatteurD);
           LocalDateTime HD = LocalDateTime.parse(DateDepart, formatteurH);
           LocalDateTime HA = LocalDateTime.parse(DateArret, formatteurH);
    //on va maintenant calculer la différence entre les dates (différence en unité de temps : minute)
        long differenceInMinutesD = ChronoUnit.MINUTES.between(DA, DD);
        long differenceInMinutesH = ChronoUnit.MINUTES.between(HA, HD);
        TpsArret = TpsArret + (int) differenceInMinutesD + (int) differenceInMinutesH;
        }
        System.out.println("la durée des tps d'arrets observée en minute est : "+TpsArret);
    //retour de la durée des temps d'arret de la machine observée (donc aux indices de Indice_retenu)
        return TpsArret; 
    }
    
    
//pour calculer la fiabilité d'une machine donnée
    public static int CalculFiabilite (String machine){
        int i, f; // f c'est la fiabilité
        
        //creation d'une arrayliste des indices trouvés
        ArrayList<Integer> Indice_retenu = new ArrayList<>();
        Indice_retenu.clear(); //on va la réinitialiser à chaque fois pour éviter les erreurs
        
        //on récupère les données du fichier
        Recup_Donnees_Fichier_Texte();
        
        //on va parcourir la liste des Machines à la recherche de la machine dont on souhaite déterminer la fiabilité
        for (i=0; i< (Liste_Machine.size()-1); i++){
            //Indice_retenu.clear(); //on va la réinitialiser à chaque boucle pour éviter les erreurs
            if (machine == Liste_Machine.get(i)){
                Indice_retenu.add(i);
            }
        }
        
        //pour vérifier on les affiche ds la console
        for (i=0; i< (Indice_retenu.size()-1); i++){
            System.out.println("Indice_retenu.get("+i+"): "+Indice_retenu.get(i));
        }
        
        //fiabilité c  1 - (temps d'arrêt : Temps_Arret() /temps d'observation : Temps_Observation())
        f = (1-(Temps_Arret(Indice_retenu)/Temps_Observation()));
        return 0;
    }
    
    
//pour étudier la fiabilité de toutes les machines de l'atelier
    public static ArrayList<Integer> EtudeFiabilite(ArrayList<String> LMA){
        ArrayList<Integer> Liste_Fiabilite_des_Machines = new ArrayList<>();
        
    //on va parcourir la liste des machines de l'atelier (LMA) et calculer pour chaque machine la fiabilité.    
        int i;
        for (i=0; i<(LMA.size()-1); i++){
            String machine_de_atelier = LMA.get(i);
            int f = CalculFiabilite (machine_de_atelier);
            System.out.println(f);
            Liste_Fiabilite_des_Machines.add(f); //donc pour la machine 3 (indice 4 de LMA), la fiabilité sera rangé à l'indice 4 de Liste_Fiabilite_des_Machines.
        }
        
        return Liste_Fiabilite_des_Machines;
    }
    
    //faire une méthode de trie par ordre croissant voir premier semestre
    
    public static String[] TrieFiabilite(int n){
        String[] F = new String[n];
        
        
        return F; //renvoie le tableau rangé ds l'ordre croissant des machines par leur fiabilité
    }
        
}



//public static void initialisationLM(ArrayList<Machine> LM){

                //Machine M1 = new Machine("redTEST","decoupeuse","decoup laser",2,2,10,2,"libre","eqM1","machine1");
                //Machine M2 = new Machine("refTEST2","imprimante","imp 3D",4,4,30,8,"libre","eqM2","machine2");
                //Machine M3 = new Machine("refTEST3","imprimante","imp 3D",6,4,30,8,"libre","eqM2","machine2");
                //Machine M4 = new Machine("refTEST4","soudeur","soude",4,4,30,0,"libre","eqM2","machine2");
                //Machine M5 = new Machine("refTEST5","imprimante","imp 3D",4,3,30,8,"libre","eqM2","machine2");
                //Machine M6 = new Machine("refTEST6","imprimante","imp 3D",4,4,30,8,"libre","eqM2","machine2");
                //LM.add(M1);
                //LM.add(M2);
                //LM.add(M3);
                //LM.add(M4);
                //LM.add(M5);
                //LM.add(M6);
    //}

//ArrayList<Machine> LM = new ArrayList<>();
        //initialisationLM(LM);
        //ArrayList<String> LMA = new ArrayList<>();
        //for (int i=0; i< (LM.size())-1; i++){
        //   LMA.add("Mach_"+i);
       // }
       // CalculFiabilite(LMA.get(1));
        //EtudeFiabilite(LMA);
        //Temps_Observation();

//import static com.mycompany.projet2.Fiabilite.CalculFiabilite;
//import static com.mycompany.projet2.Fiabilite.Recup_Donnees_Fichier_Texte;
//import static com.mycompany.projet2.Fiabilite.EtudeFiabilite;
//import static com.mycompany.projet2.Fiabilite.Temps_Observation;
//import java.util.ArrayList;