/**
*
 @author Janssens Thibaut - IPL 6/10/15
*
**/

public class MultiplicationA1{

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
	
		int score = 0, points, nombreDeMultiplication = 0;
		double pourcentage;
		char continuer = 'O';
		
		
		while (continuer == 'O' || continuer == 'o'){
			points = resultatUneMultiplication();
			score = score + points;
			nombreDeMultiplication ++;
			System.out.println("Voulez-vous continuer à faire des calculs? O pour continuer.");
			continuer = scanner.next().charAt(0);
		}
		
		pourcentage = ((double)score / nombreDeMultiplication) * 100;
		System.out.println("Voici ton score : " + score + "/"+ nombreDeMultiplication + "(" + pourcentage + "%)");
	}

	

	public static int resultatUneMultiplication(){
		
		int premierNombre, secondNombre, reponseCorrecte, reponseEleve;

		System.out.println ("Voici un exercice :");
		premierNombre   = unEntierAuHasardEntre (0, 10);
		secondNombre    = unEntierAuHasardEntre (0, 10);
		reponseCorrecte = premierNombre * secondNombre;
		System.out.println ("Calcule: " + premierNombre + "x" + secondNombre + "=");
		reponseEleve = scanner.nextInt(); 

		if (reponseEleve == reponseCorrecte) {
			System.out.println("Tres bien");
			return 1;
		} else {
			System.out.println("Non, c'etait : " + reponseCorrecte);
			return 0;
		}

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