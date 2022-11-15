/*******************************************************************************************

 Nom du programme	: Utilisateur.java
 Auteur				: Zufferey Matthieu, 1hc			
 Version 			: 2.0
 Date				: 24 mars 2002			
 Description		: C'est le niveau utilisateur contre utilisateur du jeu bataille navale
 Pr�conditions		: Aucune
 
********************************************************************************************/


import java.io.* ;


public class Utilisateur
	{
	public static void main (String [] args) throws IOException
		{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)) ;
		Methode fonction = new Methode() ;

		//Cr�ation de toutes les variables	
		String grille[][] = new String[11][11] ;
        String grilleOrdi[][] = new String[11][11] ;
        String grilleCachee[][] = new String[11][11] ; 
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


	    //Cr�ation des deux grilles de jeu
	    //D'abord les �toiles
	    for (i = 0 ; i < 11 ; i++)
	        {
	       	for (int j = 0 ; j < 11 ; j++)
	        	{
	        	grille[i][j] = "*" ;
	        	grilleOrdi[i][j] = "*" ;
	        	grilleCachee[i][j] = "*" ;
	        	}	
	        }
	     
	    //Puis les nombres                   
		for (i = 0 ; i < 11 ; i++) 
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
		System.out.println("JOUER CONTRE UN AUTRE UTILISATEUR") ;
		System.out.println("=================================\n") ;
		
		
		//Nom du joueur 1	
		System.out.println("\nEntrez votre nom") ;
		vous = in.readLine() ;
		
	
		/************************
		 Les b�teaux du joueur 1
		************************/
		
		//Appelle la fonction qui g�re le placement des bateaux du joueur 1			
		fonction.User(grille, vous) ;
		
		
		System.out.println() ;			
		
		
		//Entrer le nom de l'adversaire
		System.out.println("\n\nEntrez le nom de votre adversaire !") ;
		adversaire = in.readLine() ;


		//Demande entre le joueur 1 et le joueur 2 pour savoir qui commence
		do
			{
			erreur = false ;	
				
			try
				{
				do
					{
					System.out.println("\nQui commence : 1. "+ vous + "    2. " + adversaire) ;
					compteur = Integer.parseInt(in.readLine()) ;
					}
				while (compteur < 1 || compteur > 2) ;
				}
			catch (NumberFormatException e)
				{
				erreur = true ;	
				}
			}
		while(erreur != false) ;										
		
		//Boucle qui r�p�te tant que tout les b�teaux du joueur 1 ou du joueur 2 sont
		//coul�s			
		do
			{
			//Affiche un titre
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n   " + vous.toUpperCase() + "              " + adversaire + "\n") ;
			
			//Affiche les deux grilles de jeu
			fonction.SecondPrint(grille, grilleOrdi) ;
	
			//Compteur mod 2 pour que les joueurs jouent chacun � leur tour.	
			if((compteur % 2) == 1)
				{
				do
					{
					//Appelle la fonction d'entr�e de coordonn�e pour la ligne					
					ligne = fonction.Ligne(ligne) ;
					//Puis de la colonne
					colonne = fonction.Colonne(colonne) ;
					}
				while (grilleOrdi[ligne][colonne] == " " || grilleOrdi[ligne][colonne] == "X") ;
				
				
				//Ce sont les entr�es pour savoir si vous avez touch� votre adversairer ou
				//non + gestion des entr�es de caract�tres, non autoris�es			
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
					//Appelle la fonction d'entr�e de coordonn�e pour la ligne	
					ligne = fonction.Ligne(ligne) ;
					//Puis de la colonne
					colonne = fonction.Colonne(colonne) ;
					}
				while (grille[ligne][colonne] == " " || grille[ligne][colonne] == "X") ;
	
	
				if (grille[ligne][colonne] == "*")
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


