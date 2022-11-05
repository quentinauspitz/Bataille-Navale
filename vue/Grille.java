package vue;
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

/**
 * Choix de l'orientation du bateau et de son positionement
 * Vérifie si le bateau peut être placé
 * Si oui, génère le bateau
 */

public boolean posBateau(int[][] plateau, int type, boolean horizontal, int coord_x, int coord_y){
    boolean allOk=true;
    int taille=0;
    int xmax = plateau.length;

    int ymax = plateau[0].length;

    if(type==1){
        taille=5;
    }else if (type==2){
        taille=4;
    }else if (type==3){
        taille=3;
    }else if (type==4){
        taille=3;
    }else if (type==5){
        taille=2;
    }else{
        return false;
    }

