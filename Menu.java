
// Menu
// Gloria, Quentin, Hawa
import java.io.* ;

public class Menu
	{

	public static void main(String[] args) throws IOException
		{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)) ;
        
        int menu = 0 ;
        int confirm = 0 ; 
        boolean erreur = false ;
          
        Methode methode = new Methode() ;
  
   
        do
        {
		   	do 
		   	{
				try
					{ 
					System.out.println("================") ;		
					System.out.println("BATAILLE NAVALLE") ;
					System.out.println("================\n\n") ;
					System.out.println("MENU\n") ;
					System.out.println("1. Jouer contre l'ordinateur\n") ;
					System.out.println("2. Regles\n") ;			
					System.out.println("3. Quitter le jeu\n\n") ;
					System.out.println("Quel est votre choix ?") ;
					menu = Integer.parseInt(in.readLine()) ;
					}
				catch (NumberFormatException e)
					{
					System.out.println("\nVeuillez entrer un entier entre 1 et 3\n");
					erreur = true ;	
					}
			}					
			while (erreur != false && (menu < 1 || menu > 3)) ;
			
			
			switch (menu) 
				{
				case 1 :
					{
					Moyen moyen = new Moyen() ;
					confirm = methode.Quitter(confirm) ;	
					}
				break ;				
							
				case 2 :
					{
					Regles regles = new Regles() ;
					confirm = methode.Quitter(confirm) ;		
					}
				break ;	
				
				case 4 :
					{
					confirm = methode.Quitter(confirm) ;	
					}
				break ;
				}
		
		}
		while (confirm != 2) ;
        
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n") ;
        System.out.println("===============");
        System.out.println("BATAILLE NAVALE");
        System.out.println("===============");
        System.out.println("\nVersion :\t2.0");
        System.out.println("\nAuteur : \tZufferey Matthieu\n\n");
        System.out.println("\nCopyright 2000 Zufferey Matthieu\n\n\n\n\n\n\n\n");
                     
        System.exit(0) ;                   
        
		}
						
	}
