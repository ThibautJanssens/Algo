/**
 * 
 * @author Janssens Thibaut IPL - 21/09/15
 * @version 21/09/15
 *
 */
public class OperationArithmetique {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Choississez votre type d'exercice.");
		System.out.println("1: Addition \n2: Soustraction \n3: Multiplication  \n4: Division");
		int choix = scanner.nextInt();
		
		switch (choix) {
		
		case 1:
			faireUneAddition();
			break;
		
		case 2:
			faireUneSoustraction();
			break;
		
		case 3:
			faireUneMultiplication();
			break;
		
		case 4:
			faireUneDivision();
			break;
		
		default:
			break;
		}
	}
	
	
	public static void faireUneMultiplication(){

		int premierNombre, secondNombre, reponseCorrecte, reponseEleve;

		System.out.println ("Voici une multiplication :");
		premierNombre   = unEntierAuHasardEntre (1, 100);
		secondNombre    = unEntierAuHasardEntre (1, 100);
		reponseCorrecte = premierNombre * secondNombre;
		System.out.print("Calcule: " + premierNombre + " x " + secondNombre + " = ");
		reponseEleve = scanner.nextInt(); 

		if (reponseEleve == reponseCorrecte) {
			System.out.println("Très bien");
		} else {
			System.out.println("Non, c'était : " + reponseCorrecte);
		}

	}
	
	public static void faireUneAddition(){
		int premierNombre, secondNombre, reponseCorrecte, reponseEleve;

		System.out.println ("Voici une addition :");
		premierNombre   = unEntierAuHasardEntre (1, 100);
		secondNombre    = unEntierAuHasardEntre (1, 100);
		reponseCorrecte = premierNombre + secondNombre;
		System.out.print("Calcule: " + premierNombre + " + " + secondNombre + " = ");
		reponseEleve = scanner.nextInt(); 

		if (reponseEleve == reponseCorrecte) 
			System.out.println("Très bien");
		else
			System.out.println("Non, c'était : " + reponseCorrecte);
	}
	
	public static void faireUneSoustraction(){
		int premierNombre, secondNombre, reponseCorrecte, reponseEleve;

		System.out.println ("Voici une soustraction :");
		premierNombre   = unEntierAuHasardEntre (1, 100);
		secondNombre    = unEntierAuHasardEntre (1, 100);
		reponseCorrecte = premierNombre - secondNombre;
		System.out.print("Calcule: " + premierNombre + " - " + secondNombre + " = ");
		reponseEleve = scanner.nextInt(); 

		if (reponseEleve == reponseCorrecte) 
			System.out.println("Très bien");
		else
			System.out.println("Non, c'était : " + reponseCorrecte);
	}
	
	public static void faireUneDivision(){
		int premierNombre, secondNombre, reponseCorrecte, reponseEleve;

		System.out.println ("Voici une addition :");
		premierNombre   = unEntierAuHasardEntre (1, 10);
		secondNombre    = unEntierAuHasardEntre (1, 10);
		reponseCorrecte = premierNombre * secondNombre;
		System.out.print("Calcule: " + reponseCorrecte + " / " + secondNombre + " = ");
		reponseEleve = scanner.nextInt(); 

		if (reponseEleve == premierNombre) 
			System.out.println("Très bien");
		else
			System.out.println("Non, c'était : " + premierNombre);
	}
	
	public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
		double nombreReel;
		int resultat;

		nombreReel = Math.random();
		resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
		return resultat;
	}
}
