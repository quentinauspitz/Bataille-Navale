/**
 *  Auteurs : Gloria_Quentin_Hawa
 */

import java.io.* ;

public class Moyen
{

	Moyen() throws IOException
	{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)) ;
		Methode fonction = new Methode() ;

		String grille[][] = new String[16][16] ;
		String grilleOrdi[][] = new String[16][16] ;
		String grilleCachee[][] = new String[16][16] ;
		String vous = "";
		String adversaire = "" ;
		int ligne = 0 ;
		int colonne = 0 ;
		int coordonnee = 0 ;
		int compteur = 1 ;
		int touche = 0 ;
		int toucheA = 0 ;
		int col = 0 ;
		int ln = 0 ;
		int choix = 0 ;
		int ok  = 0 ;
		int continuer = 0 ;
		int ligneDevinee = 0 ;
		int colonneDevinee = 0 ;

		//Création des deux grilles de jeu
		for (int i = 0 ; i < 16 ; i++)
		{
			for (int j = 0 ; j < 16 ; j++)
			{
				grille[i][j] = "* " ;
				grilleOrdi[i][j] = "* " ;
				grilleCachee[i][j] = "* " ;
			}
		}

		for (int i = 0 ; i < 16 ; i++)
		{
			grille[i][0] = i + " " ;
			grille[0][i] = i + " " ;
			grilleOrdi[i][0] = i + " " ;
			grilleOrdi[0][i] = i + " " ;
			grilleCachee[i][0] = i + " " ;
			grilleCachee[0][i] = i + " " ;
		}

		/**********************
		 Les bateaux de l'ordi
		 ***********************/

		fonction.Ordi(grilleOrdi) ;

		/***************************************************************************
		 Les bateaux du joueur 1
		 ***************************************************************************/

		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n=====================================")  ;
		System.out.println("JOUER CONTRE L'ORDINATEUR") ;
		System.out.println("=====================================") ;

		System.out.println("\n\nEntrez votre nom") ;
		vous = in.readLine() ;
		System.out.println() ;

		fonction.User(grille, vous) ;

		do
		{

			System.out.println("   " + vous.toUpperCase() + "              " + "l'ordi" + "\n") ;

			fonction.SecondPrint(grille, grilleCachee) ;


			if (compteur % 2 == 1)
			{
				do
				{
					ligneDevinee = fonction.Ligne(ligneDevinee) ;
					colonneDevinee = fonction.Colonne(colonneDevinee) ;
				}
				while (grilleCachee[ligneDevinee][colonneDevinee] == " " || grilleCachee[ligneDevinee][colonneDevinee] == "X") ;

				if (grilleOrdi[ligneDevinee][colonneDevinee] == "* ")
				{
					grilleCachee[ligneDevinee][colonneDevinee] = " " ;
				}
				else if (grilleOrdi[ligneDevinee][colonneDevinee] == "\04")
				{
					grilleCachee[ligneDevinee][colonneDevinee] = "X" ;
					toucheA = toucheA + 1 ;
				}

				compteur = compteur + 1 ;
			}
			else
			{
				if(continuer == 0)
				{
					do
					{
						ligne = (int)(Math.random() * (15) + 1) ;
						colonne = (int)(Math.random() * (15) + 1) ;
					}
					while(grille[ligne][colonne] == " " || grille[ligne][colonne] == "X") ;


					if (grille[ligne][colonne] == "* ")
					{
						grille[ligne][colonne] = " " ;
						continuer = 0 ;
					}
					else if (grille[ligne][colonne] == "\04")
					{
						grille[ligne][colonne] = "X" ;
						touche = touche + 1 ;
						continuer = 1 ;
						ln = ligne ;
						col = colonne ;
						choix = 1 ;
					}
				}
				else
				{
					if (choix == 1 && ln - 1 == 0)
					{
						choix = choix + 1 ;
						ln = ligne ;
						col = colonne ;
						continuer = 1;
					}
					if (choix == 2 && col - 1 == 0)
					{
						choix = choix + 1 ;
						col = colonne ;
						ln = ligne ;
						continuer = 1 ;
					}
					if(choix == 3 && col + 1 == 16)
					{
						choix = choix + 1 ;
						col = colonne ;
						ln = ligne ;
						continuer = 1 ;
					}
					if(choix == 4 && ln + 1 == 16)
					{
						choix = 0 ;
						col = colonne ;
						ln = ligne ;
						continuer = 0 ;
					}

					switch (choix)
					{
						case 1 :
						{
							if (grille[ln-1][col] != "\04" && grille[ln-1][col] != "X")
							{
								grille[ln-1][col] = " " ;
								choix = choix + 1 ;
								ln = ligne ;
								col = colonne ;
								continuer = 1;
							}
							else if (grille[ln-1][col] == "\04")
							{
								grille[ln-1][col] = "X" ;
								touche = touche + 1 ;
								ln = ln - 1 ;
								col = col ;
								continuer = 1;
							}
							else if(grille[ln-1][col] == "X")
							{
								ln = ln - 1 ;
								col = col ;
							}
						}
						break ;

						case 2 :
						{
							if (grille[ln][col-1] != "\04" && grille[ln][col-1] != "X")
							{
								grille[ln][col-1] = " " ;
								choix = choix + 1 ;
								ln = ligne ;
								col = colonne ;
								continuer = 1;
							}
							else if (grille[ln][col-1] == "\04")
							{
								grille[ln][col-1] = "X" ;
								touche = touche + 1 ;
								ln = ln ;
								col = col - 1 ;
								continuer = 1;
							}
							else if(grille[ln][col-1] == "X")
							{
								ln = ln ;
								col = col - 1 ;
							}
						}
						break ;


						case 3 :
						{
							if (grille[ln][col+1] != "\04" && grille[ln][col+1] != "X")
							{
								grille[ln][col+1] = " " ;
								choix = choix + 1 ;
								ln = ligne ;
								col = colonne ;
								continuer = 1;
							}
							else if (grille[ln][col+1] == "\04")
							{
								grille[ln][col+1] = "X" ;
								touche = touche + 1 ;
								ln = ln ;
								col = col+1 ;
								continuer = 1;
							}
							else if(grille[ln][col+1] == "X")
							{
								ln = ln ;
								col = col + 1 ;
							}
						}
						break ;


						case 4 :
						{
							if (grille[ln+1][col] != "\04" && grille[ln+1][col] != "X")
							{
								grille[ln+1][col] = " " ;
								choix = 0 ;
								ok = 0 ;
								ln = ligne ;
								col = colonne ;
								continuer = 0 ;
							}
							else if (grille[ln+1][col] == "\04")
							{
								grille[ln+1][col] = "X" ;
								touche = touche + 1 ;
								ln = ln + 1 ;
								col = col ;
								continuer = 1;
							}
							else if(grille[ln+1][col] == "X")
							{
								ln = ln + 1;
								col = col ;
							}
						}
						break ;


					}
				}
				compteur = compteur + 1 ;
			}

		}
		while(touche != 17 && toucheA != 17) ;

		if (toucheA == 17)
		{
			fonction.SecondPrint(grille, grilleCachee) ;
			System.out.println(vous + " : vous avez gagne") ;

		}
		else
		{
			fonction.SecondPrint(grille, grilleCachee) ;
			System.out.println(vous + " : vous avez perdu") ;
		}

	}
}