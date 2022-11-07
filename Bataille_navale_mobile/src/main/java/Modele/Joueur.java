/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Quentin Auspitz
 */

public abstract class Joueur {

    protected plateauModele plateauModele;

    /*
     * Recense les cases et leur type :
     * - 0 pour une case qu'on a pas encore visee
     * - 1 pour une case qui a ete visee et ne contenait pas de bateau
     * - 2 pour une case qui a ete visee et qui contenait un bateau
     * - 3 pour une case d'un bateau coule
     */
    protected int[][] grilleTir;

    protected Joueur(int x, int y) {
        plateauModele = new plateauModele(x, y);
        grilleTir = new int[x][y];
        for (int i = 0; i < x; i++)
            for (int j = 0; j < y; j++)
                grilleTir[i][j] = 0;
    }

    /*
     * Interroge le modele pour savoir si le tir en (x,y) a touche
     */
    public int toucher(int x, int y) {
        return plateauModele.toucher(x, y);
    }

    abstract public ArrayList<Integer> tirer();

    public int getSizeX() {
        return plateauModele.getSizeX();
    }

    public int getSizeY() {
        return plateauModele.getSizeY();
    }

    public List<Bateau> getListeBateaux() {
        return plateauModele.getListeBateaux();
    }

    /*
     * Verifie que l'on puisse viser la case grilleTir[x][y]
     */
    public boolean tirEstValide(int x, int y) {
        return grilleTir[x][y] == 0;
    }

    /*
     * Met a jour le type de la case grilleTir[x][y]
     */
    public void invaliderCase(int x, int y, int type) {
        grilleTir[x][y] = type;
    }

    public boolean perdu() {
        return plateauModele.perdu();
    }

    public Bateau getBateau(int x, int y) {
        return plateauModele.getBateau(x, y);
    }

    /*
     * Renvoie le type de la case grilleTir[x][y]
     */
    public int getTirType(int i, int j) {
        return grilleTir[i][j];
    }
}