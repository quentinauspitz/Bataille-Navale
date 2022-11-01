/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Quentin Auspitz
 */

public class Joueur_Machine extends Joueur {

    public Joueur_Machine(int tailleX, int tailleY, int nbTorpilleur, int nbContreTorpilleur, int nbCroiseur,
            int nbPorteAvion) {
        super(tailleX, tailleY);
        Runnable run = new initPlateau(plateauModele, nbTorpilleur, nbContreTorpilleur, nbCroiseur, nbPorteAvion,
                tailleX, tailleY);
        Thread t = new Thread(run);
        t.start();
    }

    /*
     * Construit un vecteur de tir selon la strategie de l'IA facile :
     * les coordonnees choisie sont entierement aleatoire
     */
    @Override
    public ArrayList<Integer> tirer() {
        ArrayList<Integer> cible = new ArrayList<>();
        int x, y;
        do {
            x = (int) (Math.random() * plateauModele.getSizeX());
            y = (int) (Math.random() * plateauModele.getSizeY());
        } while (getTirType(x, y) != 0);

        cible.add(0, x);
        cible.add(1, y);

        return cible;
    }

    /*
     * Positionne les bateaux de l'IA.
     * Execute dans un thread a part pour etre effectue en meme temps que la
     * placement du
     * joueur et pour eviter que cette operation qui peut etre assez longue ne soit
     * arretee
     * par le systeme avant d'avoir termine
     */
    private class initPlateau implements Runnable {
        private plateauModele plateau;
        private int nbTorpilleur;
        private int nbContreTorpilleur;
        private int nbCroiseur;
        private int nbPorteAvion;
        private int sizeX;
        private int sizeY;

        public initPlateau(plateauModele plateau, int nbTorpilleur, int nbContreTorpilleur, int nbCroiseur,
                int nbPorteAvion, int sizeX, int sizeY) {
            this.plateau = plateau;
            this.nbTorpilleur = nbTorpilleur;
            this.nbContreTorpilleur = nbContreTorpilleur;
            this.nbCroiseur = nbCroiseur;
            this.nbPorteAvion = nbPorteAvion;
            this.sizeX = sizeX;
            this.sizeY = sizeY;
        }

        @Override
        public void run() {
            final int tentativeMax = 5;
            int x;
            int y;
            double direction;
            boolean reussi;
            do {
                reussi = true;
                plateau.clear();
                for (int i = 0; i < nbPorteAvion; i++) {
                    if (reussi) {
                        int nbTentative = 0;
                        do {
                            direction = Math.random();
                            if (direction < 0.5) {
                                // Vertical
                                x = (int) (Math.random() * sizeX);
                                y = (int) (Math.random() * (sizeY - 5));
                                direction = Bateau.VERTICAL;
                            } else {
                                // Horizontal
                                x = (int) (4 + Math.random() * (sizeX - 5));
                                y = (int) (Math.random() * (sizeY - 5));
                                direction = Bateau.HORIZONTAL;
                            }
                            reussi = plateau.poser(x, y, (int) direction, Bateau.PORTE_AVION);
                        } while (!reussi && nbTentative++ < tentativeMax);
                    } else
                        break;
                }
                if (reussi)
                    for (int i = 0; i < nbCroiseur; i++) {
                        int nbTentative = 0;
                        do {
                            direction = Math.random();
                            if (direction < 0.5) {
                                // Vertical
                                x = (int) (Math.random() * sizeX);
                                y = (int) (Math.random() * (sizeY - 4));
                                direction = Bateau.VERTICAL;
                            } else {
                                // Horizontal
                                x = (int) (3 + Math.random() * (sizeX - 4));
                                y = (int) (Math.random() * (sizeY - 4));
                                direction = Bateau.HORIZONTAL;
                            }
                            reussi = plateau.poser(x, y, (int) direction, Bateau.CROISEUR);
                        } while (!reussi && nbTentative++ < tentativeMax);
                    }
                if (reussi)
                    for (int i = 0; i < nbContreTorpilleur; i++) {
                        int nbTentative = 0;
                        do {
                            direction = Math.random();
                            if (direction < 0.5) {
                                // Vertical
                                x = (int) (Math.random() * sizeX);
                                y = (int) (Math.random() * (sizeY - 3));
                                direction = Bateau.VERTICAL;
                            } else {
                                // Horizontal
                                x = (int) (2 + Math.random() * (sizeX - 3));
                                y = (int) (Math.random() * (sizeY - 3));
                                direction = Bateau.HORIZONTAL;
                            }
                            reussi = plateau.poser(x, y, (int) direction, Bateau.CONTRE_TORPILLEUR);
                        } while (!reussi && nbTentative++ < tentativeMax);
                    }
                if (reussi)
                    for (int i = 0; i < nbTorpilleur; i++) {
                        int nbTentative = 0;
                        do {
                            direction = Math.random();
                            if (direction < 0.5) {
                                // Vertical
                                x = (int) (Math.random() * sizeX);
                                y = (int) (Math.random() * (sizeY - 2));
                                direction = Bateau.VERTICAL;
                            } else {
                                // Horizontal
                                x = (int) (1 + Math.random() * (sizeX - 2));
                                y = (int) (Math.random() * (sizeY - 2));
                                direction = Bateau.HORIZONTAL;
                            }
                            reussi = plateau.poser(x, y, (int) direction, Bateau.TORPILLEUR);
                        } while (!reussi && nbTentative++ < tentativeMax);
                    }
            } while (!reussi);
        }
    }

}