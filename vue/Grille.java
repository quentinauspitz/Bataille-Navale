public class Grille {
    int[][] plateau;

    /**
     la taille de la grille est fixée à 10

     */
    public Grille(){
        int taille = 10;
        plateau = new int[taille][taille];

        for (int i=0;i<taille;i++) {
            for(int j=0; j<taille;j++) {
                plateau[i][j] = 0;
            }
        }

    }
