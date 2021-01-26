import java.io.File;
import java.util.ArrayList;

public class Sommet {
    private int nom;
    private ArrayList<Integer> table_successeurs;           // Liste de sucesseurs
    private ArrayList<Integer> poids_successeurs;           // Le tableau des poids
    private ArrayList <Integer> table_predecesseurs;        // Liste des predecesseurs
    private ArrayList <Integer> poids_predecesseurs;        // Liste des poids de predecesseurs
    private int rang = -1;


    public Sommet(int[][] transitions, int nom)
    {
        this.nom = nom;
        this.table_predecesseurs = this.parcourssuccesseurs(transitions, false)[0];
        this.poids_predecesseurs = this.parcourssuccesseurs(transitions, false)[1];
        this.table_successeurs = this.parcourssuccesseurs(transitions, true)[0];
        this.poids_successeurs = this.parcourssuccesseurs(transitions, true)[1];
    }


    public ArrayList<Integer>[] parcourssuccesseurs(int[][] transitions, boolean successeur) // Si successeur faux on retourne predecesseur
    {
        ArrayList<Integer>[] successeurs = new ArrayList[2];
        successeurs[0] = new ArrayList<>();         // Dans le tableau, case 1 on a la liste des successeurs / prédecesseurs
        successeurs[1] = new ArrayList<>();         // Dans la 2e case on a le poids des arcs
        for(int i = 0; i< transitions.length; i++)
        {
            if(successeur)                          // On crée le tableau de successeurs
            {
                if(transitions[i][0]==this.nom)     // On rappelle que i représente chaque transition et que [0] = source [1] = cible [2] = poids
                {
                    successeurs[0].add(transitions[i][1]);  // On ajoute à la liste
                    successeurs[1].add(transitions[i][2]);
                }
            }
            else {                                  // On crée celui des prédecesseurs
                if(transitions[i][1]==this.nom)     // On rappelle que i représente chaque transition et que [0] = source [1] = cible [2] = poids
                {
                    successeurs[0].add(transitions[i][0]);
                    successeurs[1].add(transitions[i][2]);
                }
            }

        }
        return successeurs;
    }

    // getters


    public int getNom() {
        return this.nom;
    }

    public ArrayList<Integer> getPoids_successeurs() {
        return poids_successeurs;
    }

    public ArrayList<Integer> getPoids_predecesseurs() {
        return poids_predecesseurs;
    }

    public ArrayList<Integer> getTable_predecesseurs() {
        return table_predecesseurs;
    }

    public ArrayList<Integer> getTable_successeurs() {
        return table_successeurs;
    }

    public int getRang() {
        return rang;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }
}
