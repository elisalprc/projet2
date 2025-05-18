/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Modelepackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


/**
 *
 * @author clema
 */
public class Machine extends Equipement {
    private String refMachine;
    private String type;
    private String dmachine;
    private double origine_x;
    private double origine_y;
    private double cout;
    private String etat; // description de l'etat
    
    //j'ai retiré le temps d'utilisation, qui est donné par l'operation 

    public String getRefMachine() {
        return refMachine;
    }

    public String getType() {
        return type;
    }

    public String getDmachine() {
        return dmachine;
    }

    public double getOrigine_x() {
        return origine_x;
    }

    public double getOrigine_y() {
        return origine_y;
    }

    public double getCout() {
        return cout;
    }

    public String getEtat() {
        return etat;
    }

    public void setRefMachine(String refMachine) {
        this.refMachine = refMachine;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDmachine(String dmachine) {
        this.dmachine = dmachine;
    }

    public void setOrigine_x(double origine_x) {
        this.origine_x = origine_x;
    }

    public void setOrigine_y(double origine_y) {
        this.origine_y = origine_y;
    }

    public void setCout(double cout) {
        this.cout = cout;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Machine(String refMachine, String type, String dmachine, double origine_x, double origine_y, double cout, String etat, String refEquipement, String dEquipement) {
        super(refEquipement, dEquipement);
        this.refMachine = refMachine;
        this.type = type;
        this.dmachine = dmachine;
        this.origine_x = origine_x;
        this.origine_y = origine_y;
        this.cout = cout;
        this.etat = etat;
    }
    
    public Machine(String refMachine, String type, String dmachine, double origine_x, double origine_y, double cout, String etat) {
        this.refMachine = refMachine;
        this.type = type;
        this.dmachine = dmachine;
        this.origine_x = origine_x;
        this.origine_y = origine_y;
        this.cout = cout;
        this.etat=etat;
    }
    
    public void afficherMachine(){
        System.out.println("référence de la machine = "+ this.refMachine);
        System.out.println("type de la machine = "+ this.type);
        System.out.println("dmachine = "+ this.dmachine);
        System.out.println("Origine = ("+ this.origine_x + "," + this.origine_y + ")");
        System.out.println("cout de la Machine = "+ this.cout);
        System.out.println("Etat de la Machine = "+ this.etat);
    }
    
    @Override 
    public String toString() {
        return this.dmachine + "\n ref : " + this.refMachine + "\n type : " + this.type + "\n endroit : " + this.origine_x + "," + this.origine_y + "\n cout : " + this.cout + "\n etat : "+ this.etat;
    }
    
    public void modifierMachine(String type, String ref, String dmachine, double origine_x, double origine_y, double cout, String etat) {
        this.type = type;
        this.refMachine = ref;
        this.dmachine = dmachine;
        this.origine_x = origine_x;
        this.origine_y = origine_y;
        this.cout = cout;
        this.etat = etat;
    }
    
}
