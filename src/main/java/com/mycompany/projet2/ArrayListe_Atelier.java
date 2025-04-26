/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2;

import java.util.ArrayList;

/**
 *
 * @author chach
 */
public class ArrayListe_Atelier {
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
    
    Machine M1 = new Machine("redTEST","decoupeuse","decoup laser",2,2,10,2,"libre","eqM1","machine1");
    Machine M2 = new Machine("refTEST2","imprimante","imp 3D",4,4,30,8,"libre","eqM2","machine2");
    
    //et instancier ou remplir à la rigueur les listes ici ou ds atelier mais pas dans projetsS2 pour éviter de surcharger le code du main
}  
