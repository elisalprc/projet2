/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.FichierTextpackage;

//Differents imports necessaires au bon fonctionnement de cette classe:
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Locale;

/**
 *
 * @author chach
 */
public class WriteFile {
    //Attributs:
        private String path; //ça sera le nom et l'emplacement d'un fichier
        private boolean append_to_file = true; //la valeur d'ajout par défaut est vraie parce qu'on veut ajouter de nouvelles valeurs au fichier et pas seulement écraser les anciennes valeurs et donner des nouvelles.
    
    //Getters et setters:
        public String getPath(){
            return path;
        }
        public void setPath(String path){
            this.path = path;
        }
        public boolean getAppend_to_file(){
            return true;
        }
        public void setAppend_to_file(boolean append_to_file){
            this.append_to_file = append_to_file;
        }
        
    //Constructeurs:
        //ce premier constructeur sert à ajouter des informations dans le fichier ! vu que valeur d'ajout par défault = true!
        public WriteFile (String file_path){
            path=file_path;
        }
        //avec ce deuxième constructeur on peut choisir la valeur d'ajout : true pour ajouter et false pour écraser ce qu'il y avait avant et écrire.
        public WriteFile (String file_path, boolean valeur_d_ajout){
            path=file_path;
            append_to_file=valeur_d_ajout;
        }
        
    //Methodes:
        //cette méthode va écrire le text (Text) dans le fichier,et gérer les erreurs possibles liées à l'écriture deans le fichier.
        public void writeToFile(String Text)throws IOException{
            FileWriter ecrire = new FileWriter(path, append_to_file);
            try (PrintWriter print_line = new PrintWriter (ecrire)) {
                print_line.printf("%s"+"%n", Text); //donc ici on utilise 2 possibilités de la méthode printf : "%s" pour écrire un text (donc ici c'est le deuxième argument Text) sans limite de taille ou longueur et "%n" va nous permettre de sauter à la ligne après pour mieux se repérer.
            } //donc ici on utilise 2 possibilités de la méthode printf : "%s" pour écrire un text (donc ici c'est le deuxième argument Text) sans limite de taille ou longueur et "%n" va nous permettre de sauter à la ligne après pour mieux se repérer.
        }
}
