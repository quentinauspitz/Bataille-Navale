
import java.io.* ;


public class Utilisateur
{
	public static void main (String [] args) throws IOException
	{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)) ;
		Methode fonction = new Methode() ;

		//Création de toutes les variables
		String grille[][] = new String[16][16] ;
		String grilleOrdi[][] = new String[16][16] ;
		String grilleCachee[][] = new String[16][16] ;
		String adversaire = "" ;
		String vous = "" ;
		int confirm = 0 ;
		int ligne = 0 ;
		int colonne = 0 ;
		int i = 0 ;
		int coordonnee = 0 ;
		int compteur = 1 ;
		int touche = 0 ;
		int toucheA = 0 ;
		int ok = 0 ;
		int ln = 0 ;
		int col = 0 ;
		boolean erreur = false ;


		//Création des deux grilles de jeu
		//D'abord les étoiles
		for (i = 0 ; i < 16 ; i++)
		{
			for (int j = 0 ; j < 16 ; j++)
			{
				grille[i][j] = "* " ;
				grilleOrdi[i][j] = "* " ;
				grilleCachee[i][j] = "* " ;
			}
		}

		//Puis les nombres
		for (i = 0 ; i < 16 ; i++)
		{
			grille[i][0] = i + "" ;
			grille[0][i] = i + "" ;
			grilleOrdi[i][0] = i + "" ;
			grilleOrdi[0][i] = i + "" ;
			grilleCachee[i][0] = i + "" ;
			grilleCachee[0][i] = i + "" ;
		}


		//Titre de la partie
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n=================================") ;
		System.out.println("JOUER CONTRE L'ORDINATEUR") ;
		System.out.println("=================================\n") ;


		//Nom du joueur humain
		System.out.println("\nEntrez votre nom") ;
		vous = in.readLine() ;


		/************************
		 Les bateaux du joueur humain
		 ************************/

		//Appelle la fonction qui gere le placement des bateaux du joueur humain
		fonction.User(grille, vous) ;


		System.out.println() ;






		//Boucle qui répète tant que tout les ateaux du joueur 1 ou du joueur 2 sont
		//coulés
		do
		{
			//Affiche un titre
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n   " + vous.toUpperCase() + "              " + adversaire + "\n") ;

			//Affiche les deux grilles de jeu
			fonction.SecondPrint(grille, grilleOrdi) ;

			//Compteur mod 2 pour que les joueurs jouent chacun à leur tour.
			if((compteur % 2) == 1)
			{
				do
				{
					//Appelle la fonction d'entree de coordonnee pour la ligne
					ligne = fonction.Ligne(ligne) ;
					//Puis de la colonne
					colonne = fonction.Colonne(colonne) ;
				}
				while (grilleOrdi[ligne][colonne] == " " || grilleOrdi[ligne][colonne] == "X") ;


				//Ce sont les entrees pour savoir si vous avez touche votre adversairer ou
				//non + gestion des entrees de caractetres, non autorisees
				do
				{
					erreur = false ;

					try
					{
						do
						{
							System.out.println("\n1. touche,  2. plouf") ;
							ok = Integer.parseInt(in.readLine()) ;
						}
						while (ok < 1 || ok > 2) ;
					}
					catch (NumberFormatException e)
					{
						erreur = true ;
					}
				}
				while(erreur != false) ;


				if (ok == 1)
				{
					grilleOrdi[ligne][colonne] = "X" ;
					touche = touche + 1 ;
				}
				else
				{
					grilleOrdi[ligne][colonne] = " " ;
				}

				compteur = compteur + 1 ;
			}

			else
			{

				do
				{
					//Appelle la fonction d'entree de coordonnee pour la ligne
					ligne = fonction.Ligne(ligne) ;
					//Puis de la colonne
					colonne = fonction.Colonne(colonne) ;
				}
				while (grille[ligne][colonne] == " " || grille[ligne][colonne] == "X") ;


				if (grille[ligne][colonne] == "* ")
				{
					grille[ligne][colonne] = " " ;
				}
				else if (grille[ligne][colonne] == "\04")
				{
					grille[ligne][colonne] = "X" ;
					toucheA = toucheA + 1 ;
				}

				compteur = compteur + 1 ;
			}
		}
		while(touche != 17 && toucheA != 17) ;

		//Affiche un titre
		System.out.println("   " + vous.toUpperCase() + "              " + adversaire + "\n") ;

		//Affiche les deux grilles de jeu
		fonction.SecondPrint(grille, grilleOrdi) ;

		//Vous dis si vous avez perdu ou gagner
		if (toucheA == 17)
		{
			fonction.SecondPrint(grille, grilleCachee) ;
			System.out.println("\n" + vous + " : vous avez gagne\n") ;
		}
		else
		{
			fonction.SecondPrint(grille, grilleCachee) ;
			System.out.println("\n" + vous + " : vous avez perdu\n") ;
		}

		System.out.println() ;


		System.exit(0) ;

	}

}

