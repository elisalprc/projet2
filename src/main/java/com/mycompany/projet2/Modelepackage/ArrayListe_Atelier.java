/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Modelepackage;

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
   
    public static void atelier_base(){  // methode de classe 
        // objets utiles pour creer les operateurs 
        ArrayList<Equipement> LEQ = new ArrayList<>();
        // pour l'atelier 
        ArrayList<Machine> LM = new ArrayList<>();
        ArrayList<Poste> LPO = new ArrayList<>();
        ArrayList<Produit> LPRO = new ArrayList<>();
        ArrayList<Gamme> LG = new ArrayList<>();
        ArrayList<Operateur> LOP = new ArrayList<>();
        Atelier A1 = new Atelier("atelier test",LM,LPO,LPRO,LG,LOP);
        ArrayList<Machine> LEQp = new ArrayList<>();
        
        // on va entrer des infos dans l'atelier 
        
       Produit a = new Produit("a1","crayon");
       A1.ajoutProduit(a);
       Equipement test = new Equipement("e1","essai");
       Operateur op = new Operateur("turing","alan",1,LEQ);
       op.ajoutEquipement(test);
       Operateur opa = new Operateur("bzz","maya",2,LEQ); //meme liste eq 
       A1.ajoutOperateur(op);
       A1.ajoutOperateur(opa);
       Poste poste1 = new Poste("poste d'essai","poste1",LEQp,"poste d'essai","poste1");
       Machine M1 = new Machine("redTEST","decoupeuse","decoup laser",2,2,10,2,"libre","eqM1","machine1");
       Machine M2 = new Machine("refTEST2","imprimante","imp 3D",4,4,30,8,"libre","eqM2","machine2");
       poste1.ajoutMachine(M1);
       poste1.ajoutMachine(M2);
       A1.ajoutPoste(poste1);

        
    }
    
}  

