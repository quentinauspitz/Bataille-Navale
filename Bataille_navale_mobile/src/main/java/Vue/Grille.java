package Vue;

public class Grille {
    int[][] plateau;

    /**
     * la taille de la grille est fixée à 10
     * 
     */
    public Grille() {
        int taille = 10;
        plateau = new int[taille][taille];

        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                plateau[i][j] = 0;
            }
        }

    }

    /**
     * Choix de l'orientation du bateau et de son positionement
     * Vérifie si le bateau peut être placé
     * Si oui, génère le bateau
     */

    public boolean posBateau(int[][] plateau, int type, boolean horizontal, int coord_x, int coord_y) {
        boolean allOk = true;
        int taille = 0;
        int xmax = plateau.length;

        int ymax = plateau[0].length;

        // Mettre nom des bateaux

        if (type == 1) {
            taille = 5;
        } else if (type == 2) {
            taille = 4;
        } else if (type == 3) {
            taille = 3;
        } else if (type == 4) {
            taille = 3;
        } else if (type == 5) {
            taille = 2;
        } else {
            return false;
        }

        if (!horizontal) {
            if (coord_y + taille > ymax) {
                return false;
            }
            for (int i = 0; i < taille; i++) {
                if (plateau[coord_y + i][coord_x] != 0) {
                    allOk = false;
                }
            }
        }

        if (horizontal) {
            if (coord_x + taille > xmax) {
                return false;
            }
            for (int i = 0; i < taille; i++) {
                if (plateau[coord_y][coord_x + i] != 0) {
                    allOk = false;
                }
            }
        }

        if (allOk) {
            genererBateaux(plateau, coord_x, coord_y, taille, horizontal);
            return true;
        } else {
            return false;
        }
    }

    // Placement du bateau sur la grille

    private void genererBateaux(int[][] plateau, int coord_y, int coord_x, int taille, boolean horizontal) {

        if (horizontal) {
            for (int j = coord_y; j < coord_y + taille; j++)
                plateau[coord_x][j] = 1;
        } else {
            for (int i = coord_x; i < taille + coord_x; i++)
                plateau[i][coord_y] = 1;
        }
    }
}
