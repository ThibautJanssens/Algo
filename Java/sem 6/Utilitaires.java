/**
 * 
 * @author Janssens Thibaut - IPL - 20/10/2015
 * 
 */
import java.util.Scanner;


public class Utilitaires {
	public static Scanner scanner = new Scanner(System.in);
	
	/**
	 * Lit un caractère au clavier tant que l'utilisateur n'a
	 * pas répondu 'O' ou 'N'
	 * @return
	 */
	public static char lireOouN(){
		char reponse=scanner.next().charAt(0);
		
		while (reponse !='O' && reponse !='N'){
			System.out.println("Répondez O ou N");
			reponse=scanner.next().charAt(0);
		}
		return reponse;
	}
	
	public static int lancerDe() {
		double reel;
		int resultat;
		
		reel = Math.random();
		resultat = (int) (reel * (6)) + 1;
		return resultat;
	}
	
	public static void afficherTable(int[] table){
		for (int i = 0; i < table.length; i++) {
			System.out.print(" "+table[i]);
		}		
	}
	
	public static int lireEntierPositif(){
	    int nombre;
	   
	    nombre = scanner.nextInt();     
	    
	    while (nombre < 0 ){
	        System.out.println("Le nombre doit etre positif.");
	        nombre  = scanner.nextInt();
	    }
	    return nombre;
	}
	public static int lireEntierPositifAvecMax(int valeurMax){
	    int nombre;
	    
	    nombre = scanner.nextInt();     
	    
	    while (nombre < 0 || nombre > valeurMax ){
	        System.out.println("Le nombre doit etre positif et ne pas exéder " + valeurMax +" .");
	        nombre  = scanner.nextInt();
	    }
	    return nombre;
	}
	
	public static double calculFacture(int nbreAppels, int tarifAvant19H, int tarifApres19H){
		double facture = 0;
		
		for (int i = 1; i <= nbreAppels; i++){
	        System.out.println("Entrez le nombre d'heures de l'appel numero " + i);
	        int nombreDHeures = Utilitaires.lireEntierPositif();
	        System.out.println("Entrez le nombre de minutes de l'appel.");
	        int nombreDeMinutes = Utilitaires.lireEntierPositifAvecMax(59);
	        System.out.println("Entrez le nombre de secondes de l'appel.");
	        int nombreDeSecondes = Utilitaires.lireEntierPositifAvecMax(59);
	        System.out.println("Entrez l'heure de l'appel.");
	        int heureDeLAppel = Utilitaires.lireEntierPositifAvecMax(23);
	        if (heureDeLAppel<19)
	            facture += (nombreDHeures*3600+nombreDeMinutes*60+nombreDeSecondes)/60.0*tarifAvant19H;
	        else
	            facture += (nombreDHeures*3600+nombreDeMinutes*60+nombreDeSecondes)/60.0*tarifApres19H;
	    }
		return facture;
	}
}
