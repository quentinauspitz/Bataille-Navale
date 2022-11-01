/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

import java.util.Vector;

/**
 *
 * @author Quentin Auspitz
 */

public class Joueur_Humain extends Joueur{

    public Humain (int x, int y){
        super(x, y);
    }

    /*
     * La fonction tirer de l'humain n'est pas utilisee car c'est la detection du click
     * qui declenche le tir.
     */
    @Override
    public Vector<Integer> tirer() {
        return null;
    }

    /*
     * Ajoute un bateau au modele du joueur
     */
    public void poser (int x, int y, int direction, int type) {
        plateauModele.poser(x, y, direction, type);
    }

    public void remove(int x, int y) {
        plateauModele.supprimerBateau(x,y);
    }


}