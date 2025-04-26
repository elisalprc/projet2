/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2;

//Différents imports nécessaires au bon fonctionnement de cette classe:
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedReader;
/**
 *
 * @author chach
 */
public class ReadFile {
    //Attributs:
    private String path;
    
    //Getters et setters:
    public String getPath(){
        return path;
    }
    public void setPath(String path){
        this.path = path;
    }
    
    //Constructeur:
    public ReadFile (String file_path){
        path = file_path;
    }
    
    //Méthodes:
        //méthode pour déterminer le nombres de lignes d'un fichier texte
    public int CompterLignes() throws IOException{
        FileReader file_to_read = new FileReader (path);
        BufferedReader BF = new BufferedReader (file_to_read);
        String Lignes_restantes;
        int nbLignes = 0;
        while ((Lignes_restantes = BF.readLine()) != null){
            nbLignes=nbLignes+1;
        }
        BF.close();
        return nbLignes;
    }
    
        //pour lire un fichier texte
    public String[] OpenFile() throws IOException {
        FileReader FR = new FileReader(path);
        String[] Data;
        try (BufferedReader textReader = new BufferedReader(FR) //pour conserver en mémoire et aussi parce que bufferedreader possède une méthode pour lire ligne à ligne c'est mieux que caractère par caractère :) enfin je suppose que c plus pratique :)
        ) {
            int nbLignes=CompterLignes();
            Data = new String[nbLignes]; //on crée un tableau pour contenir toutes les lignes de notre texte
            int i;
            for(i=0; i<nbLignes; i++){
                Data[i] = textReader.readLine();
            }
        }
        return Data;
    }
}
