/**
*
 @author Janssens Thibaut - IPL 6/10/15
*
**/

public class C1{

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		boolean continuer = true;
		while(continuer == true){
			faireUneMultiplication();		
			continuer = continuerOouN();
		}
	}

	

	public static void faireUneMultiplication(){
		
		int premierNombre, secondNombre, reponseCorrecte, reponseEleve;

		System.out.println ("Voici un exercice :");
		premierNombre   = unEntierAuHasardEntre (0, 10);
		secondNombre    = unEntierAuHasardEntre (0, 10);
		reponseCorrecte = premierNombre * secondNombre;
		System.out.println ("Calcule: " + premierNombre + "x" + secondNombre + "=");
		reponseEleve = scanner.nextInt(); 

		while (reponseEleve != reponseCorrecte) {
			System.out.println ("Calcule: " + premierNombre + "x" + secondNombre + "=");
			reponseEleve = scanner.nextInt();
		} 
		System.out.println("Très bien.");
	}

	public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
		double nombreReel;
		int resultat;

		nombreReel = Math.random();
		resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1))
								+ valeurMinimale;
		return resultat;
	}
	
	public static boolean continuerOouN(){
		char continuer = 'o';
		
		while (continuer != 'o'|| continuer != 'O' || continuer != 'n' || continuer != 'N'){
		System.out.println("Voulez-vous continuer? (O ou N)");
		continuer = scanner.next().charAt(0);
		if (continuer =='N' || continuer =='n')
			return false;
		else
			return true;
		}	
		return false;
	}
}