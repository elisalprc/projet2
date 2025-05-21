/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Dessinpackage;

/**
 *
 * @author chach
 */
public class ControleurSchema_Atelier {
    private VueSchema_Atelier vue;
    
    public ControleurSchema_Atelier(VueSchema_Atelier vue) {
        this.vue = vue;
    }
    
    public void Afficher_Atelier() {
        this.vue.getVueAt().getChildren().clear(); //pour que les affichages ne s'empilent pas 
    }
}
