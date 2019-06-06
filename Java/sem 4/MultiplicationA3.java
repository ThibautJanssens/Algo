/**
*
 @author Janssens Thibaut - IPL 6/10/15
*
**/
public class MultiplicationA3{

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
	
		int score, points;
		score = 0;
		System.out.println("Entrainement aux multiplications. Voici 5 exercices :");	
		while (score < 5) {
			points = resultatUneMultiplication();
			score += points;
		}
		System.out.println("Voici ton score : " + score);
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
			while(reponseEleve != reponseCorrecte){
				System.out.println ("Calcule: " + premierNombre + "x" + secondNombre + "=");
				reponseEleve = scanner.nextInt(); 	
				if (reponseEleve == reponseCorrecte)
					System.out.println("Voila.");
				else
					System.out.println("Non.");
			}
		}
		return 0;
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