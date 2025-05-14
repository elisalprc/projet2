/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2;

import com.mycompany.projet2.FichierTextpackage.ReadFile;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    
    public static int Temps_Arret(String machine) {
    //pour les formats des dates : sera utile pour le calcul du temps d'arret
        String format = "dd/MM/yyyy-HH:mm";
        DateTimeFormatter formatteur = DateTimeFormatter.ofPattern(format);
        
    //on initialise le temps d'arret à 0 et la machine est considérée en marche (le fichier n'est pas encore parcouru donc on part du principe qu'aucune machine ne s'y trouve : cas idéal où tout fonctionne bien dans le meilleur des mondes)
        int TpsArret = 0;
        LocalDateTime arretEnCours = null;
        boolean machinePresente = false;

    //on va calculer le temps d'arret d'une machine, on procède de la façon suivante : 
           //on parcours Liste_Machine (donc les machines dans l'odrdre présentent dans le fichier texte)
           //si la machine entrée s'y trouve, on la note présente (ce qui implique que l'on va calculer son temps d'arret)
           //sinon, la machine reste introuvée -> temps d'arret nul.
    for (int i = 0; i < Liste_Machine.size(); i++) {
        if (machine.equals(Liste_Machine.get(i))) {
            machinePresente = true;
            String evenement = Liste_Evenement.get(i);
            String dateHeure = Liste_Date.get(i) + "-" + Liste_Horaire.get(i);
            LocalDateTime dateEvt = LocalDateTime.parse(dateHeure, formatteur);

            if (evenement.equals("A")) {
                // Si on trouve un nouvel arrêt alors qu'il y en avait déjà un en cours (donc pas fini) : on considère que le précédent arrêt va jusqu'à ce nouvel arrêt. (pour éviter les erreurs inutiles)
                if (arretEnCours != null) {
                    long diff = ChronoUnit.MINUTES.between(arretEnCours, dateEvt);
                    if (diff > 0){
                        TpsArret = TpsArret + (int)diff;
                    }
                }
                arretEnCours = dateEvt;
            } else if (evenement.equals("D") && arretEnCours != null) {
                long diff = ChronoUnit.MINUTES.between(arretEnCours, dateEvt);
                if (diff > 0){
                    TpsArret = TpsArret + (int)diff;
                }
                arretEnCours = null;
            }
        }
    }
    // Si la machine était présente et qu'il reste un arrêt, on va prendre pour durée d'arrêt la période qui va de l'arrêt à aujourd'hui
    if (machinePresente && arretEnCours != null) {
        LocalDateTime Aujourdhui = LocalDateTime.now();
        long diff = ChronoUnit.MINUTES.between(arretEnCours, Aujourdhui);
        if (diff > 0){
            TpsArret += diff;
        }
    }
    // D'où si la machine n'apparait jamais dans le fichier : temps d'arrêt = 0
    return TpsArret;
}
    
    
//pour calculer la fiabilité d'une machine donnée
    public static double CalculFiabilite (String machine){ 
        //on récupère les données du fichier
        Recup_Donnees_Fichier_Texte();
        
        //creation d'une arrayliste des indices trouvés
        ArrayList<Integer> Indice_retenu = new ArrayList<>();
        Indice_retenu.clear(); //on va la réinitialiser à chaque fois pour éviter les erreurs
       
        //on va parcourir la liste des Machines à la recherche de la machine dont on souhaite déterminer la fiabilité
        for (int i=0; i< Liste_Machine.size(); i++){
            if (machine.equals(Liste_Machine.get(i))){ //on utilise .equals() pour comparer des chaïnes de caractère et pas == !!!!!
                Indice_retenu.add(i);
            }
        }
        //initialisation des différents temps necessaire au calcul de la fiabilité
        int tempsArret = Temps_Arret(machine);
        int tempsObservation = Temps_Observation();
        
        //fiabilité : 1 - (temps d'arrêt/temps d'observation)
        double fiabilite = (1 - ((double) tempsArret / (double) tempsObservation)); //double pour résultat décimal sinon on aura 0 ou 1
        return fiabilite;
    }
    
    
//pour étudier la fiabilité de toutes les machines de l'atelier
    public static ArrayList<Double> EtudeFiabilite(ArrayList<String> LMA){
        ArrayList<Double> Liste_Fiabilite_des_Machines = new ArrayList<>();
        
    //on va parcourir la liste des machines de l'atelier (LMA) et calculer pour chaque machine la fiabilité.    
        int i;
        for (i=0; i<(LMA.size()); i++){
            String machine_de_atelier = LMA.get(i);
            double fiabilite = CalculFiabilite (machine_de_atelier);
            System.out.println(fiabilite);
            Liste_Fiabilite_des_Machines.add(fiabilite); //donc pour la machine 3 (indice 4 de LMA), la fiabilité sera rangé à l'indice 4 de Liste_Fiabilite_des_Machines.
        }
        
        return Liste_Fiabilite_des_Machines;
    }
    
    //faire une méthode de trie par ordre croissant voir premier semestre
    
    public static String[] TrieFiabilite(ArrayList<Double> Liste_Fiabilite_des_Machines, ArrayList<String> LMA) {
    //on crée une map pour associer les machines à leur fiabilité : c'est plus facile de traiter une liste à trier plutôt que d'en trier deux en parallèle, ça devrait limiter la casse...
        Map<String, Double> map = new HashMap<>();
    for (int i = 0; i < LMA.size(); i++) {
        map.put(LMA.get(i), Liste_Fiabilite_des_Machines.get(i));
    }

    // On trie ici les entrées de la map en fonction de la fiabilité
    List<Map.Entry<String, Double>> list = new ArrayList<>(map.entrySet());
    list.sort(Map.Entry.comparingByValue()); //sort() est une méthode pour trier des éléments par ordre croissant !!

    // On crée un tableau de résultat que l'on va renvoyer
    String[] F = new String[list.size()];
    for (int i = 0; i < list.size(); i++) {
        F[i] = list.get(i).getKey() + " (fiabilité: " + list.get(i).getValue() + ")";
    }
    return F;
}
        
}

//A rentrer ds le NewFXMain pour tester : (bien sûr il faut enlever les "//"!)

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

//ArrayList<Machine> LM = new ArrayList<>();
  //      initialisationLM(LM);
    //    ArrayList<String> LMA = new ArrayList<>();
      //  for (int i=0; i< (LM.size()); i++){
        //   LMA.add("Mach_"+(i+1));
          // System.out.println(LMA.get(i));
        //}
        //CalculFiabilite(LMA.get(1));
        //EtudeFiabilite(LMA);
        
        //System.out.println(EtudeFiabilite(LMA));
        //Temps_Observation();
        //System.out.println(Temps_Observation());
        //String[] F= TrieFiabilite(EtudeFiabilite(LMA),LMA );
        //for (int i=0; i<F.length; i++ ){
         // System.out.println(F[i]); 
        //}