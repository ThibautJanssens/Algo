/**
*
 @author Janssens Thibaut - IPL 6/10/15
*
**/

public class MultiplicationA2{

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		char continuer = 'o';
		while(continuer == 'o' || continuer == 'O'){
		
			faireUneMultiplication();		
			System.out.println("Voulez-vous faire une autre multiplication? O pour continuer.");
			continuer = scanner.next().charAt(0);
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
}