/*******************************************************************************************

 Nom du programme	: Regles.java
 Auteur				: Zufferey Matthieu, 1hc
 Version			: 2.0			
 Date				: 10 mars 2002			
 Description		: Ce sont les règles du jeu bataille navale
 Préconditions		: Aucune
 
********************************************************************************************/

import java.io.* ;

public class Regles
	{

	Regles() throws IOException
		{
           	
			System.out.println("===============") ;
			System.out.println(" REGLES DU JEU ") ;
			System.out.println("===============\n") ;
			System.out.println("- 5 bateaux a placer, 1 a 5 cases, 1 a 4, 2 a 3 et 1 a 2\n") ;
			System.out.println("- Placer les bateaux les uns apres les autres\n") ;
			System.out.println("- Choisissez si vous le voulez sur la longueur ou la hauteur\n") ;
			System.out.println("- Entrez les coordonnees qui correspondent au point sommet du bateau\n\n") ;
			System.out.println("Conseil : evitez de placer vos bateaux trop prets les uns des autres\n\n\n") ;	
        
		}
						
	}
