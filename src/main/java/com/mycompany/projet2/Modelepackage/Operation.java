/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Modelepackage;

/**
 *
 * @author eleprince01
 */
public class Operation {
    private String dOperation;
    private String refOperation;
    private double dureeOperation;
    private String refEquipement;

    public String getdOperation() {
        return dOperation;
    }

    public String getRefOperation() {
        return refOperation;
    }

    public double getDureeOperation() {
        return dureeOperation;
    }

    public String getRefEquipement() {
        return refEquipement;
    }
    
    
    
    
    public Operation(String d,String refOp, double duree, String refEq) {
        this.dOperation = d;
        this.refOperation = refOp;
        this.dureeOperation = duree;
        this.refEquipement = refEq;
    }
    
    public Operation(){}
    
    public void modifDuree(double duree) {
        this.dureeOperation = duree;
    }
    
    public void modifRefEquipement(String refEq){
        this.refEquipement = refEq;
    }
    
    @Override
    public String toString() {
       return "operation : " + this.dOperation + "\n" + "ref : ..."; 
    }
            
    

}
