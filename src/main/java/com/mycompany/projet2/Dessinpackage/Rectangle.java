/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Dessinpackage;

import static com.mycompany.projet2.Modelepackage.ArrayListe_Atelier.LMA;
import com.mycompany.projet2.Modelepackage.Machine;
import java.util.ArrayList;

/**
 *
 * @author chach
 */
public class Rectangle {
//attributs:
    public float lon;
    public float lar;
    public static double ori_x;
    public static double ori_y;
//getters et setters :
    public float getLon() {
        return lon;
    }
    public float getLar() {
        return lar;
    }
    public double getOri_x() {
        return ori_x;
    }
    public double getOri_y() {
        return ori_y;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }
    public void setLar(float lar) {
        this.lar = lar;
    }
    public void setOri_x(double ori_x) {
        this.ori_x = ori_x;
    }
    public void setOri_y(double ori_y) {
        this.ori_y = ori_y;
    }
    
//constructeur:
    public Rectangle(double ori_x, double ori_y) {
        this.lon = 5;
        this.lar = 3;
        this.ori_x = ori_x;
        this.ori_y = ori_y;
    }
   
//methodes :
    public void deplacer(double x, double y) {
        this.ori_x = this.ori_x + x;
        this.ori_y = this.ori_y + y;
    }
    
    @Override
    public String toString() {
        return "Rectangle [lon=" + lon + ", lar=" + lar + ", ori_x=" + ori_x + ", ori_y=" + ori_y + "]";
    }
    
    //on créer un rectangle par machine présente dans l'atelier en récupérant leur origine
    public static ArrayList<Rectangle> Initialisation_Liste_rect(){ 
        ArrayList<Rectangle> Liste_rec = new ArrayList<Rectangle>();
        for (int i=0; i<LMA.size(); i++){
            Machine machine = LMA.get(i);
            ori_x= machine.getOrigine_x();
            ori_y= machine.getOrigine_y();
            Rectangle rec = new Rectangle(ori_x, ori_y);
            Liste_rec.add(rec);
        }
        return Liste_rec;
    }
}
