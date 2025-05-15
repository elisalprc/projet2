/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Modelepackage;

import static com.mycompany.projet2.Fiabilite.CalculFiabilite;
import com.mycompany.projet2.Modelepackage.Atelier;
import com.mycompany.projet2.Modelepackage.Equipement;
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
public class ArrayListe_Atelier { //classe a modifier pour creer un atelier de base
   
    // objets utiles pour creer les operateurs 
        public  ArrayList<Equipement> LEQ = new ArrayList<>();
    // pour l'atelier 
        public   static ArrayList<Machine> LMA = new ArrayList<>();
        public   ArrayList<Poste> LPO = new ArrayList<>();
        public  ArrayList<Produit> LPRO = new ArrayList<>();
        public  ArrayList<Gamme> LG = new ArrayList<>();
        public  ArrayList<Operation> LOPE = new ArrayList<>();
        public  ArrayList<Operateur> LOP = new ArrayList<>();
        public   Atelier atelier1;
        
        public static ArrayList<String> LM = new ArrayList<>();
        //public ArrayList<Double> MachFiabilite = new ArrayList<>();
        
    public ArrayListe_Atelier(){}

    public Atelier getAtelier() {
        return this.atelier1;
    }
    
    public ArrayList<Machine> getLMA(){
        return this.LMA;
    }
    

    public static ArrayList<String> Convertion_LMA_LM(ArrayList<Machine> LMA){
        LMA = InitialisationLMA(LMA);
        for (int i=0; i<LMA.size(); i++){
            LM.add("Mach_"+ String.valueOf(i+1));
            //MachFiabilite.add(CalculFiabilite(LM.get(i))); //on calcul la fiabilite de la machine
            //System.out.println("LM de "+i+" : "+LM.get(i)+" et MachFiabilite de "+i+" = "+MachFiabilite.get(i));
        }
        //System.out.println("la longueur de la liste de LM est : "+LM.size());
        //System.out.println("la methode Convertion_LMA_LM fonctionne");
        return LM;
    }
        
    public static ArrayList<Machine> InitialisationLMA(ArrayList<Machine> LMA){
    //création des machines de référence de l'atelier
        Machine M1 = new Machine("ref:001","découp laser","machine de découpe",0,0,10,2,"libre","machine1","eqDcp");
        Machine M2 = new Machine("ref:002","imprimante 3D","imprimante",5,5,30,8,"libre","machine2","eqimpression");
        Machine M3 = new Machine("ref:003","découp au jet d'eau","machine de découpe",1,7,10,2,"libre","machine3","eqDcp");
        Machine M4 = new Machine("ref:004","tour","machine outil",9,3,30,8,"libre","machine4","eqMO");
        Machine M5 = new Machine("ref:005","fraiseuse","machine outil",2,10,10,2,"libre","machine5","eqMO");
        Machine M6 = new Machine("ref:006","aléseuse","machine outil",10,4,30,8,"libre","machine6","eqMO");
        Machine M7 = new Machine("ref:007","MMT","machine d'essai et test",4,7,30,8,"libre","machine7","eqTest");
    //initialisation de la liste de machine de l'atelier    
        LMA.add(M1);
        LMA.add(M2);
        LMA.add(M3);
        LMA.add(M4);
        LMA.add(M5);
        LMA.add(M6);
        LMA.add(M7); 
        return LMA;
    }
    
    public void InitialisationLPO(){
    //création des postes de référence de l'atelier
        Poste poste1 = new Poste("Tourneur industriel","production de pièces par enlèvement de matières. Peut utiliser : outils de coupe, tour ou fraiseuse",LMA,"poste1","eqTourneur");
        Poste poste2 = new Poste("Opérateur de fabrication","assurer la fabrication des produits. Peut utiliser des machines traditionnelles ou a commande numérique",LMA,"poste2","eqOF");
        Poste poste3 = new Poste("Technicien de maintenance","assure le bon fonctionnement et l'etat optimal des machines de l'atelier de production",LMA,"poste3","eqTM");
        Poste poste4 = new Poste("Technicien qualité","contrôler et assurer les produits fabriqués par l'entreprise",LMA,"poste4","eqTQ");
        Poste poste5 = new Poste("Chef d'atelier","Coordiner et manager les équipes. S'occuper de l'atelier",LMA,"poste5","eqCA");
    //initialisation de la liste des postes de l'atelier
        LPO.add(poste1);
        LPO.add(poste2);
        LPO.add(poste3);
        LPO.add(poste4);
        LPO.add(poste5);
    }
    
    public void InitialisationLEQ(){
        //bah j'ai pas compris ce que c'était un équipement TT est ce que c vraiment utile ??????
    }
    
    public void InitialisationLPRO(){
    //création des produits de référence de notre atelier de fabrication
        Produit Toto_en_metal = new Produit("produit1","Goodies Toto en metal");
        Produit Toto_carosserie = new Produit("produit2","Goodies carosserie Toto pour voiture");
        Produit Toto_statuette = new Produit("produit3","Goodies statue Toto ");
        Produit Toto_robotise = new Produit("produit4","Robot Toto pour vous tenir compagnie et vous servir : c'est un bon compagnon pour discuter");
        Produit Toto_aspirateur = new Produit("produit5","Goodies aspirateur en forme de Toto");
    //initialisation de la liste de produits
        LPRO.add(Toto_en_metal);
        LPRO.add(Toto_carosserie);
        LPRO.add(Toto_statuette);
        LPRO.add(Toto_robotise);
        LPRO.add(Toto_aspirateur);    
    }
    
    public void InitialisationLOP(){
    //création des opérateurs de référence de notre atelier de fabrication
        Operateur op1 = new Operateur("Terrar","Véronique",001,LEQ);
        Operateur op2 = new Operateur("Dupont","Dupuis",002,LEQ);
        Operateur op3 = new Operateur("Petit","Louis",003,LEQ);
        Operateur op4 = new Operateur("Tare","Guy",004,LEQ);
        Operateur op5 = new Operateur("Marchand","Denise",005,LEQ);
    //initialisation de la liste des opérateurs
        LOP.add(op1);
        LOP.add(op2);
        LOP.add(op3);
        LOP.add(op4);
        LOP.add(op5);
    }
    
    public void InitialisationLG(){
    //création des gammes de référence de notre atelier de fabrication
        Gamme gamme1 = new Gamme("gamme1 : pour Toto_en_metal",LOPE,LEQ);
        Gamme gamme2 = new Gamme("gamme2 : pour Toto_carosserie",LOPE,LEQ);
        Gamme gamme3 = new Gamme("gamme3 : pour Toto_statuette",LOPE,LEQ);
        Gamme gamme4 = new Gamme("gamme4 : pour Toto_robotise",LOPE,LEQ);
        Gamme gamme5 = new Gamme("gamme5 : pour Toto_aspirateur",LOPE,LEQ);
    //initialisation de la liste des gammes
        LG.add(gamme1);
        LG.add(gamme2);
        LG.add(gamme3);
        LG.add(gamme4);
        LG.add(gamme5);
    }
    
    public void atelier_base(){  // methode de classe 
        InitialisationLMA(LMA);
        InitialisationLPO();
        InitialisationLEQ();
        InitialisationLPRO();
        InitialisationLOP();
        InitialisationLG();
        this.atelier1 = new Atelier("Atelier de Fabrication",LMA, LPO, LPRO, LG, LOP);
    }
    
}  

 
 