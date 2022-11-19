package fr.sdv.ylo.automates;

public class Main {
    public static void main(String[] args) {
        Grille grille= new Grille();
        for (int i = 0; i < 10; i++){
            System.out.println(grille);
            grille.generationSuivante();
        }
    }
}