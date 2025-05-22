/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Modelepackage;

import java.util.ArrayList;

/**
 *
 * @author clema
 */
public class Poste extends Equipement {
    private String refPoste;
    private String dPoste;
    private ArrayList<Machine> listeMachine;

    public String getRefPoste() {
        return refPoste;
    }

    public String getdPoste() {
        return dPoste;
    }

    public ArrayList<Machine> getListeMachine() {
        return listeMachine;
    }

    public void setRefPoste(String refPoste) {
        this.refPoste = refPoste;
    }

    public void setdPoste(String dPoste) {
        this.dPoste = dPoste;
    }

    public void setListeMachine(ArrayList<Machine> listeMachine) {
        this.listeMachine = listeMachine;
    }
    
    public void ajoutMachine(Machine m) {
        this.listeMachine.add(m);
    }

    public Poste(String refPoste, String dPoste, ArrayList<Machine> listeMachine, String refEquipement, String dEquipement) {
        super(refEquipement, dEquipement);
        this.refPoste = refPoste;
        this.dPoste = dPoste;
        this.listeMachine = listeMachine;
    }
    
    public void afficherPoste(){
        System.out.println("référence du poste = "+ this.refPoste);
        System.out.println("désignation du poste = "+ this.dPoste);
        System.out.println("liste des machines = "+ this.listeMachine);
    }
    
    public void modifierPoste(String refPoste, String dPoste, ArrayList<Machine> listeMachine){
        this.refPoste = refPoste;
        this.dPoste = dPoste;
        this.listeMachine = listeMachine;
    }
    // rq : pas besoin de dPoste et refPoste car la super classe lui assigne deja je crois (ca fait repeter la meme chose)
}
