import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        int choix = 1;
        String fichier = "";
        Scanner sc = new Scanner(System.in);

        while (choix != 0) {
            System.out.println("Entrer le numéro du graphe que vous souhaitez lire");
            System.out.println("Pour quitter, entrez 0");
            System.out.print("Votre choix: ");
            choix = sc.nextInt();

            while (choix < 0 || choix >= 13) {
                System.out.println("Ce graphe n'existe pas. \n");
                System.out.println("Entrer le numéro du graphe que vous souhaitez lire");
                System.out.println("Pour quitter, entrez 0");
                System.out.print("Votre choix: ");
                choix = sc.nextInt();
            }

            if (choix != 0) {
                fichier = "L3-A2-graphe " + String.valueOf(choix) + ".txt";
		//affichage du graphe choisie
		System.out.println("Graphe " +  String.valueOf(choix) + " :" );
		Graphe.Write("RenduFinal.txt", "Graphe " +  String.valueOf(choix) + " :" );
		
                Graphe read = new Graphe(new File((fichier)));
                read.afficherMatriceAdjacence();
		read.afficherMatriceValeur();
                boolean affiche = true;
                if (read.pas_circuit(affiche))
                {
                    read.rang(affiche);
                    read.ordonnancement();
                }

            }
            System.out.println();
        }
    }
}
