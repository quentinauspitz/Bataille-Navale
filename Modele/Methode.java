package Modele;// Modele.Methode

import javax.swing.* ;
import java.io.* ;

public class Methode
	{
	public int Coordonnee(int a) throws IOException //1.longeur, 2.hauteur
		{
		//Gere l'entree en longueur ou en hauteur des bateaux
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)) ;
		
		boolean erreur ;
		
		do
			{
			erreur = false ;
					
			try
				{
				do 
					{
					System.out.println("Le voulez-vous en :\n1. longeur\n2. hauteur") ;
					a = Integer.parseInt(in.readLine()) ;
					}
				while (a < 1 || a > 2) ;
				}
			catch (NumberFormatException e)
				{
				System.out.println("Veuillez entrer un entier\n");
				erreur = true ;	
				}
			
			}
		while(erreur != false) ;	
			
		return a ; 

		}
		
	public int Ligne(int a) throws IOException // ligne de depart
		{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)) ;
		
		boolean erreur = false ;
			
		do
			{
			erreur = false ;	
				
			try
				{
				do
					{
					System.out.println("\nEntrez la ligne de depart") ;
					a = Integer.parseInt(in.readLine()) ;
					}
				while (a < 1 || a > 15) ;
				}
			catch (NumberFormatException e)
				{
				System.out.println("Veuillez entrer un entier entre 1 et 10\n");
				erreur = true ;	
				}				
			}
		while(erreur != false) ;	
		
		return a ;
		}
		
	public int Colonne(int a) throws IOException // colonne de depart
		{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)) ;
		
		boolean erreur = false ;
		
		do
			{
			erreur = false ;	
				
			try
				{
				do
					{
					System.out.println("\nEntrez la colonne de depart") ;
					a = Integer.parseInt(in.readLine()) ;
					}
				while (a < 1 || a > 15) ;
				}
			catch (NumberFormatException e)
				{
				System.out.println("Veuillez entrer un entier entre 1 et 15\n");
				erreur = true ;	
				}			
			}
		while(erreur != false) ;
			
		return a ;
		}	
		
	public void FirstPrint(String a [][]) // Affiche la grille quand vous placez les bateaux
		{
		for (int i = 0 ; i < 16 ; i++)
			{
				for (int j = 0 ; j < 16 ; j++)
					{
					if (j == 0 && i == 0)
						{
						System.out.print("   ") ;
						}
					else if(j == 0 && i == 15)
						{
							System.out.print(a[i][j] + " ") ;
							}
						 else if(j == 0 && i > 0)
								{
								System.out.print(a[i][j] + "  ") ;	
								}
							  else
				 				{
								System.out.print(a[i][j]) ;					
								}
					}
		
			System.out.println() ;	
			} 
	
		System.out.println() ;	
		}
		
			
	public void SecondPrint(String a [][], String b [][]) // Affiche les deux grilles, cotes a cotes
		{	
		for (int i = 0 ; i < 16 ; i++)
			{
			for (int j = 0 ; j < 16 ; j++)
				{
				if (j == 0 && i == 0)
					{
					System.out.print("   ") ;	
					}
				else 	
					{
						if (j == 0 && i == 15)
							{
							System.out.print(a[i][j] + " ") ;		
							}
						else 
							{	
								if(j == 0)
									{
									System.out.print(a[i][j] + "  ") ;	
									}
								else
									{
									System.out.print(a[i][j]) ;		
									}
							}
					}
				}
		
			System.out.print("         ") ;	
			
			for (int k = 0 ; k < 16 ; k++)
				{
				if (i == 0 && k == 0)
					{
					System.out.print("  ") ;	
					}
				else 	
					{
						if (k == 0 && i == 15)
							{
							System.out.print(b[i][k] + " ") ;		
							}
						else 
							{	
								if(k == 0)
									{
									System.out.print(b[i][k] + "  ") ;	
									}
								else
									{
									System.out.print(b[i][k]) ;		
									}
							}
					}
				}				
			System.out.println() ;	
			}	
		
		System.out.println() ;	
		}
	
	public void Bateau(String [][] grille, int nbre) throws IOException
		{
			
		Methode fonction = new Methode() ;
		
		int erreur = 0 ;
		int coordonnee = 0 ;
		
		int ligne = 0 ;
		int colonne = 0 ;
		int i = 0 ;
		
		coordonnee = fonction.Coordonnee(coordonnee) ;		
		
		do
		{
			erreur = 1 ;
			
			ligne = fonction.Ligne(ligne) ;
			
			colonne = fonction.Colonne(colonne) ;
		
		
			switch (coordonnee)
				{
					case 1 :
						{
						
						if((colonne + nbre) > 11)
							{
							erreur = 0 ;	
							}
						else
							{
							do
								{
								i = colonne ;
								
								for (int j = colonne ; j < (colonne + nbre) ; j++)
									{
									if(grille[ligne][j] == "\04")
										{
										erreur = 0 ;
										i = colonne + nbre ;
										}	
									}
								
								if (erreur != 0)
									{
									for (int j = colonne ; j < (colonne + nbre) ; j++)
										{
										grille[ligne][j] = "\04" ;
										
										}
									i = colonne + nbre ;		
									}	
								}
							while(i < colonne + nbre );
							}

						}
					break ;
				
					case 2 : 
						{
						if((ligne + nbre) > 16)
							{
							erreur = 0 ;	
							}
						else
							{
							do
								{
								i = ligne ;
								
								for (int j = ligne ; j < (ligne + nbre) ; j++)
									{
									if(grille[j][colonne] == "\04")
										{
										erreur = 0 ;
										i = ligne + nbre ;
										}	
									}
								
								if (erreur != 0)
									{
									for (int j = ligne ; j < (ligne + nbre) ; j++)
										{
										grille[j][colonne] = "\04" ;
										
										}
									i = ligne + nbre ;		
									}	
								}
							while(i < ligne + nbre);
							}	
						}
					break ;		
				}
		}
		while(erreur != 1) ;	
		}
		
	public void BateauOrdi(String grille [][], int nbre)	
		{
		
		int erreur = 0 ;
		
		do
		{
			int i = 0 ;
			int coordonnee = (int)(Math.random() * (2) + 1) ;
			int ligne = (int)(Math.random() * (15) + 1) ;
			int colonne = (int)(Math.random() * (15) + 1) ;
		
			erreur = 1 ;
		
			switch (coordonnee)
				{
					case 1 :
						{
						if((colonne + nbre) > 16)
							{
							erreur = 0 ;	
							}
						else
							{
							do
								{
								i = colonne ;
								
								for (int j = colonne ; j < (colonne + nbre) ; j++)
									{
									if(grille[ligne][j] == "\04")
										{
										erreur = 0 ;
										i = colonne + nbre ;
										}	
									}
								
								if (erreur != 0)
									{
									for (int j = colonne ; j < (colonne + nbre) ; j++)
										{
										grille[ligne][j] = "\04" ;
										
										}
									i = colonne + nbre ;		
									}	
								}
							while(i < colonne + nbre );
							}	
						}
					break ;
				
					case 2 : 
						{
						if((ligne + nbre) > 16)
							{
							erreur = 0 ;	
							}
						else
							{
							do
								{
								i = ligne ;
								
								for (int j = ligne ; j < (ligne + nbre) ; j++)
									{
									if(grille[j][colonne] == "\04")
										{
										erreur = 0 ;
										i = ligne + nbre ;
										}	
									}
								
								if (erreur != 0)
									{
									for (int j = ligne ; j < (ligne + nbre) ; j++)
										{
										grille[j][colonne] = "\04" ;
										
										}
									i = ligne + nbre ;		
									}	
								}
							while(i < ligne + nbre );
							}	
						}
					break ;		
				}
		}
		while(erreur != 1) ;
		
		
		}


	public int Quitter(int confirm) throws IOException
		{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)) ;
		
		do
			{
			System.out.println("\nSouhaitez-vous quitter le jeu ? (1. non / 2. oui)") ;
			confirm = Integer.parseInt(in.readLine()) ;
			}
		while (confirm < 1 || confirm > 2) ;
		
		return confirm ;		
		}
		
		
	public void User(String [][] grille, String vous) throws IOException
		{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)) ;
		
		Methode fonction = new Methode() ;
		int [] tabBat5 = new int[10] ;
		int [] tabBat4 = new int[8] ;
		int [] tabBat3a = new int[6] ;
		int [] tabBat3b = new int[6] ;
		int [] tabBat2 = new int[4] ;


		//Choix des coordonnees pour le bateau a 5 cases

		System.out.println("\n\n\n\n\n" + vous.toUpperCase() + " : COMPLETEZ VOTRE GRILLE DE JEU\n") ;
		System.out.println("Placer votre bateau a 5 cases\n") ;

		fonction.FirstPrint(grille) ;

		fonction.Bateau(grille, 5) ;

		//Choix des coordonn�es pour le bateau � 4 cases

		System.out.println("\n\n\n\n\n" + vous.toUpperCase() + " : COMPLETEZ VOTRE GRILLE DE JEU\n") ;
		System.out.println("Placer votre bateau a 4 cases\n") ;

		fonction.FirstPrint(grille) ;

		fonction.Bateau(grille, 4) ;

		//Choix des coordonn�es pour le premier bateau � 3 cases

		System.out.println("\n\n\n\n\n" + vous.toUpperCase() + " : COMPLETEZ VOTRE GRILLE DE JEU\n") ;
		System.out.println("Placer votre 1er bateau a 3 cases\n") ;

		fonction.FirstPrint(grille) ;

		fonction.Bateau(grille, 3) ;

		//Choix des coordonn�es pour le deuxi�me bateau � 3 cases

		System.out.println("\n\n\n\n\n" + vous.toUpperCase() + " : COMPLETEZ VOTRE GRILLE DE JEU\n") ;
		System.out.println("Placer votre 2 eme bateau a 3 cases\n") ;

		fonction.FirstPrint(grille) ;

		fonction.Bateau(grille, 3) ;

		//Choix des coordonn�es pour le bateau � 2 cases

		System.out.println("\n\n\n\n\n" + vous.toUpperCase() + " : COMPLETEZ VOTRE GRILLE DE JEU\n") ;
		System.out.println("Placer votre bateau a 2 cases\n") ;

		fonction.FirstPrint(grille) ;

		fonction.Bateau(grille, 2) ;

		}


	public void Ordi(String [][] grilleOrdi) throws IOException
		{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)) ;

		Methode fonction = new Methode() ;

		//Choix des coordonnees pour le cuirasse
		fonction.BateauOrdi(grilleOrdi, 7) ;
		//Choix des coordonnees pour le croiseur
		fonction.BateauOrdi(grilleOrdi, 5) ;
		//Choix des coordonnees pour le destroyer
		fonction.BateauOrdi(grilleOrdi, 3) ;
		//Choix des coordonnees pour le sous-marin
		fonction.BateauOrdi(grilleOrdi, 1) ;

		}
	public void Grille(int colonne, int ligne, String [][] grilleCachee) throws IOException
		{
			for (int i = 0 ; i < ligne ; i++)
				{
				for (int j = 0 ; j < colonne ; j++)
					{
						if(i == ligne-1 && colonne > 0)
							{
							System.out.print(grilleCachee[i][j]+ " ") ;
							}
						else if(i > 0 && j > 0 || j == (colonne-1))
						     {
							 System.out.print(grilleCachee[i][j]+ "  ") ;
							 }
							 else
							 {
							 System.out.print(grilleCachee[i][j]+ " ") ;
							 }
					}
				System.out.println() ;
				}


		}
	}
