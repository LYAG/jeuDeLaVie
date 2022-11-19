package fr.sdv.ylo.automates;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GrilleTest {

    /**
     * Should return a string with the right number of lines
     */
    @Test
    public void toStringShouldReturnAStringWithTheRightNumberOfLines() {
        Grille grille = new Grille();
        String resultat = grille.toString();
        assertEquals(10, resultat.split("\n").length);
    }

    /**
     * Should return a string with the right number of columns
     */
    @Test
    public void toStringShouldReturnAStringWithTheRightNumberOfColumns() {
        Grille grille = new Grille();
        String resultat = grille.toString();
        assertEquals(11, resultat.length());
    }

    /**
     * Should return a string with the right number of cells
     */
    @Test
    public void toStringShouldReturnAStringWithTheRightNumberOfCells() {
        Grille grille = new Grille();
        String resultat = grille.toString();
        int nbreCellule = grille.getNbreCellule();
        int nbreCelluleDansResultat = 0;
        for (int i = 0; i < resultat.length(); i++) {
            if (resultat.charAt(i) == 'x') nbreCelluleDansResultat++;
        }
        assertEquals(nbreCellule, nbreCelluleDansResultat);
    }

    /**
     * Should not change the number of cells when there is only one cell
     */
    @Test
    public void Ne_devrait_pas_changer_nombre_cellules_quand_une_seule_cellule() {
        Grille grille = new Grille();
        grille.cellule[0][0] = true;
        grille.generationSuivante();
        assertEquals(1, grille.getNbreCellule());
    }

    /**
     * Should not change the number of cells
     */
    @Test
    public void generationSuivanteShouldNotChangeTheNumberOfCells() {
        Grille grille = new Grille();
        int nbreCellule = grille.getNbreCellule();
        grille.generationSuivante();
        assertEquals(nbreCellule, grille.getNbreCellule());
    }


}