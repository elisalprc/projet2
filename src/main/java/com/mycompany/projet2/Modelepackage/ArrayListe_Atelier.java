/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Modelepackage;

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
        public   static ArrayList<Poste> LPO = new ArrayList<>();
        public   static ArrayList<Produit> LPRO = new ArrayList<>();
        public   static ArrayList<Gamme> LG = new ArrayList<>();
        public   static ArrayList<Operation> LOPE = new ArrayList<>();
        public   static ArrayList<Operateur> LOP = new ArrayList<>();
        public   Atelier atelier1;
        
        public static ArrayList<String> LM = new ArrayList<>();
        public static ArrayList<String> LP = new ArrayList<>();
        
        
    public ArrayListe_Atelier(){}

    public Atelier getAtelier() {
        return this.atelier1;
    }
    

    public static ArrayList<String> Convertion_LMA_LM(ArrayList<Machine> LMA){
        LM.clear();
        for (int i=0; i<LMA.size(); i++){
            LM.add("Mach_"+ String.valueOf(i+1));
        }
        return LM;
    }
    
    public static ArrayList<String> Convertion_LPRO_LP(ArrayList<Produit> LPRO){
        LP.clear();
        for (int i=0; i<LPRO.size(); i++){
            LP.add("produit"+ String.valueOf(i+1));
        }
        return LP;
    }
        
    public static ArrayList<Machine> InitialisationLMA(ArrayList<Machine> LMA){
    //création des machines de référence de l'atelier
        Machine M1 = new Machine("Mach_1","découp laser","machine de découpe",1,1,27035,"libre","machine1","eqDcp");
        Machine M2 = new Machine("Mach_2","imprimante 3D","imprimante",450,30,30199,"libre","machine2","eqimpression");
        Machine M3 = new Machine("Mach_3","découp au jet d'eau","machine de découpe",1,30,20729,"libre","machine3","eqDcp");
        Machine M4 = new Machine("Mach_4","tour","machine outil",100,20,4089,"libre","machine4","eqMO");
        Machine M5 = new Machine("Mach_5","fraiseuse","machine outil",70,900,1000,"libre","machine5","eqMO");
        Machine M6 = new Machine("Mach_6","aléseuse","machine outil",120,70,300,"libre","machine6","eqMO");
        Machine M7 = new Machine("Mach_7","MMT","machine d'essai et test",40,50,90995,"libre","machine7","eqTest");
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
    
    public void InitialisationLOPE() {
        Operation op1 = new Operation("decouper","dcp1", 2, "eqDcp");
        Operation op2 = new Operation("imprimer","impr1",1,"eqimpression");
        Operation op3 = new Operation("tester","test1",3,"eqtest");
        Operation op4 = new Operation("percer","trou1",2,"eqMO");
        this.LOPE.add(op1);
        this.LOPE.add(op2);
        this.LOPE.add(op3);
        this.LOPE.add(op4);
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
        InitialisationLPO();
        this.LMA = InitialisationLMA(this.LMA);
        for(Poste poste : this.LPO) {
            this.LEQ.add(poste);
        }
        for(Machine machine : this.LMA) {
            this.LEQ.add(machine);
        }
    }
    
    public void InitialisationLPRO(){
    //création des produits de référence de notre atelier de fabrication
        Produit Toto_en_metal = new Produit("produit1","Goodies Toto en metal");
        Produit Toto_carosserie = new Produit("produit2","Carosserie Toto");
        Produit Toto_statuette = new Produit("produit3","Goodies statue Toto ");
        Produit Toto_robotise = new Produit("produit4","Robot Toto"); //pour vous tenir compagnie et vous servir : c'est un bon compagnon pour discuter
        Produit Toto_aspirateur = new Produit("produit5","Aspirateur Toto");
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
        InitialisationLPRO();
    //création des gammes de référence de notre atelier de fabrication
        Gamme gamme1 = new Gamme(this.LPRO.get(0),"gamme1",LOPE,LEQ);
        Gamme gamme2 = new Gamme(this.LPRO.get(1),"gamme2",LOPE,LEQ);
        Gamme gamme3 = new Gamme(this.LPRO.get(2),"gamme3",LOPE,LEQ);
        Gamme gamme4 = new Gamme(this.LPRO.get(3),"gamme4",LOPE,LEQ);
        Gamme gamme5 = new Gamme(this.LPRO.get(4),"gamme5",LOPE,LEQ);
    //initialisation de la liste des gammes
        LG.add(gamme1);
        LG.add(gamme2);
        LG.add(gamme3);
        LG.add(gamme4);
        LG.add(gamme5);
    }
    
    public void atelier_base(){  // methode de classe 
        //InitialisationLMA(LMA);
        //InitialisationLPO();  //plus besoin car init dans InitialisationLEQ
        InitialisationLEQ();
        //InitialisationLPRO();  fait dans Gamme
        InitialisationLOP();
        InitialisationLG();
        InitialisationLOPE();
        this.atelier1 = new Atelier("Atelier de Fabrication",LMA, LPO, LPRO, LG, LOP,LEQ,LOPE);
    }
    
}  

 
 