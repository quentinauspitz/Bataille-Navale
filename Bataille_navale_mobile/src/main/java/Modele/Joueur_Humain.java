/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele;

import java.util.ArrayList;

/**
 *
 * @author Quentin Auspitz
 */

public class Joueur_Humain extends Joueur {

    public Joueur_Humain(int x, int y) {
        super(x, y);
        // TODO Auto-generated constructor stub
    }

    /*
     * La fonction tirer de l'humain n'est pas utilisee car c'est la detection du
     * click
     * qui declenche le tir.
     */
    @Override
    public ArrayList<Integer> tirer() {
        return new ArrayList<>();
    }

    /*
     * Ajoute un bateau au modele du joueur
     */
    public void poser(int x, int y, int direction, int type) {
        plateauModele.poser(x, y, direction, type);
    }

    public void remove(int x, int y) {
        plateauModele.supprimerBateau(x, y);
    }

}