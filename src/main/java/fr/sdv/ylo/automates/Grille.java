/**
 *
 */
package fr.sdv.ylo.automates;
import java.util.Random;

public class Grille {

    public static final int COLONNE=10;
    public static final int LIGNE=5;
    boolean[][] cellule= new boolean[COLONNE][LIGNE];
    boolean debugVoisin=false;
    Random generer= new Random();

    /**
     *
     */
    public Grille(){
        for (int i = 0; i < 10; i++) {

            int x=0;
            int y=0;
            do {
                x= generer.nextInt(COLONNE);
                y=generer.nextInt(LIGNE);
            }while (cellule[x][y]);

            cellule[x][y]=true;
        }
    }

    private boolean estInclus(int r, int c){
        return r>-1 && r<COLONNE && c>-1 && c<LIGNE;
    }

    /**
     *
     * @param r
     * @param c
     * @return vrai si une cellule survie faur si non
     */
    private boolean survivant(int r, int c) {
        if (!cellule[r][c])
            return false;
        int nbreVie = nbreVoisin(r, c);

        return nbreVie == 3;
    }

    /**
     *
     * @param r
     * @param c
     * @return
     */
    private boolean naissance(int r, int c){
       return !cellule[r][c] && nbreVoisin(r,c)==3;
    }

    /**
     *
     * @return
     */
    public int getNbreCellule(){

        int resultat = 0;

        for (int r = 0; r < COLONNE; r++)

            for( int c=0; c<LIGNE;c++)

                if (cellule[r][c])

                    resultat++;

        return resultat;
    }

    /**
     *
     */
    public void generationSuivante(){

        boolean[][] celluleNext= new boolean[COLONNE][LIGNE];

        for (int r = 0; r < COLONNE; r++)

            for (int c=0;c < LIGNE; c++)

                celluleNext[r][c] = naissance(r,c) || survivant(r,c);

        cellule=celluleNext;
    }

    /**
     *
     * @param r
     * @param c
     * @return
     */
    private int nbreVoisin(int r, int c) {

        int resultat = 0;

        for (int col = r - 1; col < r + 2; col++)

            for (int lig = c - 1; lig < c + 2; lig++)

                if (estInclus(col, lig) && cellule[col][lig])

                    resultat++;

        return resultat;

    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder resultat = new StringBuilder();
        for (int lig = 0; lig < LIGNE; lig++){

            for (int col = 0; col < COLONNE; col++){
                if (col == 0)
                    resultat.append("|");
                if (cellule[col][lig])
                    resultat.append("x");
                else
                    resultat.append(" ");
                if (debugVoisin)
                    resultat.append(nbreVoisin(col, lig));
                resultat.append("|");
            }
            resultat.append("\n");
        }
        return resultat.toString();
    }
}
