/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Vuepackage;

/**
 *
 * @author chach
 */
public class VerificationDonneeEntree {
    public static boolean Existance_MachineEntree(int i){
        if (i == -1){
            System.out.println("Erreur : La machine entrée n'existe pas. Veuillez vérifier votre saisie");
            return false;
        }
        else{
            return true;
        }
    }
}
