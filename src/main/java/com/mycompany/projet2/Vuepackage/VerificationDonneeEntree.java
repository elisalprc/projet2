/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Vuepackage;

import java.util.ArrayList;
import java.util.StringTokenizer;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

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
    //pour afficher un message d'erreur si la donnée entrée est erronée ou invalide
    public static void AfficherErreur(String message) {
        Stage erreurStage = new Stage();
        erreurStage.setTitle("Erreur");
        GridPane root = new GridPane();
        
        // pour que le message apparraisse lisiblement on va le couper pour faire des sauts de lignes
        ArrayList<String> tokens = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(message, ".");
        while (tokenizer.hasMoreTokens()) { 
            tokens.add(tokenizer.nextToken()); 
        }
        for (int i=0; i<tokens.size(); i++){
            Label label = new Label(tokens.get(i));
            root.add(label, 0, i);
        }
                
        Scene scene = new Scene(root, 500, 100);
        erreurStage.setScene(scene);
        erreurStage.setResizable(false);
        erreurStage.show();
    }
}
