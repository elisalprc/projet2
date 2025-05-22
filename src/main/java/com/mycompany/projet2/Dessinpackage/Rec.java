/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Dessinpackage;

//import static com.mycompany.projet2.Modelepackage.ArrayListe_Atelier.LMA;
import com.mycompany.projet2.Modelepackage.Machine;
import java.util.ArrayList;

/**
 *
 * @author chach
 */
public class Rec {
    private double lon;
    private double lar;
    private double ori_x;
    private double ori_y;
    
    Rec(double ox, double oy) {
        this.lon = 55;
        this.lar = 67;
        this.ori_x = ox;
        this.ori_y = oy;
    }
    
    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLar() {
        return lar;
    }

    public void setLar(double lar) {
        this.lar = lar;
    }

    public double getOri_x() {
        return ori_x;
    }

    public void setOri_x(double ori_x) {
        this.ori_x = ori_x;
    }

    public double getOri_y() {
        return ori_y;
    }

    public void setOri_y(double ori_y) {
        this.ori_y = ori_y;
    }


    @Override
    public String toString() {
        return "Rectangle [lon=" + lon + ", lar=" + lar + ", ori_x=" + ori_x + ", ori_y=" + ori_y + "]";
    }
    
    //on créer un rectangle par machine présente dans l'atelier en récupérant leur origine
    public static ArrayList<Rec> Initialisation_Liste_rec(ArrayList<Machine> LMA){ 
        ArrayList<Rec> Liste_rec = new ArrayList<Rec>();
        for (int i=0; i<LMA.size(); i++){
            Machine machine = LMA.get(i);
            Rec rec = new Rec(machine.getOrigine_x(), machine.getOrigine_y());
            Liste_rec.add(rec);
        }
        return Liste_rec;
    }
}

