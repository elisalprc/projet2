/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2;

/**
 *
 * @author clema
 */
public class Equipement {
     private String refEquipement;
    private String dEquipement;

    public String getRefEquipement() {
        return refEquipement;
    }

    public String getdEquipement() {
        return dEquipement;
    }

    public void setRefEquipement(String refEquipement) {
        this.refEquipement = refEquipement;
    }

    public void setdEquipement(String dEquipement) {
        this.dEquipement = dEquipement;
    }

    public Equipement(String refEquipement, String dEquipement) {
        this.refEquipement = refEquipement;
        this.dEquipement = dEquipement;
    }
    
    public Equipement(){}
    
    @Override
    public String toString(){
        return "equipement : " + this.dEquipement + ", ref : " + this.refEquipement;
    }
}
