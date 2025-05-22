/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.FichierTextpackage;

//DIFFERENCE ENTRE CHEMIN RELATIF ET ABSOLU FIABILITE ET SUIVI MAINTENANCE

import com.mycompany.projet2.FichierTextpackage.ReadFile;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
        tokens.clear();
        
    //chemin du fichier à lire et décomposer   
        String file_name = "SuiviMaintenance.txt";
        ReadFile file = new ReadFile(file_name);
        
    // pour lire le fichier texte et récupérer chaque ligne dans une liste
    try {
        //InputStream input = Fiabilite.class.getResourceAsStream(file_name);
        //if (input == null) {
          //System.out.println("Le fichier n'a pas été trouvé !");
          //return;
        //}
    //BufferedReader reader = new BufferedReader(new InputStreamReader(input));
    String[] lignes = file.OpenFile();
    for (String ligne : lignes) { //boucle for each pour parcourir tous les étements !!!
        if (ligne != null && !ligne.isEmpty()){ //on vérifie que la lignes n'est pas nulle pour éviter les erreurs !
            StringTokenizer tokenizer = new StringTokenizer(ligne, ";");
        while (tokenizer.hasMoreTokens()) {
            tokens.add(tokenizer.nextToken());
        }
    }
    }
    
    //reader.close();
    } 
    catch(IOException e) {
        System.out.println("Une erreur est survenue à la lecture, désolé, veuillez recommencer");
    }
    k = 0;
        Liste_Date.clear();
        Liste_Horaire.clear();
        Liste_Machine.clear();
        Liste_Evenement.clear();
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
        double fiabiliteArrondie = (double)Math.round(fiabilite * 100000) / 100000;
        
        return fiabiliteArrondie;
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
    
    public static String[] TrieFiabilite(ArrayList<Double> Liste_Fiabilite_des_Machines, ArrayList<String> LM) {
    //on crée une map pour associer les machines à leur fiabilité : c'est plus facile de traiter une liste à trier plutôt que d'en trier deux en parallèle, ça devrait limiter la casse...
        Map<String, Double> map = new HashMap<>();
    for (int i = 0; i < LM.size(); i++) {
        map.put(LM.get(i), Liste_Fiabilite_des_Machines.get(i));
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