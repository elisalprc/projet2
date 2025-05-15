/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet2.Vuepackage;

/**
 *
 * @author chach
 */
public class VueFiabilite {
    
    
    /*
    
     //attributs
    private ControleurFiabilite ctrlF;
    //private VBox cadreParent;
    private TextField machine = new TextField();

    //getteurs et setteurs:

    public TextField getMachine() {
        return machine;
    }

    public void setMachine(TextField machine) {
        this.machine = machine;
    }
    
    //VBox cadreFiab
    
    public SceneFiabilite() {
        //this.cadreParent = cadreFiab;
        this.machine = machine;
    }
    
    static ArrayList<String> LM = new ArrayList<>(); //liste des machines de l'atelier dont on cherche à connaitre la fiabilité
    static ArrayList<Double> MachFiabilite = new ArrayList<>();
    
    
    public static void Convertion_LMA_LM(ArrayList<Machine> LMA){
        for (int i=0; i<LMA.size(); i++){
            LM.add("Mach_"+ String.valueOf(i));
            MachFiabilite.add(CalculFiabilite(LM.get(i))); //on calcul la fiabilite de la machine
            System.out.println("LM de "+i+" : "+LM.get(i)+" et MachFiabilite de "+i+" = "+MachFiabilite.get(i));
        }
        System.out.println("la longueur de la liste de LM est : "+LM.size());
        System.out.println("la methode Convertion_LMA_LM fonctionne");
    }
        
    public static double Afficher_Fiabilite(ArrayList<String> LM , ArrayList<Double> MachFiabilite , String Machine_trouve, Stage stage){
        // recherche et affichage de la fiabilité
            double fiab;
            System.out.println("La machine entrée est : "+Machine_trouve);
            int k = LM.indexOf(Machine_trouve);
            //System.out.println(" position dans la liste de la machine entrée : "+k);
            if (Existance_MachineEntree(k)==true){
                System.out.println("La machine existe dans la liste, elle se situe à la position : "+k);
                fiab = MachFiabilite.get(k);
                //System.out.println("ds méthode Afficher_Fiabilité, la fiab = "+fiab);
            }
            else {
                int n = (LM.size() - 1);
                System.out.println("Erreur : Les machines existantes vont de : "+LM.get(0)+" à : "+LM.get(n)+" Veuillez entrer une nouvelle machine");
                fiab = -1;
                // On va creer un message d'erreur pour prévenir l'utilisateur
                GridPane Message_Erreur = new GridPane();
                Label message  = new Label(" Erreur : La machine entrée n'existe pas dans l'atelier. Veuillez vérifier votre saisie et recommancer ");
                Message_Erreur.add(message, 1, 1);
                Scene sceneErreur = new Scene(Message_Erreur, 650, 30);   // Construire une scène à partir de la racine du graphe de scène
                stage.setScene(sceneErreur);               // The stage sets scene
                stage.setTitle("Message d'erreur");        // Définir le titre de la fenêtre
                stage.show();
            }
        return fiab;
    }
    
    public static void Afficher_ListeFiabilite(){
        
    }
    
    public GridPane getVueFiab(Stage stage) {
    GridPane pane = new GridPane();
    pane.setAlignment(Pos.CENTER);
    pane.setHgap(9.9);
    pane.setVgap(9.9);
       
       //les labels donc fiab et machine :
       pane.add(new Label("Machine :"),0,0);
       TextField machine = new TextField();
       pane.add(machine, 1, 0);
       pane.add(new Label("Fiabilité :"),0,1);
       Label fiabilite = new Label("--");
       
       //ajout et action du bouton qui va afficherl a fiabilite de la machine entrée
        Button btAdd = new Button("Afficher fiabilité");
        pane.add(btAdd, 0, 4);
       
        btAdd.setOnAction((ActionEvent evt) -> {
            Convertion_LMA_LM(LMA); //on initialise les arraylist en vrai elles le seront déjà mais bon c un test
            String Machine_trouve = machine.getText(); 
            //on l'initialise à une valeur qui n'existe pas pour repérer les erreurs
            double fiab = Afficher_Fiabilite(LM , MachFiabilite , Machine_trouve, stage);
            System.out.println("la fiabilité est : "+fiab);
                fiabilite.setText(Double.toString(fiab));
                pane.add(fiabilite,1,1);
                System.out.println("La fiabilité est bien affichée");
            });
       
        Button btAddList = new Button("Afficher la liste de fiabilité");
        pane.add(btAddList, 1, 4);
        
        btAddList.setOnAction(evt -> {
            String[] ListeCroissanteMachineEnFonctionFiab;
            ListeCroissanteMachineEnFonctionFiab = TrieFiabilite(MachFiabilite,LM);
            for (int i=0;i<ListeCroissanteMachineEnFonctionFiab.length;i++) {
                Text text = new Text(ListeCroissanteMachineEnFonctionFiab[i]);
                pane.add(text, 0, (i+5));
            } 
        }); 
       
            
       //pour ouvrir la fenetre, avec le pane et tout (même si ça c'est juste pour tester):
       return pane;
    }
    
    */
}
